### 安装和使用
- 直接下载压缩包，`bin/elasticsearch -d` 以守护进程模式启动即可

### 自定义中文词典
- 编辑 `config/analysis-ik/IKAnalyzer.cfg.xml` 配置文件中的 `ext_dict` 项，填写自定义词典文件路径，路径以配置文件路径为相对路径，单词一行一个

### 监听外网地址
- 修改监听地址为 `0.0.0.0`
- 出现 `max file description` 错误：修改 `/etc/security/limits.conf` 中的 `* soft nofile 65536` 和 `* hard nofile 131072` 两项，并重新 `ssh` 登录。如果是使用 `supervisor` 监管 `elasticsearch`，修改 `/etc/supervisor/supervisor.conf` 加上 `minfds=65536`
- 出现 `max virtual memory` 错误，在 `/etc/sysctl.conf` 文件最后加上 `vm.max_map_count = 655360`，执行 `sudo sysctl -p` 生效
