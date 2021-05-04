while true;do curl "https://tmptmpjava.herokuapp.com";sleep 10;done &
java $JAVA_OPTS -jar build/libs/*.jar --server.port=$PORT