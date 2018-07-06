package test;

import com.hazelcast.config.Config;
import com.hazelcast.config.GlobalSerializerConfig;
import com.hazelcast.core.Hazelcast;

public class Member {

    public static void main(String[] args) {
        Config config = new Config();

        config.getMapConfig("test*").getMapStoreConfig().setEnabled(true).setImplementation(new BBMapStore());

        GlobalSerializerConfig gsc = new GlobalSerializerConfig();
        gsc.setImplementation(new BBSerializer());

        config.getSerializationConfig().setGlobalSerializerConfig(gsc);

        Hazelcast.newHazelcastInstance(config);
    }
}
