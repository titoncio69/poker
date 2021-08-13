FROM adoptopenjdk:8u282-b08-jdk-openj9-0.24.0 as builder
WORKDIR /app
COPY . .
RUN ./mvnw clean package


FROM adoptopenjdk:8u282-b08-jre-openj9-0.24.0 
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
CMD java -jar app.jar