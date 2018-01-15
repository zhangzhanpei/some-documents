<?php
$rk = new RdKafka\Consumer();
$rk->setLogLevel(LOG_DEBUG);
$rk->addBrokers("127.0.0.1");

$topic = $rk->newTopic("test");
$topic->consumeStart(0, RD_KAFKA_OFFSET_BEGINNING);
while (true) {
    $msg = $topic->consume(0, 1000);
    if (is_null($msg)) {
        echo "sleep..\n";
        sleep(10);
        continue;
    }
    switch ($msg->err) {
        case 0: //读到一条正确的消息
            echo $msg->payload . "\n";
            break;
        case RD_KAFKA_RESP_ERR__TIMED_OUT: //拉取消息超时
            echo "Timed Out\n";
            break;
        default:
            break;
    }
}
