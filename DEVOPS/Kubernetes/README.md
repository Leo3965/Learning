## Kubernetes
    O Kubernetes cria e gerencia escalabilidade horizontal (orquestração de containers), onde temos várias máquinas trabalhando em conjunto (Cluster).

### Hierarchy
 - Master: 
   - Responsável por gerenciar o cluster
   - manter e atualizar o estado desejado
   - receber e executar novos comandos

 - Nodes: Responsável por executar os pods que possuem os containers (aplicações)

![Screenshot from 2022-01-31 13-38-24](https://user-images.githubusercontent.com/69876788/151837122-1526b9c8-c7e1-4865-9775-01e80abfc264.png)

### Resources
 > POD: Escapsula containers (conjunto de um ou mais containers). Sempre que um POD é criado ele recebe um endereço IP, e ele responde de acordo com os containers que estão dentro dele e respondem a aquela porta. Caso o container falhe o POD morre e o Kubernetes cria um novo pod para substituir o antigo, e não necessáriamente terá o mesmo endereço IP, PODs são efêmeros.
 
 > PV: Persistence volume for DataBases

 ### Kubeclt
 
 ![Screenshot from 2022-01-31 13-40-07](https://user-images.githubusercontent.com/69876788/151837191-3cba98e6-51a2-46a5-b702-60ea580939d9.png)
 
 É a ferramenta que provê formas de interagir com o cluster

[Instalando Kubectl](https://kubernetes.io/docs/tasks/tools/install-kubectl-linux/)

[Instalando Minikube](https://minikube.sigs.k8s.io/docs/start/)

 Para iniciar um node através do minikube: 
 ```
 $ minikube start --vm-driver=virtualbox
 ```

 ## Comandos Kubectl (Imperativo)
    kubectl get nodes - retorna todos os nodes
    kubectl get pods - retorna todos os pods
    kubectl get pods --watch - retorna o estado de execução dos pods
    kubectl get pod -o wide
    kubectl get svc - retorna os serviços
    kubectl describe pod [pod_name] - retorna informações sobre o pod
    kubectl edit pod [pod_name] - abre o arquivo do pod
    kubectl delete pod [pod_name] - delete um pod
    kubectl delete pod -f [pod_file] - deleta um pod criado de maneira declarativa
    kubectl run [pod_name] --image=[docker_image:version] - cria um pod
    kubectl exec -it [pod_name] -- bash - entre no terminal do pod

  ## Comandos Kubectl (Declarativo)   
    kubectl apply -f [file_path.yaml] 