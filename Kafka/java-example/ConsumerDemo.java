import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

public class ConsumerDemo {
    public static void main(String[] args) {
        // 配置信息
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        // 设置消费者组
        props.put("group.id", "test-consumer-group");
        // 关闭自动提交
        props.put("enable.auto.commit", "false");
        // 设置消息读取起始位置
        // earliest 从已提交的 offset 处开始读取消息，没有已提交的 offset 时从头开始读取
        // latest 读取消费者启动后新增的消息
        props.put("auto.offset.reset", "earliest");
        // 每次最多读取的消息数量
        props.put("max.poll.records", 10);
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        Consumer<String, String> consumer = new KafkaConsumer<>(props);
        // 订阅 test-topic
        consumer.subscribe(Arrays.asList("test-topic"));
        while (true) {
            // 读取消息
            ConsumerRecords<String, String> records = consumer.poll(1000);
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
            }
            // 手动提交 offset
            consumer.commitSync();
        }
    }
}
