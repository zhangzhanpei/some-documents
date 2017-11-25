**MySQL的事务的隔离性由锁来实现，而原子性、一致性、持久性则通过数据库的 redo log 和 undo log 来实现。其中，原子性和持久性由 redo log 来保证，一致性由 undo log 来保证。**   

### redo log
重做日志由重做日志缓冲和重做日志文件组成，事务进行时，所做的修改(物理层面的修改，具体到表空间下面的页)会不断的记录到重做日志缓冲中，直到事务提交时重做日志同步到了磁盘，该事务才算完成。   
> redo log 和 binlog 的区别   
> 1、redo log 是 InnoDB 引擎层产生的，而 binlog 是 MySQL Server 层产生的。   
> 2、同一时刻可能有多个事务在进行，所以多个事务的 redo log 是穿插着多次写入。而 binlog 是按事务提交顺序写入的，只在事务提交时写入一次。   

![](http://wx2.sinaimg.cn/large/abf82c72gy1fluc4pyuclj20bo04cdg4.jpg)   

主要知识点：   
![](http://wx4.sinaimg.cn/large/abf82c72gy1fluc4ul159j21ie0v4q81.jpg)   

InnoDB存储引擎启动时，不管上次数据库是否正常关闭，都会进行恢复操作，即从 redo log 的 checkpoint 处开始恢复，恢复完毕后数据就是最新的了。   

### undo log
事务进行时不但会产生 redo log，还会产生 undo log。当事务需要回滚时，可以利用这些 undo log 回滚回去。需要注意的是，写 undo log 时也要记录 redo log。   
![](http://wx2.sinaimg.cn/large/abf82c72gy1flugb3clo5j21f00e1q5v.jpg)   

### 事务处理过程
> 1、修改记录前先写日志(Write-Ahead Logging)，先写 redo log 和 undo log 并刷到磁盘   
> 2、修改数据记录   
> 3、提交事务   
