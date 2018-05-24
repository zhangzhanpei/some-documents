### 安装 MySQL 8.0 时需查看 root 用户的临时密码，登录后再创建新用户
```bash
cat /var/log/mysqld.log
```

### MySQL 创建用户并分配权限
```sql
-- 低版本   
create user 'username'@'%' identified by 'password' [with grant option];   
-- 高版本   
create user 'username'@'%' identified [with mysql_native_password] by 'password' [password expire never];   
-- 分配权限   
grant all on database.table to username;   
-- 刷新权限   
flush privileges;   
```
