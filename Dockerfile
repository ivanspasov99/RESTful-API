# Stage 1 - Installing dependencies and creating executable file
FROM maven:3.6.3-openjdk-14 as builder
ARG version

# Setting up working directory in container
WORKDIR /build
# Copy the current directory in the WORKDIR
COPY . /build
# Create executable .jar
RUN mvn clean install

# Stage 2 - Executing the jar file
FROM openjdk:14-jdk-alpine
ARG version

# Setting working directory for the second container
WORKDIR /app

# Copy the created .jar file from stage 1, so we can run it in stage 2 container
COPY --from=builder /build/target/restfullapi-1.0.0.jar /app/restfullapi.jar

# on witch port to expose the container
EXPOSE 8080

# command
ENTRYPOINT ["java"]

# arguments
CMD ["-jar", "restfullapi.jar"]