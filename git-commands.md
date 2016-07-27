###生成密钥
```bash
ssh-keygen -t rsa
然后一路回车即可
```
###拉取更新
```bash
git fetch origin master:tmp //拉取远程master分支到本地tmp分支
git merge tmp //合并更新
```
