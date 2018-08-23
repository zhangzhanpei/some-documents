### 示例图如下
![](http://wx3.sinaimg.cn/large/abf82c72gy1fujfv8efykj20gr076mxj.jpg)

### 查询某个问题某个传播链条上的用户
- 问题id = 5715
- 链条id = 666
- 路径上第一个元素就是问题节点，使用 tail 排除
```bash
match path = ((q:Question{id:5715})-[:Forward*]->()-[:Forward{chainId:666}]->(u:User))
return tail(nodes(path))
```

### 查询某个问题的传播链条数量
- 问题id = 5715
- 链条数量即终点用户数量，先找到转发了 5715 问题的所有用户，再排除有出边的用户，剩下的就是没出边的终点用户
```bash
match (:Question{id:5715})-[:Forward*]->(u:User)
where not (u)-->()
return count(u)
```
