FROM tomcat:8.5.20-jre8
EXPOSE 8080
USER root
COPY target/kafka-rest-proxy-*.war /usr/local
COPY run1.sh run.sh
CMD chmod +x run.sh
ENTRYPOINT ["bash","./run.sh"]
