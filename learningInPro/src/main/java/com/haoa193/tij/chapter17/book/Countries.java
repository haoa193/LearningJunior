package com.haoa193.tij.chapter17.book;

import java.util.*;

/**
 * Created by chenyong on 2015/6/16.
 */
public class Countries {
    public static final String[][] DATA = {
            //Africa
            {"ALGERIA", "Algiers"}, {"ANGOLA", "Luanda"}
    };

    private static class FlyweightMap extends AbstractMap<String, String> {

        private static Set<Map.Entry<String, String>> entries = new EntrySet(DATA.length);

        @Override
        public Set<Entry<String, String>> entrySet() {
            return entries;
        }

        static class EntrySet extends AbstractSet<Map.Entry<String, String>> {

            private int size;

            EntrySet(int size) {
                if (size < 0) {
                    this.size = 0;
                } else if (size > DATA.length) {
                    this.size = DATA.length;
                } else {
                    this.size = size;
                }
            }

            @Override
            public Iterator<Map.Entry<String, String>> iterator() {
                return new Iter();
            }

            @Override
            public int size() {
                return size;
            }

            private class Iter implements Iterator<Map.Entry<String, String>> {
                private com.haoa193.tij.chapter17.book.Countries.FlyweightMap.EntrySet.Entry entry = new com.haoa193.tij.chapter17.book.Countries.FlyweightMap.EntrySet.Entry(-1);
                public boolean hasNext() {
                    return entry.index < size - 1;
                }

                public Map.Entry<String, String> next() {
                    entry.index++;
                    return entry;
                }
                @Override
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            }

            private static class Entry implements Map.Entry<String, String> {
                int index;

                Entry(int index) {
                    this.index = index;
                }

                public String getKey() {
                    return DATA[index][0];
                }

                public String getValue() {
                    return DATA[index][1];
                }

                public String setValue(String value) {
                    throw new UnsupportedOperationException();
                }

                @Override
                public int hashCode() {
                    return DATA[index][0].hashCode();
                }

                @Override
                public boolean equals(Object obj) {
                    return DATA[index][0].equals(obj);
                }
            }

        }
    }
    static Map<String, String> select(final int size) {
        return new FlyweightMap() {
            @Override
            public Set<Entry<String, String>> entrySet() {
                return new EntrySet(size);
            }
        };
    }

    static Map<String, String> map = new FlyweightMap();

    public static Map<String, String> capitals() {
        return map;
    }

    public static Map<String, String> capitals(int size) {
        return select(size);
    }

    static List<String> names = new ArrayList<String>(map.keySet());
    static List<String> names(){
        return names;
    }
    static List<String> names(int size){
        return new ArrayList<String>(select(size).keySet());
    }

    public static void main(String[] args) {

        System.out.println(capitals());
    }

}
