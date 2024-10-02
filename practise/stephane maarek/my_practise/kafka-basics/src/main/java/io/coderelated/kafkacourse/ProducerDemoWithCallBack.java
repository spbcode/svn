package io.coderelated.kafkacourse;

import org.apache.kafka.clients.producer.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class ProducerDemoWithCallBack {

    private static final Logger log = LoggerFactory.getLogger(ProducerDemoWithCallBack.class.getSimpleName());
    public static void main(String[] args) {
        log.info("Hello world!");
        Properties props = new Properties();
        props.put("bootstrap.servers", "172.31.132.191:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("log4j.logger.org.apache.kafka", "DEBUG");
        //props.put("batch.size","400");
        props.put("linger.ms","0");
//        props.put("partitioner.class", RoundRobinPartitioner.class.getName());
        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        for(int j=0;j<5;j++) {
            for (int i = 0; i < 10; i++) {
                ProducerRecord<String, String> record = new ProducerRecord<>("first_topic", "Hello world! " +j+" "+ i);
                producer.send(record, new Callback() {
                    @Override
                    public void onCompletion(RecordMetadata metadata, Exception exception) {
                        if (exception == null) {
                            System.out.println("Topic: " + metadata.topic());
                            System.out.println("\t partition: " + metadata.partition());
                            System.out.println("\t  offset: " + metadata.offset());
                            System.out.println("\t  timestamp: " + metadata.timestamp());
                        }
                    }
                });
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        producer.flush();
        producer.close();
    }
}
