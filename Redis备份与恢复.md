1、备份   
登入redis，使用`save`命令进行备份，生成的dump.rdb会放在redis的安装目录下   
2、恢复   
使用`config get dir`命令查看redis安装路径，确保备份文件dump.rdb在安装目录下，启动redis服务即可   
