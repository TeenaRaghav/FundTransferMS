FROM amazoncorretto:17
WORKDIR /app
COPY build/libs/fundTransfer.jar fundTransfer.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "fundTransfer.jar"]
