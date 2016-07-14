###禁用root账号登录
1、新建一个账号   
2、修改ssh配置   
```bash
vi /etc/ssh/sshd_config
PermitRootLogin no
```
3、使用新账号登录后可以su命令登录到root账号   
