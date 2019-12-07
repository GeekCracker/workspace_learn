source /etc/profile
killall java
nohup java -jar /usr/local/application/mysqlwhite/mysqlwhite.jar > nohup.log 2>&1 &