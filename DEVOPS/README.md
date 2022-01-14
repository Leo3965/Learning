## Instalando Docker no linux
sudo apt-get remove docker docker-engine docker.io
Depois, atualize o banco de dados de pacotes:

sudo apt-get update
Agora, adicione ao sistema a chave GPG oficial do repositório do Docker:

curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add 
Adicione o repositório do Docker às fontes do APT:

sudo add-apt-repository \
   "deb [arch=amd64] https://download.docker.com/linux/ubuntu \
   $(lsb_release -cs) \
   stable"
Atualize o banco de dados de pacotes, para ter acesso aos pacotes do Docker a partir do novo repositório adicionado:

sudo apt-get update
Por fim, instale o pacote docker-ce:

sudo apt-get install docker-ce docker-ce-cli containerd.io
Caso você queira, você pode verificar se o Docker foi instalado corretamente verificando a sua versão:

sudo docker version
E para executar o Docker sem precisar de sudo, adicione o seu usuário ao grupo docker:

sudo usermod -aG docker $(whoami)

## Docker-Machine
curl -L https://github.com/docker/machine/releases/download/v0.16.0/docker-machine-`uname -s`-`uname -m` >/tmp/docker-machine &&
chmod +x /tmp/docker-machine &&
sudo cp /tmp/docker-machine /usr/local/bin/docker-machine
