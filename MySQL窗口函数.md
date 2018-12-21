1、示例数据如下   
![](http://wx4.sinaimg.cn/large/abf82c72gy1fye7e21uo5j208s06o74i.jpg)

2、查询每科排名第一的学生
```sql
select id, username, course, score from
(
	select id, row_number()over(partition by course order by score desc) as rowNo, username, course, score from grade
) tmp
where tmp.rowNo = 1

或使用cte方式

with cte as
(
	select id, row_number()over(partition by course order by score desc) as rowNo, username, course, score from grade
)
select id, username, course, score from cte where cte.rowNo = 1

row_number() 表示行号，相同成绩时先查到的行排前面。
rank() 表示排名，相同成绩时排名相同。
dense_rank() 表示不间断的排名，解决相同排名后漏掉下一个名次的问题。
```
