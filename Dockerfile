#docker build --tag 'image_name' .
#
FROM maven:3.8.6-openjdk-18-slim AS build
WORKDIR /home/app
COPY . /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:18.0-slim
EXPOSE 8080
COPY --from=build /home/app/target/*.jar app.jar
ENTRYPOINT [ "sh", "-c", "java -jar /app.jar" ]

#FROM openjdk:18.0-slim
#COPY  target/*.jar app.jar
#EXPOSE 5000
#ENTRYPOINT [ "java","-jar" ,"/app.jar" ]