import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class ProducerDemo {
    public static void main(String[] args) {
        // 配置信息
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        // 消息写入所有副本节点才算提交成功
        props.put("acks", "all");
        // 重试次数
        props.put("retries", 0);
        // 多个记录写入同一分区时，生产者将多条消息作一批次写入，batch.size 设置一批次消息的大小
        props.put("batch.size", 16384);
        // 当消息未满一批次时，逗留 linger.ms 时间，等待更多的消息出现
        props.put("linger.ms", 1);
        // 缓冲等待被发送到服务器的记录的总字节数
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, String> producer = new KafkaProducer<>(props);
        for (int i = 0; i < 10; i++) {
            // 写入消息
            producer.send(new ProducerRecord<>("test-topic", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
        }
        // 关闭生产者
        producer.close();
    }
}
