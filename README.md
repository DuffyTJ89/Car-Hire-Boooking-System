# Car-Hire-Boooking-System
A RESTful Car Hire Booking System

Creating mysql Client/Server.

download Windows (x86, 64-bit), ZIP Archive from https://dev.mysql.com/downloads/mysql/

save it to your direcctory. E.g D:\GMIT\DisSys\Project

change folder name to just mysql for ease of access

open cmd with admin access

cd into your directory e.g D:\GMIT\DisSys\Project\mysql\bin 

and enter the following command

	mysql --initialize --console

take note of the password


******
start database server 

by moving to the direcctory again e.g D:\GMIT\DisSys\Project\mysql\bin 

and enter 

	mysqld --console

the d means daemon and the console mean print out the info.

ctrl + C shuts down the server

******
start client

cd to mysql folder again e.g e.g D:\GMIT\DisSys\Project\mysql\bin 

enter 

	mysql -u root -p 

and you will enter the password given in the server step e.g bdVp:IK#/74q

client is started and ready

******
change root password

in client with mysql enter

	alter user 'root'@'localhost' identified by 'xxxxx'; 

xxxxx should be your new password. for this i will use DisSys18 so, 

	alter user 'root'@'localhost' identified by 'DisSys18';

the exit

	quit

start again by moving to directory mysql\bin

enter

	mysql -u root -p

enter new password for root user

