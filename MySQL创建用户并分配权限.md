###  MySQL创建用户并分配权限
```sql
create user 'username'@'192.168.1.%' identified by 'password' [with grant option];   
grant all on database.table to username;   
flush privileges;   
```
