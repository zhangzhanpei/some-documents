### 发布与订阅
使用 `subscribe` 命令订阅某频道，当其他客户端使用 `publish` 命令向该频道发送消息时，所有订阅该频道的客户端都会收到消息   

### 频道订阅和模式订阅
服务端 `redisServer.pubsub_channels` 属性保存了所有的频道订阅关系，它是一个字典以频道为 `key`，值为订阅该频道的所有客户端组成的单链表。   
服务端 `redisServer.pubsub_patterns` 属性保存了所有的模式订阅关系，它是一个链表结构，每个节点都记录了一个客户端和该客户端订阅的模式。   

### 发布
当客户端使用 `publish` 命令向某频道发送消息时，服务端在 `redisServer.pubsub_channels` 字典中找到订阅该频道的所有客户端逐个发送消息。然后遍历`redisServer.pubsub_patterns` 链表，如果频道匹配节点的模式，则给该客户端发送消息。    
