FROM openjdk:17

WORKDIR /usrapp/bin

ENV PORT 6001

COPY /target/classes /usrapp/bin/classes
COPY /target/dependency /usrapp/bin/dependency

CMD ["java","-cp","./classes:./dependency/*","eci.escuelaing.edu.co.server.SparkWebServer"]