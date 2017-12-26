### MySQL仅支持 Nested-Loops Join 算法(嵌套循环联接)，根据场合可支持 Simple Nested-Loops Join 和 Block Nested-Loops Join 算法。   

### 一、Simple Nested-Loops Join
每次从驱动表 a 取一条记录，然后与嵌套表 b 的记录逐一比较，算法复杂度O(a * b)。如果 b 表联接列建有索引，则比较时可利用索引进行快速匹配，算法复杂度O(a)。   
查询优化器会自动将联接列有索引的表作为嵌套表，如果驱动表和嵌套表的联接列都有索引，则行数少的表作为驱动表可减少循环次数。   

### 二、Block Nested-Loops Join
联接列没有索引时使用，通过一次读取驱动表的多条记录到缓冲中，然后与嵌套表进行匹配。假如一次读取十条，则嵌套表的读取次数减少为原先的1/10。   
