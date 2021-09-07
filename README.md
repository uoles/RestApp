### Использование

Вызов:
>http://localhost:8081/rest/payment/getEntities
---
### Docker контейнер для unit-тестов

Расположение:
> https://hub.docker.com/r/oracleinanutshell/oracle-xe-11g

Скачивание:
> docker pull oracleinanutshell/oracle-xe-11g

Запуск:
> docker run -d -p 1521:1521 -e ORACLE_ALLOW_REMOTE=true oracleinanutshell/oracle-xe-11g

Подключение:
> hostname: localhost <br>
 port: 1521 <br>
 sid: xe <br>
 username: system <br>
 password: oracle <br>
 ---
