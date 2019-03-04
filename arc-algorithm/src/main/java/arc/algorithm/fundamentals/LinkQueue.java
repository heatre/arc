package arc.algorithm.fundamentals;


import arc.algorithm.utils.Constant;
import arc.algorithm.utils.StdIn;
import arc.algorithm.utils.StdOut;
import arc.algorithm.utils.Utils;

import java.util.Iterator;

/**
 * Created by Swin on 2016/10/24.
 */
public class LinkQueue<Item> implements Iterable<Item> {
    /**
     * 队列中元素数量
     */
    private int N;
    /**
     * 最早添加元素
     */
    private Node first;
    /**
     * 最近添加元素
     */
    private Node last;

    private class Node{
        Item item;
        Node next;
    }

    public LinkQueue(){
        this.N = 0;
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return N;
    }

    public void enqueue(Item item) {
        //表尾添加元素
        Node old = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            old.next = last;
            N++;
        }
    }

    public Item dequeue(){
        if(isEmpty()){
            last = first;
            return null;
        }
        //表头删除元素
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkQueueIterator();
    }

    private class LinkQueueIterator implements Iterator<Item> {
        private Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return  item;
        }
    }

    public static void main(String[] args) {
        String fn = Constant.DATA_DIR + "tobe.txt";
        StdIn.setScanner(Utils.getScanner(fn));
        LinkQueue<String> fs = new LinkQueue<>();
        fs.dequeue();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (!s.equals("-")) {
                fs.enqueue(s);
            }
        }
        Iterator iterator = fs.iterator();
        while (iterator.hasNext()) {
            StdOut.print(iterator.next() + " ");
        }

        while (!fs.isEmpty()) {
            StdOut.print(fs.dequeue() + " ");
        }

        StdOut.println("(" + fs.size() + " left on queue)");

    }
}
