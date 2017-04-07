1、启动 mongod 服务   
`systemctl start mongod`   

2、进入 mongo shell   
`./mongo`   

3、显示所有库   
`show dbs`   

4、创建或进入某个库   
`use test`   

5、删除当前库   
`db.dropDatabase()`   

6、查询所有文档   
`db.test.find()`   

7、插入文档   
`db.test.insert({"id": 1, "name": "zhangsan", "age": 25})`   

8、更新某个文档   
`db.test.update({"id": 1}, {$set: {"age": 30}})`   

9、删除某个文档   
`db.test.remove({"id": 1})`   
