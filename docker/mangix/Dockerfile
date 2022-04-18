FROM openjdk:8-jre
RUN fc-cache
RUN fc-list
RUN mkdir -p /home/mangix
WORKDIR /home/mangix
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo 'Asia/Shanghai' > /etc/timezone
COPY application.yml application.yml
COPY mangix-uploader.jar mangix-uploader.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","mangix-uploader.jar"]