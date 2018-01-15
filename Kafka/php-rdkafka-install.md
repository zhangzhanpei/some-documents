### 安装依赖
```bash
yum install php-devel librdkafka librdkafka-devel
```

### 安装rdkafka扩展
```bash
git clone https://github.com/arnaud-lb/php-rdkafka.git
cd php-rdkafka
phpize
./configure
make && make install
```

### 修改php.ini
```bash
extension = rdkafka.so
```
