package com.test;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.config.GlobalSerializerConfig;
import com.hazelcast.config.SerializerConfig;
import com.hazelcast.core.HazelcastInstance;
import com.test.model.A;
import com.test.model.B;
import com.test.ser.GenSer;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Client {

    public static void main(String[] args) throws IOException {
        ClientConfig config = new ClientConfig();


        GlobalSerializerConfig gsc = new GlobalSerializerConfig();
        gsc.setImplementation(new GenSer());

        config.getSerializationConfig().setGlobalSerializerConfig(gsc);

        HazelcastInstance client = HazelcastClient.newHazelcastClient(config);

        A aa = new A();
        aa.setId(1);
        aa.setName("Gokhan");

        client.getMap("testA").put("1", aa);

        System.out.println(client.getMap("testA").get("1"));

        B bb = new B();
        bb.setTs(System.currentTimeMillis());
        bb.setXx(ThreadLocalRandom.current().nextDouble());

        client.getMap("testB").put("1", bb);
        System.out.println(client.getMap("testB").get("1"));


        HazelcastClient.shutdownAll();
    }
}
