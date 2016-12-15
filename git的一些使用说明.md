#### 1、gitignore文件规则
>以斜杠“/”开头表示目录   
>以星号“*”通配多个字符   
>以问号“?”通配单个字符   
>以方括号“[]”包含单个字符的匹配列表   
>以叹号“!”表示不忽略(跟踪)匹配到的文件或目录

#### 2、创建空文件夹
>空文件夹是不会加入版本管理的，可以在文件夹里创建一个空的.gitignore文件

#### 3、git rm 和 git rm --cache
>git rm 删除文件并从版本管理中删除   
>git rm --cache 仅仅删除追踪状态，保留文件   
>git clean -fd 删除未追踪的文件和目录

#### 4、修改上次提交git commit --amend
>如果上次提交漏了某些文件，可以先add再git commit --amend   
>ctrl + x 退出编辑

#### 5、查询某一文件的修改历史
>git blame

### 6、文件名大小写
>git在Windows下默认不区分文件名大小写   
>git config core.ignorecase false 设置为区分大小写   
