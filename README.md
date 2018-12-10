# Car-Hire-Boooking-System
A RESTful Car Hire Booking System

# Run the project

* use the sql files in the database DatabaseWithData folder. Steps to set up db are below if needed.
* customer records can be retuned in the console or by using postman.
* the web app isn't finished so doesn't talk to the the RESTful app or the db.
* RESTful and RMI are working with customer records.
* Application uses tomcat sever 7. 


# Creating mysql Client/Server.

download Windows (x86, 64-bit), ZIP Archive from https://dev.mysql.com/downloads/mysql/

save it to your direcctory. E.g D:\GMIT\DisSys\Project

change folder name to just mysql for ease of access

open cmd with admin access

cd into your directory e.g D:\GMIT\DisSys\Project\mysql\bin 

and enter the following command

```sh

$ mysql --initialize --console

```

take note of the password


-----------------
# start database server 

by moving to the direcctory again e.g D:\GMIT\DisSys\Project\mysql\bin 

and enter 
```sh
	mysqld --console
```
the d means daemon and the console mean print out the info.

ctrl + C shuts down the server

******
# start client

cd to mysql folder again e.g e.g D:\GMIT\DisSys\Project\mysql\bin 

enter 
```sh
	mysql -u root -p 
```
and you will enter the password given in the server step e.g bdVp:IK#/74q

client is started and ready

******
# change root user password

in client with mysql enter
```sh
	alter user 'root'@'localhost' identified by 'xxxxx'; 
```
xxxxx should be your new password. for this i will use DisSys18 so, 
```sh
	alter user 'root'@'localhost' identified by 'DisSys18';
```
then exit by entering 
```sh
	quit
```

start again by moving to directory mysql\bin

enter
```sh
	mysql -u root -p
```
enter new password for root user
*************
# install JDBC

go to 

https://dev.mysql.com/downloads/connector/

select Connector/J

from dropdown select platform independent 

select the ZIP Archive

save to folder e.g D:\GMIT\DisSys\Project

shorten the folder name to mysql-connector for ease of use
