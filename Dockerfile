FROM jboss/wildfly:18.0.0.Final

ADD target/chispazo.war /opt/jboss/wildfly/standalone/deployments/