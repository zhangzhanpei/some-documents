1、一次查询得到多种条件的`count()`统计   
`select count(id), count(name='zhangsan' or null) from users;`   
或   
`select count(id), sum(if(name='zhangsan', 1, 0)) from users;` if 语句中, 如果条件成立则返回1, 即sum()会加一   

2、删除表中的列   
`alter table users drop age;`   

3、增加列   
`alter table users add age int unsigned not null comment '年龄';`   

4、修改列   
`alter table users change [旧列名] [新列名] tinyint(3) unsigned not null comment '年龄';`   

5、重命名表名   
`alter table users rename [新表名];`   

6、添加索引   
`alter table users add index index_name(列);`   

7、删除索引   
`alter table users drop index index_name;`   
