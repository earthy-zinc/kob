# SpringBoot单体应用部署Dockerfile
FROM openjdk:8-jdk-alpine

RUN set -eux && \
    sed -i 's/dl-cdn.alpinelinux.org/mirrors.ustc.edu.cn/g' /etc/apk/repositories && \
    apk --update --no-cache add tini
ENTRYPOINT ["tini"]

# /tmp 目录就会在运行时自动挂载为匿名卷，任何向 /tmp 中写入的信息都不会记录进容器存储层
VOLUME /tmp

COPY botrunning-system/target/*.jar botruning-system.jar
COPY kob-backend/target/*.jar kob-backend.jar
COPY matching-system/target/*.jar matching-system.jar
CMD java -jar /botruning-system.jar & java -jar /matching-system.jar & java -jar /kob-backend.jar

EXPOSE 3000

# 时区修改
RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && \
    echo 'Asia/Shanghai' >/etc/timezone; \
    echo -e https://mirrors.ustc.edu.cn/alpine/v3.7/main/ > /etc/apk/repositories; \
    apk --no-cache add ttf-dejavu fontconfig
