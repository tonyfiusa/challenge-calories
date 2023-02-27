FROM maven:3-openjdk-16

LABEL mantainer="Tony Fiusa <tony.fiuza@gmail.com>"

ARG PORT=8090
EXPOSE ${PORT}

ARG JAR_NAME=product.jar
ENV JAR_NAME=${JAR_NAME}
ARG JAR_SRC=target/${JAR_NAME}

COPY ${JAR_SRC} ./

ENTRYPOINT ["java","-jar","/product.jar"]
