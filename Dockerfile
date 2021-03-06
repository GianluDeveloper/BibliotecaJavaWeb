FROM jboss/wildfly
ADD standalone.txt /opt/jboss/wildfly/standalone/configuration/standalone.xml
ADD *.war /opt/jboss/wildfly/standalone/deployments/

RUN /opt/jboss/wildfly/bin/add-user.sh admin Admin#70365 --silent
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]

