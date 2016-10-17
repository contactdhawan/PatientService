FROM tomcat:8.0.20-jre8

COPY /target/calling-svc-1.0.0-SNAPSHOT.war /usr/local/tomcat/webapps/calling-svc-1.0.0-SNAPSHOT.war


