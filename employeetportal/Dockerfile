FROM openjdk:8-jdk

ARG JAR_FILE=target/employeetportal-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} employeetportal-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-agentlib:jdwp=transport=dt_socket,address=8000,server=y,suspend=n","-Djava.security.egd=file:/dev/./urandom","-jar","/employeetportal-0.0.1-SNAPSHOT.jar"]
