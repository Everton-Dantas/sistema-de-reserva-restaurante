# Usar uma imagem do JDK 17 (ou a versão compatível)
FROM openjdk:17-jdk-slim

# Definir o diretório de trabalho dentro do container
WORKDIR /app

# Copiar o arquivo JAR gerado pelo Maven para dentro do container
COPY target/*.jar app.jar

# Expor a porta que a aplicação usa
EXPOSE 8080

# Comando para executar a aplicação
CMD ["java", "-jar", "app.jar"]
