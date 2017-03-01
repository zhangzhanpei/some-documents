###Host is blocked because of many connection errors; unblock with 'mysqladmin flush-hosts'   
查看修改`max_connect_errors`参数   
`show variables like 'max_connect%', set global max_connect_errors = 1000;`   
然后主从服务器都登录MySQL, 执行`flush hosts`命令。   

###查看master的日志文件和位置   
show master status\G;   

###查看slave的日志文件和位置   
show slave status\G;   
两个参数都应该为Yes，并且没有报错信息   
Slave_IO_Running: Yes   
Slave_SQL_Running: Yes   

###slave修改同步位置   
change master to master_log_file='master-bin.000005', master_log_pos=4005542;   
