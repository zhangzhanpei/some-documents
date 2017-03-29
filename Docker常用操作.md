1、拉取镜像   
`docker pull centos` 默认拉取latest版本   

2、实例化一个容器   
`docker run -it -d -p 80:80 -p 3306:3306 -v /path:/path --privileged centos:latest /usr/sbin/init` 这里给privileged参数是为了解决 `Failed to get D-Bus connection: Operation not permitted` 问题   

3、进入容器   
`docker ps -aq` 查看容器的id, `docker exec -it containerId /bin/bash` 进入容器   

4、创建镜像   
`docker commit containerId lnmp` lnmp就是镜像名字   

5、导出镜像   
`docker save lnmp > ./lnmp.tar`   

6、导入镜像   
`docker load < ./lnmp.tar`   

7、导出容器   
`docker export containerId > lnmp.tar`   

8、导入容器   
`docker import lnmp.tar zhanpei/lnmp`   
