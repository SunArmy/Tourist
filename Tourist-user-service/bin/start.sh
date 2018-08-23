cd .#!/usr/bin/sh
nohup java -jar /usr/local/Tourist-user-service-1.0-SNAPSHOT.jar --server.port=8492> /usr/local/logs/Tourist-user-service-center-1.0-SNAPSHOT.log 2>&1 &
