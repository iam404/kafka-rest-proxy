#!/bin/bash
export JAVA_OPTS="-Xms600m -Xmx600m -XX:MaxPermSize=256m"
java $JAVA_OPTS  -jar target/kafka-rest-proxy-1.0-SNAPSHOT.jar
