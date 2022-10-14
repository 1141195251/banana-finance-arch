package com.jluzh.msm.gateway;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;

@MessagingGateway(defaultRequestChannel = "MqttInputChannel")
public interface MqttGateway {
    // 向默认的 topic 发送消息
    void sendMessage2Mqtt(String data);
    // 向指定的 topic 发送消息
    void sendMessage2Mqtt(String data, @Header(MqttHeaders.TOPIC) String topic);
    // 向指定的 topic 发送消息，并指定服务质量参数
    void sendMessage2Mqtt(@Header(MqttHeaders.TOPIC) String topic, @Header(MqttHeaders.QOS) int qos, String payload);
}



