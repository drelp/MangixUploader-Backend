```shell
mvn clean package
mvn clean package -DskipTests

sudo docker-compose up mangix-mysql80
sudo docker-compose up -d mangix-mysql80
sudo docker-compose stop mangix-mysql80
sudo docker-compose rm mangix-mysql80

172.21.16.11
create database mangix default character set utf8mb4 collate utf8mb4_unicode_ci;
create user 'mangix'@'%' identified by 'mangix123456';
grant all privileges on mangix.* to 'mangix'@'%';
flush privileges;
```

```shell
imgur.com
https://imgurinc.com/
```