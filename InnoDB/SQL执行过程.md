实例SQL语句：
```sql
select ...
from ...
left join ... on ...
where ...
group by ...
having ...
order by ...
limit ...
```

1、执行 `from`   
- 如果多个表之间是 cross join，这里会生成笛卡尔积   
- 如果是 inner join 或 outer join，遍历外部表，根据 on 条件取内部表符合条件的记录   

2、执行 `on`   
- 虚拟表中仅保留笛卡尔积中符合 on 条件的记录   

3、添加外部行   
- 如果是 outer join，将外部表被排除的记录加回虚拟表   

4、执行 `where`   
- 根据 where 条件过滤虚拟表   

5、执行 `group by`   
- 对虚拟表中的记录分组   

6、执行 `having`   
- 对分组后的记录进行过滤   

7、执行 `select`   
- 取出需要的字段，如果使用了 distinct 之类的字句则先去重等等   

8、执行 `order by`   
- 排序   

9、执行 `limit`   
- 取回指定条数的记录   
