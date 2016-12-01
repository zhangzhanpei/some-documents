#nginx + php-fpm 上传大文件配置   
###nginx
fastcgi_connect_timeout 600;   
fastcgi_send_timeout 600;   
fastcgi_read_timeout 600;   
client_max_body_size 16m;   
###php
upload_max_filesize 16M   
post_max_size 16M   
max_execution_time 600   
###php-fpm
request_terminate_timeout 600s   
request_slowlog_timeout 600s   
