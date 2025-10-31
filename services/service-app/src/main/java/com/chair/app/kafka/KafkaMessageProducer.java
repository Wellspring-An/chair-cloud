package com.chair.app.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
//public class KafkaMessageProducer {
//
//    private final KafkaTemplate<String, Object> kafkaTemplate;
//
//    // 构造函数注入（推荐）
//    @Autowired
//    public KafkaMessageProducer(KafkaTemplate<String, Object> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
//
//    /**
//     * 发送消息到指定主题
//     */
//    public void send(String topic, Object message) {
//        kafkaTemplate.send(topic, message)
//                .whenComplete((result, ex) -> {
//                    if (ex == null) {
//                        System.out.println("消息发送成功：" + result.getProducerRecord().value());
//                    } else {
//                        System.err.println("消息发送失败：" + ex.getMessage());
//                    }
//                });
//    }
//}