# customer
criação api crud customer

#Comandos docker para executar a aplicação:
  docker build -t customer .
  
  docker-compose up -d
  
  docker-compose exec mysql bash
  
  mysql -uroot -proot customer < /docker-entrypoint-initdb.d/schema.sql
  
  docker-compose up -d
