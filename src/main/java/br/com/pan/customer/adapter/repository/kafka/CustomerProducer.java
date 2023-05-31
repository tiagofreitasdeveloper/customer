package br.com.pan.customer.adapter.repository.kafka;

import br.com.customer.kafka.avro.CustomerAvro;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomerProducer {

    @Autowired
    private KafkaTemplate<String, CustomerAvro> kafkaTemplate;

    @Async
    public void sendMessage(CustomerAvro customer) {
        try {
            log.info("topicName::", "customer_topic_kafka");
            ProducerRecord<String, CustomerAvro> record = new ProducerRecord<>("customer_topic_kafka", customer);

            log.info("messageToSend::", customer);
            kafkaTemplate.send(record);

            log.info("message sent successfully");
        } catch (Exception exception) {
            log.error(exception.getMessage());
        }
    }

}
