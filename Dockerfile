FROM jboss/wildfly:10.0.0.Final

ADD target/chispazo.war /opt/jboss/wildfly/standalone/deployments/