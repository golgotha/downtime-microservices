FROM java:8
VOLUME /tmp
ADD target/payout-ticket.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]