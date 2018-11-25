FROM java:8
VOLUME /tmp
ADD target/gateway.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005", "-Djava.security.egd=file:/dev/./urandom", "-Dreactor.netty.http.server.accessLogEnabled=true", "-jar","/app.jar"]