//package com.renhang.user.service.client.serializer;
//
//import org.apache.kafka.common.serialization.Serializer;
//
//import java.io.ByteArrayOutputStream;
//import java.io.ObjectOutputStream;
//import java.util.Map;
//
///**
// * @author heng.jia
// * @date 2018/7/4 下午7:29
// */
//public class ObjectSerializer implements Serializer<Object> {
//
//
//    @Override
//    public void configure(Map<String, ?> configs, boolean isKey) {
//
//    }
//
//    @Override
//    public byte[] serialize(String topic, Object object) {
//
//        System.out.println("topic : " + topic + " , object : " + object);
//
//        byte[] dataArray = null;
//
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//
//        try {
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
//            objectOutputStream.writeObject(object);
//
//            dataArray = outputStream.toByteArray();
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//
//        return dataArray;
//    }
//
//    @Override
//    public void close() {
//
//    }
//}
