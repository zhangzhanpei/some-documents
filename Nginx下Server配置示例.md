```cmd
server {
    listen       443;
    server_name  icant.cc;
    ssl on;
    ssl_certificate /etc/letsencrypt/live/icant.cc/fullchain.pem;
    ssl_certificate_key /etc/letsencrypt/live/icant.cc/privkey.pem;

    error_log /var/log/nginx/blog.log;

    location / {
        root   /usr/share/nginx/html/blog/public;
        index  index.php index.html;

        if ( $request_filename ~ (css|js)$ ) {
            expires 1h;
        }

        if ( $request_filename ~ (jpg|jpeg|png|gif)$ ) {
            expires 30d;
        }

        if (!-e $request_filename) {
            rewrite ^/(.*)$ /index.php?$1 last;
            break;
        }
    }

    location ~ \.php($|/) {
        root           html/blog/public;
        fastcgi_pass   127.0.0.1:9000;
        fastcgi_index  index.php;
        fastcgi_param  SCRIPT_FILENAME  $document_root$fastcgi_script_name;
        include        fastcgi_params;
    }
}
```
