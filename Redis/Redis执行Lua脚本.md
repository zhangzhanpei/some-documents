### 减库存场景
- 先获取库存
- 判断库存够不够
- 减库存
这几步操作并不是原子性的，可能有多个线程都获取了旧的库存，导致超卖。可以将三步操作写成 Lua 脚本，Redis 执行 Lua 脚本是原子性的，一整个 Lua 脚本当做一个命令来执行，所以 Lua 脚本尽量不要占用太多时间   
```bash
eval "local old = redis.call('get', ARGV[1]); if old < ARGV[2] then return -1 end; return redis.call('decrby', ARGV[1], ARGV[2]);" 0 goods:100 20
```
其中 `goods:100` 指 id 为 100 的商品的库存   
