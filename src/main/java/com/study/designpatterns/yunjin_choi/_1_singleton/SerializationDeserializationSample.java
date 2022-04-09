package com.study.designpatterns.yunjin_choi._1_singleton;

import java.io.*;

/**
 * <pre>
 * com.study.designpatterns.yunjin_choi._1_singleton
 *      SerializationDeserializationSample
 * </pre>
 *
 * @author YunJin Choi(zzdd1558@gmail.com)
 * @since 2022-04-09 오전 10:11
 */

public class SerializationDeserializationSample {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        SerializationDeserializationSampleSingleTonClass serialization = SerializationDeserializationSampleSingleTonClass.getInstance();
        SerializationDeserializationSampleSingleTonClass deserialization;

        try (ObjectOutput output = new ObjectOutputStream(new FileOutputStream("serialization.obj"))){
            output.writeObject(serialization);
        }

        try(ObjectInput input = new ObjectInputStream(new FileInputStream("serialization.obj"))) {
            deserialization = (SerializationDeserializationSampleSingleTonClass)input.readObject();
        }

        System.out.println(serialization == deserialization);
    }
}



class SerializationDeserializationSampleSingleTonClass implements Serializable{

    private static volatile SerializationDeserializationSampleSingleTonClass instance;

    public static synchronized SerializationDeserializationSampleSingleTonClass getInstance() {
        if (instance == null) {
            synchronized (SerializationDeserializationSampleSingleTonClass.class) {
                if (instance == null) {
                    instance = new SerializationDeserializationSampleSingleTonClass();
                }
            }
        }
        return instance;
    }

    protected Object readResolve() {
        return getInstance();
    }
}
