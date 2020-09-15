# ██████╗ ██╗   ██╗██╗██╗     ██████╗
# ██╔══██╗██║   ██║██║██║     ██╔══██╗
# ██████╔╝██║   ██║██║██║     ██║  ██║
# ██╔══██╗██║   ██║██║██║     ██║  ██║
# ██████╔╝╚██████╔╝██║███████╗██████╔╝
# ╚═════╝  ╚═════╝ ╚═╝╚══════╝╚═════╝
FROM maven:3.6.3-jdk-11-slim as builder
ENV POSTGRES_VERSION 42.2.14
WORKDIR /build

RUN curl --location --silent --output postgresql.jar \
    --url https://repo1.maven.org/maven2/org/postgresql/postgresql/$POSTGRES_VERSION/postgresql-$POSTGRES_VERSION.jar

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src/ /build/src/
RUN mvn package


# ██████╗ ██╗   ██╗███╗   ██╗
# ██╔══██╗██║   ██║████╗  ██║
# ██████╔╝██║   ██║██╔██╗ ██║
# ██╔══██╗██║   ██║██║╚██╗██║
# ██║  ██║╚██████╔╝██║ ╚████║
# ╚═╝  ╚═╝ ╚═════╝ ╚═╝  ╚═══╝
FROM jboss/wildfly:20.0.0.Final
WORKDIR $JBOSS_HOME

ARG JBOSS_SECRET

COPY --from=builder /build/target/app-backend.war ./standalone/deployments/
COPY --from=builder /build/postgresql.jar .
COPY setup/server/wildfly.cli .

RUN bin/add-user.sh wildfly $JBOSS_SECRET --silent && \
    bin/jboss-cli.sh --file=wildfly.cli && \
    rm -rf standalone/configuration/standalone_xml_history

EXPOSE 8080 9990 8787
CMD ["bin/standalone.sh", "-c", "standalone-full.xml", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0", "--debug", "*:8787"]
