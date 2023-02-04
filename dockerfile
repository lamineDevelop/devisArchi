FROM amazoncorretto:11-alpine-jdk
MAINTAINER candle.com
WORKDIR /data_architecture
COPY target/architectureApp.jar data_architecture/architectureApp.jar
EXPOSE 3000
VOLUME /data_architecture
ENTRYPOINT ["java","-jar","data_architecture/architectureApp.jar"]