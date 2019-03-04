package arc.algorithm.fundamentals;

import arc.algorithm.utils.Constant;
import arc.algorithm.utils.StdIn;
import arc.algorithm.utils.StdOut;
import arc.algorithm.utils.Utils;

/**泛型可扩容定容栈
 * Created by Swin on 2016/10/20.
 */
public class FixedCapacityStack<Item> {
    private Item[] items;
    /**
     * 栈的容量
     */
    private int cap;
    /**
     * 栈内元素个数
     */
    private int N;

    public FixedCapacityStack(int cap) {
        items = (Item[]) new Object[cap];
        this.cap = cap;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public boolean isCapacity() {
        return cap == N;
    }

    public int size() {
        return N;
    }

    public void resize(int max){
        Item[] items = (Item[])  new Object[max];
        for(int i = 0; i< N; ++i){
            items[i] = this.items[i];
        }
        this.items = items;
    }

    public void push(Item s) {
        if(N == items.length) {
            resize(items.length*2);
        }
        items[N++] = s;
    }

    public Item pop() {
        if (N == 0) {
            return null;
        }
        Item item = items[--N];
        //避免对象游离
        items[N] = null;
        return item;
    }

    public static void main(String[] args) {
        String fn = Constant.DATA_DIR + "tobe.txt";
        StdIn.setScanner(Utils.getScanner(fn));
        FixedCapacityStack<String> fs = new FixedCapacityStack<>(1);
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (!s.equals("-") && !fs.isCapacity()) {
                fs.push(s);
            } else if (!fs.isEmpty()) {
                StdOut.print(fs.pop() + " ");
            }
        }
        StdOut.println("(" + fs.size() + " left on stack)");

    }
}