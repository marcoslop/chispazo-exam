FROM jboss/wildfly:10.0.0.Final
#create a default user 'admin' with password 'admin'
RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]