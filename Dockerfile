#
# Build stage
#
FROM ubuntu:18.04
RUN mkdir /home/app

FROM adoptopenjdk/maven-openjdk11:latest
COPY . /home/app
WORKDIR /home/app
RUN ls -l

WORKDIR /home/app/target
RUN ls -l
ENTRYPOINT ["java","-jar","customer-0.0.1-SNAPSHOT.jar"]

#EXPOSE 8080
#COPY src /home/app/srcdocker
#COPY pom.xml /home/app
#RUN mvn -f /home/app/pom.xml clean install

#FROM adoptopenjdk/openjdk11:latest
#
#ADD schema.sql /etc/mysql/schema.sql
#
#ARG JAR_FILE=target/customer-avro.avsc.jar
#
#WORKDIR /opt/app
#
#COPY ${JAR_FILE} *.jar
#
#ENTRYPOINT ["java","-jar","*.jar"]