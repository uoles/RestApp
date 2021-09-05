Вызов:
http://localhost:8081/rest/payment/getEntities
---
Docker контейнер:
https://hub.docker.com/r/oracleinanutshell/oracle-xe-11g

Скачивание:
docker pull oracleinanutshell/oracle-xe-11g

Запуск:
docker run -d -p 1521:1521 -e ORACLE_ALLOW_REMOTE=true oracleinanutshell/oracle-xe-11g

Подключение:
hostname: localhost
port: 1521
sid: xe
username: system
password: oracle