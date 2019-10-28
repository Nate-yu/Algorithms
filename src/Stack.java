import java.util.Iterator;

/**
 * @author Nate yu
 * @date 2019/10/27 - 21:52
 */
public class Stack <Item> implements Iterable<Item>{
    private Node first; // 栈顶，最近添加的元素
    private int N; // 元素数量
    private class Node{ // 定义结点的嵌套类
        Item item;
        Node next;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public int size(){
        return N;
    }
    public void push(Item item){ // 向栈顶添加元素
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }
    public Item pop(){ // 从栈顶添加元素
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }
    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}
