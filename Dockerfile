FROM tomcat:8.0.20-jre8

COPY /target/patientservice-svc.war /usr/local/tomcat/webapps/patientservice-svc.war


