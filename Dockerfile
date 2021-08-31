FROM adoptopenjdk/openjdk11

MAINTAINER Fabian Perez <cfpvasquez96@hotmail.com>

ADD target/bcp-tech-test.jar bcp-tech-test.jar

ENTRYPOINT ["java", "-jar", "bcp-tech-test.jar"]