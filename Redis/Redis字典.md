### Reids字典
![](http://wx2.sinaimg.cn/large/abf82c72gy1flk6yu0wj6j21kw0kp0we.jpg)   

字典的实现包含以下三种结构：   
> `dict` 字典   
> `dictht` 哈希表   
> `dictEntry` 键值对   

### 字典
`dict` 结构中包含 `ht`，`rehashidx` 等属性，其中 `dict.ht` 是一个数组共两个元素，存储了两个哈希表。而 `dict.rehashidx` 属性当 rehash 不在进行时值为 `-1`。一般情况下，字典只使用 `ht[0]` 哈希表，`ht[1]` 哈希表只在 `rehash` 时辅助使用。

### 哈希表
`dictht` 结构包含 `table`、`size`、`sizemask`、`used` 四个属性：   
> `table` 一个数组，每个元素都是一个 `dictEntry`   
> `size` 哈希表大小   
> `sizemask` 掩码，用于计算索引值，总是等于 `size - 1`   
> `used` 哈希表已有节点的数量   

Redis使用单链表存储冲突的键，冲突的键直接插入到单链表的表头，实现O(1)的插入。   

哈希表的扩展与收缩：   
当哈希表的负载因子 `>=1`，且没有 `bgsave` 或 `bgrewriteaof` 命令在后台执行，扩展哈希表   
当哈希表的负载因子 `>=5`，正在执行 `bgsave` 或 `bgrewriteaof` 命令，扩展哈希表   
当哈希表的负载因子 `<0.1`，收缩哈希表   
> `扩展` ht[1] 的 size 为第一个大于等于 ht[0].used * 2 的 2的n次方   
> `收缩` ht[1] 的 size 为第一个大于等于 ht[0].used 的 2的n次方   

哈希表的rehash：   
哈希表进行扩展或收缩后，需要将 `ht[0]` 里面的键值对都转移到 `ht[1]` 中，此过程称为 `rehash`。   
> 1、将 `rehashidx` 设为 `0` 表示 `rehash` 工作开始   
> 2、`rehash` 进行时，每次对字典进行的操作都会将 `rehashidx` 位置上的单链表所有键值对 `rehash` 到 `ht[1]` 上，然后 `rehashidx++`   
> 3、随着字典操作的不断执行，`ht[0]` 的所有键值对都会被 `rehash` 到 `ht[1]` 上，然后 rehashidx 置为 `-1` 表示 `rehash` 工作完成   

`rehash` 过程中，字典的删除、更新、查找都会在两个哈希表中进行。而新增键值对的操作只会在 `ht[1]` 中进行，这样可保证 `ht[0]` 中的键值对只减不增，并随着 `rehash` 的进行最终变成空表。   

