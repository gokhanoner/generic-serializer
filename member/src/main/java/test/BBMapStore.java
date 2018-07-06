package test;

import com.hazelcast.core.MapStore;

import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Map;

public class BBMapStore implements MapStore<String, DataWrapper> {

    public void store(String key, DataWrapper value) {
        System.out.println(key + " -> " + new String(value.getData()));
    }

    public void storeAll(Map<String, DataWrapper> map) {

    }

    public void delete(String key) {

    }

    public void deleteAll(Collection<String> keys) {

    }

    public DataWrapper load(String key) {
        return null;
    }

    public Map<String, DataWrapper> loadAll(Collection<String> keys) {
        return null;
    }

    public Iterable<String> loadAllKeys() {
        return null;
    }
}
