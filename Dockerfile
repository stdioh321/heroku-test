FROM gradle:jdk11-openj9 as builder
WORKDIR /app
COPY . /app
RUN gradle clean build
RUN apt update
RUN apt install cron -y
RUN apt install vim -y
RUN apt install systemctl -y
RUN service cron start
RUN systemctl enable cron
USER app
ENV PORT=8080
EXPOSE $PORT

CMD /bin/bash ./startup.sh