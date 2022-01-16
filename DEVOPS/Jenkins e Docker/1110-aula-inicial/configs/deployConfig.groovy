pipeline {
    environment {
        dockerImage = "${image}"
    }
    agent any

    stages {
        stage('Carregando o ENV de desenvolvimento') {
            steps {
                configFileProvider([configFile(fileId: '749d89e8-969c-4eeb-abfd-516cbdef02b1', variable: 'env')]) {
                    sh 'cat $env > .env'
                }
            }
        }
        stage('Derrubando o container antigo') {
            steps {
                script {
                    try {
                        sh 'docker rm -f djang0-todolist-dev'
                    } catch (Exception e) {
                        sh "echo $e"
                    }
                }
            }
        }        
        stage('Subindo o container novo') {
            steps {
                script {
                    try {
                        sh 'docker run -d -p 81:8000 -v /var/run/mysqld/mysqld.sock:/var/run/mysqld/mysqld.sock -v /var/lib/jenkins/workspace/jenkins-todo-list-desenvolvimento/.env:/usr/src/app/to_do/.env --name=djang0-todolist-dev ' + dockerImage + ':latest'
                    } catch (Exception e) {
                        slackSend (color: 'error', message: "[ FALHA ] Não foi possivel subir o container - ${BUILD_URL} em ${currentBuild.duration}s", tokenCredentialId: 'slack-token')
                        sh "echo $e"
                        currentBuild.result = 'ABORTED'
                        error('Erro')
                    }
                }
            }
        }
        stage('Notificando o usuario') {
            steps {
                slackSend (color: 'good', message: '[ Sucesso ] O novo build esta disponivel em: http://192.168.63.254:81/ ', tokenCredentialId: 'slack-token')
            }
        }
        stage ('Fazer o deploy em producao?') {
            steps {
                script {
                    slackSend (color: 'warning', message: "Para aplicar a mudança em produção, acesse [Janela de 10 minutos]: ${JOB_URL}", tokenCredentialId: 'slack-token')
                    timeout(time: 10, unit: 'MINUTES') {
                        input(id: "Deploy Gate", message: "Deploy em produção?", ok: 'Deploy')
                    }
                }
            }
        }
        stage (deploy) {
            steps {
                script {
                    try {
                        build job: 'todo-list-producao', parameters: [[$class: 'StringParameterValue', name: 'image', value: dockerImage]]
                    } catch (Exception e) {
                        slackSend (color: 'error', message: "[ FALHA ] Não foi possivel subir o container em producao - ${BUILD_URL}", tokenCredentialId: 'slack-token')
                        sh "echo $e"
                        currentBuild.result = 'ABORTED'
                        error('Erro')
                    }
                }
            }
        }
    }
}

// pipeline {
//     environment {
//         dockerImage = "${image}"
//     }
//     agent any

//     stages {
//         stage('Carregando o ENV de desenvolvimento') {
//             steps {
//                 configFileProvider([configFile(fileId: '749d89e8-969c-4eeb-abfd-516cbdef02b1', variable: 'env')]) {
//                     sh 'cat $env > .env'
//                 }
//             }
//         }
//         stage('Derrubando o container antigo') {
//             steps {
//                 script {
//                     try {
//                         sh 'docker rm -f djang0-todolist-dev'
//                     } catch (Exception e) {
//                         sh "echo $e"
//                     }
//                 }
//             }
//         }        
//         stage('Subindo o container novo') {
//             steps {
//                 script {
//                     try {
//                         sh 'docker run -d -p 81:8000 -v /var/run/mysqld/mysqld.sock:/var/run/mysqld/mysqld.sock -v /var/lib/jenkins/workspace/jenkins-todo-list-desenvolvimento/.env:/usr/src/app/to_do/.env --name=djang0-todolist-dev ' + dockerImage + ':latest'
//                     } catch (Exception e) {
//                         slackSend (color: 'error', message: "[ FALHA ] Não foi possivel subir o container - ${BUILD_URL} em ${currentBuild.duration}s", tokenCredentialId: 'slack-token')
//                         sh "echo $e"
//                         currentBuild.result = 'ABORTED'
//                         error('Erro')
//                     }
//                 }
//             }
//         }
//         stage('Notificando o usuario') {
//             steps {
//                 slackSend (color: 'good', message: '[ Sucesso ] O novo build esta disponivel em: http://192.168.63.254:81/', tokenCredentialId: 'slack-token')
//             }
//         }
//     }
// }