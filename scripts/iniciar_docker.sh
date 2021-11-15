#!/bin/bash

docker run --name cities-db -d -p 5432:5432 -e POSTGRES_USER=postgres_user_city -e POSTGRES_PASSWORD=super_password -e POSTGRES_DB=cities postgres
if [$? -eq 1]
then
  echo "A imagem Postgres já existe"
fi
docker start cities-db
if [ $? -eq 0 ]
then
  echo "Successo ! O container Postgres foi iniciado com sucesso"
  exit 0
else
  echo "Falha na inicialização do Postgres no docker" >&2
  exit 1
fi
echo "Script executado com sucesso"
exit 0