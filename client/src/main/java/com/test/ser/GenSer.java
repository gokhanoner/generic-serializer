package com.test.ser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.StreamSerializer;
import com.hazelcast.util.ExceptionUtil;

import java.io.IOException;

public class GenSer implements StreamSerializer<Object> {

    @Override
    public void write(ObjectDataOutput out, Object oo) throws IOException {
        out.writeUTF(oo.getClass().getName());
        out.writeByteArray(new ObjectMapper().writeValueAsBytes(oo));
    }

    @Override
    public Object read(ObjectDataInput in) throws IOException {
        String clazz = in.readUTF();
        try {
            return new ObjectMapper().readValue(in.readByteArray(), Class.forName(clazz));
        } catch (ClassNotFoundException e) {
            throw ExceptionUtil.peel(e);
        }
    }

    @Override
    public int getTypeId() {
        return 1;
    }

    @Override
    public void destroy() {

    }
}
