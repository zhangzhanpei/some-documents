1、`Mybatis-Generator`配置信息如`mybatis-generator.xml`   
2、`Maven`仓库下载`mybatis-generator-core.jar`文件   
3、项目根目录执行命令生成`entity`和`mapper`文件   
```bash
java -jar mybatis-generator-core-1.3.7.jar -configfile src\main\resources\mybatis-generator.xml -overwrite
```
