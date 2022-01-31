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
 > POD: Escapsula containers
 
 > PV: Persistence volume for DataBases

 ### Kubeclt
 
 ![Screenshot from 2022-01-31 13-40-07](https://user-images.githubusercontent.com/69876788/151837191-3cba98e6-51a2-46a5-b702-60ea580939d9.png)
 
 É a ferramenta que provê formas de interagir com o cluster
