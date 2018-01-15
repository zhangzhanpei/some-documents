<?php
$rk =new RdKafka\Producer();
$rk->setLogLevel(LOG_DEBUG);
$rk->addBrokers("127.0.0.1");

$topic = $rk->newTopic("test");
for ($i = 0; $i < 30; $i++) {
    //每隔一秒入队一条消息
    $topic->produce(0, 0, "message {$i} created");
    sleep(1);
}
