FROM maven:3.9.6-eclipse-temurin-17

WORKDIR /app

COPY backend/ .

RUN mvn clean package -DskipTests

EXPOSE 8081

CMD ["java","-jar","target/veltroz-chatbot-0.0.1-SNAPSHOT.jar"]