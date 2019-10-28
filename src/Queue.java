
/**
 * @author Nate yu
 * @date 2019/10/28 - 19:25
 */
public class Queue <Item> {
    private Node last; // 最近添加结点的链接
    private Node first; //最早添加结点的链接
    private int N;
    class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty()   {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {  // 向表尾添加元素
        Node oldlast;
        oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
        }
        N++;
    }

    public Item dequeue() { // 从表头删除元素
        Item item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        N--;
        return item;
    }
}
