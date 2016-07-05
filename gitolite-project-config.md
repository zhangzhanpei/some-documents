###1、修改gitolite.conf推送到服务器创建仓库
###2、修改仓库下的post-receive文件
GIT_WORK_TREE=/usr/share/nginx/html/freecar git checkout -f   
sudo chmod -R 755 /usr/share/nginx/html/freecar;   
sudo chmod -R 777 /usr/share/nginx/html/freecar/storage;   
sudo chmod -R 777 /usr/share/nginx/html/freecar/vendor;   
sudo chmod -R 777 /usr/share/nginx/html/freecar/public/upload;   
sudo chmod -R 777 /usr/share/nginx/html/freecar/bootstrap;   
###3、修改/etc/sudoers文件
注释掉 #Defaults requiretty 使得sudo命令在脚本中执行   
配置git用户 git  ALL=(ALL)  NOPASSWD:ALL  使得git用户可以在脚本中无需密码执行sudo命令   
