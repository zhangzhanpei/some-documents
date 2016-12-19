1、配置my.cnf   
[mysqld]   
character-set-server = utf8   
2、设置navicat   
数据库连接属性->高级->编码[auto]   
3、查看字符集命令   
show variables like 'character%'
