//package com.renhang.user.service.client.jms.activemq;
//
//import org.apache.activemq.ActiveMQConnectionFactory;
//import org.apache.activemq.command.ActiveMQTextMessage;
//
//import javax.jms.*;
//
///**
// * @author heng.jia
// * @date 2018/7/5 下午9:10
// */
//public class ActiveMQDemo {
//
//    public static void main(String[] args) throws Exception {
//
//        sendMessage();
//
//        receiveMessage();
//
//    }
//
//    private static void receiveMessage() throws Exception {
//
//        // 创建 ActiveMQ 链接，设置 Broker URL
//        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
//        // 创造 JMS 链接
//        Connection connection = connectionFactory.createConnection();
//        // 启动连接
//        connection.start();
//        // 创建会话 Session
//        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//        // 创建消息目的 - Queue 名称为 "TEST"
//        Destination destination = session.createQueue("TEST");
//        // 创建消息消费者
//        MessageConsumer messageConsumer = session.createConsumer(destination);
//
//        // 获取消息
//        Message message = messageConsumer.receive(100);
//
//        if (message instanceof TextMessage) {
//            TextMessage textMessage = (TextMessage) message;
//            System.out.println("消息消费内容：" + textMessage.getText());
//        }
//
//        // 关闭消息消费者
//        messageConsumer.close();
//        // 关闭会话
//        session.close();
//        // 关闭连接
//        connection.stop();
//        connection.close();
//    }
//
//
//    private static void sendMessage() throws Exception {
//        // 创建 ActiveMQ 链接，设置 Broker URL
//        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
//        // 创造 JMS 链接
//        Connection connection = connectionFactory.createConnection();
//        // 创建会话 Session
//        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//        // 创建消息目的 - Queue 名称为 "TEST"
//        Destination destination = session.createQueue("TEST");
//        // 创建消息生产者
//        MessageProducer producer = session.createProducer(destination);
//        // 创建消息 - 文本消息
//        ActiveMQTextMessage message = new ActiveMQTextMessage();
//        message.setText("Hello,World");
//        // 发送文本消息
//        producer.send(message);
//
//        // 关闭消息生产者
//        producer.close();
//        // 关闭会话
//        session.close();
//        // 关闭连接
//        connection.close();
//    }
//}
