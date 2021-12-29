FROM openjdk:8
EXPOSE 8080
ADD target/parkingappbooking.jar parkingappbooking.jar
ENTRYPOINT ["java","-jar","parkingappbooking.jar"]