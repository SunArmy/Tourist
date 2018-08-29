#! /bin/bash
echo "proxy service will stop"
pid3=$(ps -ef | grep -v 'grep' | egrep /usr/local/procedure/Tourist-user-service-1.0-SNAPSHOT.jar | awk '{printf $2 " "}')
if [ "$pid3" != "" ]; then
    kill -9 "$pid3"
    echo "proxy service has been stopped!"
fi