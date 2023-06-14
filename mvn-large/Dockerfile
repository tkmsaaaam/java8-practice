FROM maven:3.8.3-amazoncorretto-8

COPY . /usr/src
WORKDIR /usr/src/
RUN ls -al
WORKDIR /usr/src/
RUN mvn package
