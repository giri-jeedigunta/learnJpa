# Spring Boot + JPA 
Trying out Spring Boot and JPA with Graddle. A simple starter project with JPA and postgres sql. 

# DB
```docker run -p 5432:5432 --name sampledb -e POSTGRES_PASSWORD=pglocal -e POSTGRES_USER=local -v <YOUR_LOCAL_PATH>:/var/lib/postgresql/data -d postgres:latest```