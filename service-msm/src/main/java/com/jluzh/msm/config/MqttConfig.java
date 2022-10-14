package com.jluzh.msm.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@IntegrationComponentScan
@ConfigurationProperties(prefix = "banana.mqtt")
public class MqttConfig {
    /**
     * RabbitMQ连接用户名
     */
    private String username;

    /**
     * RabbitMQ连接密码
     */
    private String password;

    /**
     * 服务地址
     */
    private String[] servers;

    /**
     * 客户端id
     */
    private String clientId;

    /**
     * 服务端id
     */
    private String serverClientId;

    /**
     * 默认主题
     */
    private String defaultTopic;
}
