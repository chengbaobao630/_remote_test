package cc.home.domain;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import com.sun.corba.se.spi.ior.ObjectKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * Created by cheng on 2017/1/17 0017.
 */
public abstract class GeneticGoods<V> implements PropertiesConstant {

    private static final Logger logger= LoggerFactory.getLogger(GeneticGoods.class);

    private int id;

    private int size;

    public GeneticGoods() {
        properties = new Property[DEFAULT_PROPERTIES_CAPACITY];
        size = 0;
    }

    private Property[] properties;


    public void setProperty(String k,Class aClass, V v) {
        if (v.getClass() != aClass){
            logger.error("type and value not match!");
            throw  new RuntimeException();
        }
        size++;
        if (size > DEFAULT_PROPERTIES_CAPACITY) {
            grow();
        }
        properties[size] = new Property(k,aClass, v);
    }

    public void setProperties(Property... properties) {
        for (Property property : properties) {
            setProperty(property.getKey(),property.getaClass(), (V) property.getValue());
        }

    }

    public Property[] getProperties() {
        return properties;
    }

    private void grow() {
        int oldCapacity = properties.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - DEFAULT_PROPERTIES_CAPACITY < 0) {
            newCapacity = DEFAULT_PROPERTIES_CAPACITY;
        }
        properties = Arrays.copyOf(properties, newCapacity);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    private static class Property<T extends Object, V> {

        public Property(String key, Class<T> tClass, V value) {
            if (value.getClass() != tClass){
                logger.error("value does not match type!");
                throw  new RuntimeException();
            }
            this.key = key;
            this.value = value;
            this.aClass = tClass;
        }

        public Property() {
        }

        private Set<String> keySet;

        private Map<String,Class<T>> classMap;

        private String key;

        private Class aClass;

        public Class getaClass() {
            return aClass;
        }

        public void setaClass(Class aClass) {
            this.aClass = aClass;
        }

        private V value;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return new String(serialize());
        }

        private byte[] serialize() {
            Schema schema = RuntimeSchema.createFrom(this.getClass());
            byte[] bytes = ProtostuffIOUtil.toByteArray(this, schema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
            return bytes;
        }
    }


    public static void main(String[] args) {
        Property property=new Property("isAuto",String.class,"adsasawdfa");
        System.out.println(property);
    }
}
