FROM openjdk:17-jdk-alpine


LABEL authors="Akanksha"

ENTRYPOINT ["top", "-b"]