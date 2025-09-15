FROM eclipse-temurin:17-jdk-alpine AS build

# copy maven confis
COPY pom.xml mvnw ./
COPY .mvn .mvn

# copy fastcgi lib
COPY lib lib

# mvnw (aka Apache Maven Wrapper) allows to acess maven simplier
RUN ./mvnw install:install-file -Dfile=./lib/fastcgi-lib.jar -DgroupId=com.fastcgi -DartifactId=fastcgi -Dversion=1.0 -Dpackaging=jar
RUN ./mvnw dependency:resolve 

COPY src src
RUN ./mvnw clean package

FROM eclipse-temurin:17-jre-alpine
WORKDIR server
COPY --from=build target/*.jar server-1.0.jar
ENTRYPOINT ["java", "-DFCGI_PORT=55555", "-jar", "server-1.0.jar"]