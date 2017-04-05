1、一次查询得到多种条件的`count()`统计   
`select count(id), count(name='zhangsan' or null) from users;`   
或   
`select count(id), sum(if(name='zhangsan', 1, 0)) from users;` if 语句中, 如果条件成立则返回1, 即sum()会加一   
