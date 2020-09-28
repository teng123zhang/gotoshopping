package com.rc.gmall2020.util.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.jboss.netty.util.internal.ReusableIterator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

import javax.jms.Session;
//spring注入:1set注入  2构造器注入 3接口注入
@Configuration
public class ActiveMQConfig {

    @Value("${spring.activemq.broker-url:disabled}")
    String brokerURL ;

    @Value("${activemq.listener.enable:disabled}")
    String listenerEnable;

    // 在spring容器中添加一个ActiveUtil的实例
    @Bean
    public ActiveMQUtil getActiveMQUtil(){
        if ("disabled".equals(brokerURL)){
            return null;
        }
        ActiveMQUtil activeMQUtil = new ActiveMQUtil();
        activeMQUtil.init(brokerURL);
        return  activeMQUtil;
    }

    /*配置消息监听器的工厂*/
    @Bean(name = "jmsQueueListener")
    public DefaultJmsListenerContainerFactory jmsQueueListenerContainerFactory(ActiveMQConnectionFactory activeMQConnectionFactory) {

        if("disabled".equals(listenerEnable)){
            return null;
        }
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(activeMQConnectionFactory);
        // 设置事务
        factory.setSessionTransacted(false);
        // 自动签收
        factory.setSessionAcknowledgeMode(Session.AUTO_ACKNOWLEDGE);
        // 设置并发数
        factory.setConcurrency("5");
        // 重连间隔时间
        factory.setRecoveryInterval(5000L);

        return factory;
    }
    // 接收消息的工厂
    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory ( ){
        ActiveMQConnectionFactory activeMQConnectionFactory =
                new ActiveMQConnectionFactory(brokerURL);
        return activeMQConnectionFactory;
    }
}
