### 服务器SS服务安装
1、先下载shadowsocks源码并解压[https://github.com/shadowsocks/shadowsocks/releases]   
2、安装ss需要使用python-setuptools安装，因此先安装python-setuptools   
3、进入shadowsocks源码包，执行`python setup.py install`命令安装服务   
4、启动服务：`/usr/bin/ssserver -s ip -p 1080 -k password -m aes-256-cfb`   
5、服务开机启动，把启动命令写入`/etc/rc.d/rc.local`即可   
