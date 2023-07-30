# Define a imagem base a ser utilizada
FROM openjdk:11-jre-slim

# Define a pasta de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo JAR da aplicação para a pasta de trabalho do contêiner
COPY build/libs/*.jar app.jar

# Expõe a porta em que a aplicação Spring Boot está ouvindo (a porta padrão é 8080)
EXPOSE 8080

# Comando para iniciar a aplicação Spring Boot quando o contêiner for executado
CMD ["java", "-jar", "app.jar"]