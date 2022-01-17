 # DevOps
    Artigo: [integração contínua](https://docs.google.com/document/d/1cSqCWkuNbW-c7MS2D0o9ovjfYBSdCCvyi-kEkTnEBRM/edit?usp=sharing)

 # Linux Commands
    - ip address | mostra o ip da máquina

# Docker
## Comandos Docker
    * `docker pull [image_name]:[image_version]` - o parâmetro "image_version" é opcional por padrão será preenchido com "lastest"

    * `docker run -p [host_port]:[container_port] -e [environment_variables] -d [docker_image]` - o parâmetro -p define o binding de portas entre o host e o guest,  -e as varáveis de ambiente e o -d faz o detach do terminal 

    * `docker exec -it [container_id || container_name] /bin/bash` - conecta ao terminal do contêiner

#### Expor o deamon do docker para controle externo
    $ sudo mkdir -p /etc/systemd/system/docker.service.d/
    $ sudo vi /etc/systemd/system/docker.service.d/override.conf
    ```
    [Service]
    ExecStart=
    ExecStart=/usr/bin/dockerd -H fd:// -H tcp://0.0.0.0:2376
    ```
    $ sudo systemctl daemon-reload
    $ sudo systemctl restart docker.service

## Instalando Docker no linux
    1. $ sudo apt-get remove docker
    2. $ docker-engine docker.io

#### Depois, atualize o banco de dados de pacotes:
    3. sudo apt-get update

#### Agora, adicione ao sistema a chave GPG oficial do repositório do Docker:
    4. curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add

#### Adicione o repositório do Docker às fontes do APT:

    5. sudo add-apt-repository \
      "deb [arch=amd64] https://download.docker.com/linux/ubuntu \
      $(lsb_release -cs) \
      stable"

#### Atualize o banco de dados de pacotes, para ter acesso aos pacotes do Docker a partir do novo repositório adicionado:
    5. sudo apt-get update

#### Por fim, instale o pacote docker-ce:
    6. sudo apt-get install docker-ce docker-ce-cli containerd.io

#### Caso você queira, você pode verificar se o Docker foi instalado corretamente verificando a sua versão:
    7. sudo docker version
    
#### E para executar o Docker sem precisar de sudo, adicione o seu usuário ao grupo docker:
    8. sudo usermod -aG docker $(whoami)

## Docker-Machine
      'curl -L https://github.com/docker/machine/releases/download/v0.16.0/docker-machine-`uname -s`-`uname -m` >/tmp/docker-machine 
      &&
      chmod +x /tmp/docker-machine 
      &&
      sudo cp /tmp/docker-machine /usr/local/bin/docker-machine'

## Vagrant
    - vagrant plugin install vagrant-disksize | Com esse plugin e possivel criar uma máquina virtual com mais de 10gb
    - vagrant box list | lista as vms
    - vagrant ssh 

 ### Vagrant specificities
    > Todos os arquivos presentes na pasta do arquivo vagrant pode ser acessado pela VM, porém não aparece no comando ls da vm

    > Para executar arquivos presentes no host na VM adicione ./file_name na frente

## Passos para a configuracao do git e versionamento do codigo com o Jenkins
#### Criar uma chave ssh
    ˋˋˋ
    ssh-keygen -t rsa -b 4096 -C "<seu-usuario>@gmail.com"
    cat ~/.ssh/id_rsa.pub | pega essa chave pública e adicione no github
    ˋˋˋ
#### Configurar a chave no github
    ˋˋˋ
    git config --global user.name "<seu-usuario>"
    git config --global user.email <seu-usuario>@<seu-providor>
    ssh -T git@github.com
    ˋˋˋ
#### Fazer download do código nos anexos e copiar para o diretório compartilhado app
    ˋˋˋ
    cd /vagrant/projeto
    git init
    git add .
    git commit -m "Meu primeiro commit"
    git log
    ˋˋˋ
#### Criar um repositório no github: projeto
    git remote add origin git@github.com:<seu-usuario>/projeto.git
    git push -u origin master
#### Adiciona o usuario da vm e do jenkins no grupo do docker
     sudo usermod -aG docker $USER
     sudo usermid -aG docker jenkins

#### Validando a sintaxe do Dockerfile
    * $ docker run --rm -i hadolint/hadolint < Dockerfile
    * Build step 2: Build/Publish Docker Image