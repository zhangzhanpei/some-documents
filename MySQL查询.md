1、一次查询得到多种条件的`count()`统计   
`select count(id), count(name='zhangsan' or null) from users;`   
或   
`select count(id), sum(if(name='zhangsan', 1, 0)) from users;` // if 语句中, 如果条件成立则返回1, 即sum()会加一   

2、删除表中的列   
`alter table users drop age;`   

3、增加列   
`alter table users add age int unsigned not null comment '年龄';`   

4、修改列   
`alter table users change [旧列名] [新列名] tinyint(3) unsigned not null comment '年龄';`   

5、重命名表名   
`alter table users rename [新表名];`   

6、添加索引   
`alter table users add index idx_xxx(列名);` // 索引名称常用的如主键索引 `pk_xxx`, 唯一索引 `uk_xxx`, 普通索引 `idx_xxx`   

7、删除索引   
`alter table users drop index index_name;`   

8、group by 和 order by 同时使用时, 获取每组最新一条记录   
`select * from test group by category order by id desc;` // 这里只会取到最旧的, 因为 group by 比 order by 先执行   
`select * from (select * from test order by id desc) tmp group by category order by id desc;` // 正确写法   
