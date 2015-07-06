package com.haoa193.tij.chapter17.exercises;

import java.util.NoSuchElementException;

/**
 * Created by chenyong on 2015/6/17.
 */
public class E08_SList {

    public static void main(String[] args) {

        System.out.println("Demonstrating SListIterator");
        SList<String> sl = new SList<String>();
        System.out.println(sl);
        SListIterator<String> slit = sl.iterator();
        slit.add("one");
        slit.add("two");
        slit.add("tree");
        System.out.println(slit.hasNext());
        System.out.println(sl);
        slit = sl.iterator();
        slit.add("four");

        for (; slit.hasNext(); ) {
            System.out.println(slit.next());
        }

    }


}

interface SListIterator<T> {
    boolean hasNext();
    T next();
    void remove();

    void add(T element);
}

class SList<T> {

    private final Link<T> header = new Link<T>(null, null);
    SList(){
        header.next = header;
    }

    public SListIterator<T> iterator(){
        System.out.println("iterator()");
        return new SListIteratorImpl();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (SListIterator<T> it = iterator(); it.hasNext(); ) {
            T element = it.next();
            sb.append(element == this ? "this SList" : String.valueOf(element));
            if (it.hasNext()) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private static class Link<T> {
        T element;
        Link<T> next;
        Link(T element, Link<T> next) {
            this.element = element;
            this.next = next;
        }
    }

    private class SListIteratorImpl implements SListIterator<T> {
        private Link<T> lastReturned = header;
        private Link<T> next;
        SListIteratorImpl() {
            next = header.next;
        }
        @Override
        public boolean hasNext() {
            System.out.println("hasNext, next:" + next);
            System.out.println("hasNext, header:" + header);
            return next != header;
        }

        @Override
        public T next() {
            if (next == header) {
                throw new NoSuchElementException();
            }
            lastReturned = next;
            next = next.next;
            return lastReturned.element;
        }

        @Override
        public void remove() {
            if (lastReturned == header) {
                throw new IllegalStateException();
            }
            for (Link<T> curr = header; ; curr = curr.next) {
                if (curr.next == lastReturned) {
                    curr.next = lastReturned.next;
                    break;
                }
                System.out.println("remove, header:" + header);
                lastReturned = header;
            }
        }
        @Override
        public void add(T element) {
            System.out.println("add, header:" + header.element);
            System.out.println("add, next:" + next.element);
            lastReturned = header;
            Link<T> newLink = new Link<T>(element, next);
            if (header.next == header) {//empty list
                System.out.println("empty list");
                header.next = newLink;
            } else {
                for (Link<T> curr = header; ; curr = curr.next) {
                    if (curr.next == next) {
                        curr.next = newLink;
                        break;
                    }
                }
            }
        }
    }
}
