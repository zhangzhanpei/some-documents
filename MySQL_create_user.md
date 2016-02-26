###MySQL创建用户并分配权限
create user 'username'@'192.168.1.%' identified bu 'password' [with grant option];
grant all on database.table to username;
