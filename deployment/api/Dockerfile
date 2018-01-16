FROM openjdk:8
MAINTAINER Rendra Toro <rendrat@gmail.com>

RUN mkdir -p /var/log/driver && chmod -R 777 /var/log/driver

COPY driver-api.jar /

VOLUME ["/var/log"]

CMD ["java","-jar","driver-api.jar"]