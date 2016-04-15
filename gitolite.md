登陆到git用户   
确保~/.ssh/authorized_keys为空或不存在   
把开发机的公钥重命名为git.pub放到/home/git下面   
###安装gitolite   
```bash
git clone git://github.com/sitaramc/gitolite   
mkdir -p $HOME/bin   
gitolite/install -to $HOME/bin   
```
###使用公钥初始化为gitolite的管理员
```bash
$HOME/bin/gitolite setup -pk git.pub
```
