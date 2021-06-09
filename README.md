
MySQL Version
mysql  Ver 15.1 Distrib 10.5.9-MariaDB, for osx10.16 (x86_64) using readline 5.1

1. User 생성
   
   create user wematch@localhost identified by 'wematch';

2. Database 생성
   
   create database wematch default character set utf8;
   
3. 권한부여
   
   GRANT ALL privileges ON wematch.* TO wematch@localhost;

4.접속방법

HOST : localhost 

Port : 3306

User : wematch

Pass : wematch

Database : wematch

URL : jdbc:mariadb://localhost:3306/wematch?allowPublicKeyRetrieval=true&useSSL=false

CREATE TABLE sequences ( name varchar(32), currval BIGINT UNSIGNED ) ENGINE=InnoDB;
