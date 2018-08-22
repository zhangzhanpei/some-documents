### 查询某个问题某个传播链条上的用户
- 问题id = 5715
- 链条id = 666
- 路径上第一个元素就是问题节点，使用 tail 排除
```bash
match path = ((q:Question{id:5715})-[:Forward*]->()-[:Forward{chainId:666}]->(u:User))
return tail(nodes(path))
```
