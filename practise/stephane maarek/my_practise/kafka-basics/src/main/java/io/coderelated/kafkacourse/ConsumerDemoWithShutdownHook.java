package io.coderelated.kafkacourse;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class ConsumerDemoWithShutdownHook {

    private static final Logger log = LoggerFactory.getLogger(ConsumerDemoWithShutdownHook.class.getSimpleName());
    public static void main(String[] args) {
        log.info("I am a kafka consumer");
        String topic = "first_topic";
        String groupid = "my-first-application";
        Properties props = new Properties();
        props.put("bootstrap.servers", "172.31.132.191:9092");
        props.put("key.deserializer", StringDeserializer.class.getName());
        props.put("value.deserializer", StringDeserializer.class.getName());
        //props.put("log4j.logger.org.apache.kafka", "DEBUG");
        props.put("group.id",groupid);
        props.put("auto.offset.reset","earliest");

        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(props);
        final Thread mainThread = Thread.currentThread();
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                log.info("Detected a shutdown, let's exit by calling kafkaConsumer.wakeup()");
                kafkaConsumer.wakeup();

                try {
                    mainThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        try {
            kafkaConsumer.subscribe(Arrays.asList(topic));
            while (true) {
//                log.info("kafka consumer polling...");

                ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofMillis(1000));
                for (ConsumerRecord<String, String> record : records) {
                    log.info("key: " + record.key() + ", value: " + record.value() + ", partition: " + record.partition()
                            + ", offset: " + record.offset());
                }
            }
        }catch (WakeupException e){
            log.warn("consumer is started to shutdown");
        }catch (Exception e){
            log.error("unexpected Exception in the consumer", e);
        }finally {
            kafkaConsumer.close();  // close the consumer, this will also commit offsets
            log.info("The consumer is now gracefully shutdown");
        }
    }
}
