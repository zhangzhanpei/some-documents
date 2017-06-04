1、官网下载编译好的二进制文件
![](http://wx4.sinaimg.cn/mw690/abf82c72gy1fg9315jvomj20tx0k240l.jpg)

2、配置Node环境
> 切换到root用户   
> vi /etc/profile   
> 在最后面加上   
export NODE_HOME=/path/to/node   
export PATH=$PATH:$NODE_HONE/bin   
export NODE_PATH=$NODE_HOME/lib/node_modules   
>source /etc/profile   

3、大功告成
```bash
node -v
```
