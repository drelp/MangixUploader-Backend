```shell
mvn clean package
mvn clean package -DskipTests

cd docker
cp ../target/mangix-uploader-0.0.1-SNAPSHOT.jar mangix-fe/mangix-uploader.jar
cp mangix/application.yml mangix-fe/
cp mangix/Dockerfile mangix-fe/

sudo docker-compose up mangix-mysql80
sudo docker-compose up -d mangix-mysql80
sudo docker-compose stop mangix-mysql80
sudo docker-compose rm mangix-mysql80

sudo docker-compose up mangix
sudo docker-compose up -d mangix
sudo docker-compose stop mangix
sudo docker-compose rm mangix

sudo docker-compose -f docker-compose1.yml up mangix
sudo docker-compose -f docker-compose1.yml up -d mangix
sudo docker-compose -f docker-compose1.yml stop mangix
sudo docker-compose -f docker-compose1.yml rm mangix

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