# Iniciando uma imagem com base em outra
FROM node:latest 
# Responsável pela imagem
MAINTAINER Leonardo O. Freitas
# Variáveis de ambiente
ENV NODE_ENV=production
ENV PORT=3000
# Código fonte da imagem
COPY . /var/www
# Psta de trabalho do container
WORKDIR /var/www
# roda esse comando, quando a imagem estiver sendo construida
RUN npm install
# Comando será executado quando a imagem for construida
ENTRYPOINT npm start
# Expoem essa porta no host
EXPOSE $PORT