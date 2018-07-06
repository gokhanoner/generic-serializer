package test;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.StreamSerializer;

import java.io.IOException;

public class BBSerializer implements StreamSerializer<DataWrapper> {

    @Override
    public void write(ObjectDataOutput out, DataWrapper bh) throws IOException {
        out.writeUTF(bh.getClazz());
        out.writeByteArray(bh.getData());
    }

    @Override
    public DataWrapper read(ObjectDataInput in) throws IOException {
        DataWrapper bh = new DataWrapper();
        bh.setClazz(in.readUTF());
        bh.setData(in.readByteArray());
        return bh;
    }

    public int getTypeId() {
        return 1;
    }

    public void destroy() {

    }
}
