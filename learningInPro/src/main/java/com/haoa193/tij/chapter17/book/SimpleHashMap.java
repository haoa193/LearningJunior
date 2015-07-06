package com.haoa193.tij.chapter17.book;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * Created by chenyong on 2015/6/19.
 */
public class SimpleHashMap<K, V> extends AbstractMap<K, V>{

    static final int SIZE = 997;

    LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

    @Override
    public V get(Object key) {
        return super.get(key);
    }

    @Override
    public V put(K key, V value) {

        V oldValue = null;
        int index = Math.abs(key.hashCode())%SIZE;


        return super.put(key, value);
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
