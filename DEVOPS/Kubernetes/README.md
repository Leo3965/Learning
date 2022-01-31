## Kubernetes
    O Kubernetes cria e gerencia escalabilidade horizontal (orquestração de containers), onde temos várias máquinas trabalhando em conjunto (Cluster).

### Hierarchy
 - Master: 
   - Responsável por gerenciar o cluster
   - manter e atualizar o estado desejado
   - receber e executar novos comandos

 - Nodes: Responsável por executar os pods que possuem os containers (aplicações)


### Resources
 > POD: Escapsula containers
 
 > PV: Persistence volume for DataBases

 ### Kubeclt
 É a ferramenta que provê formas de interagir com o cluster