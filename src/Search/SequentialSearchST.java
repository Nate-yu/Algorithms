package Search;

/**
 * @author Nate yu
 * @date 2019/11/7 - 18:43
 */
public class SequentialSearchST<Key,Value> {

    private Node first; // 链表首结点

    public class Node{ // 链表结点的定义
        Key key;
        Value val;
        Node next;
        public Node(Key key,Value val,Node next){
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public Value get(Key key){ // 查找给定的键，返回相关联的值
        for (Node x = first; x != null; x = x.next){
            if (key.equals(x.key)){
                return x.val; // 查找成功，返回关联值
            }
        }
        return null; // 查找失败
    }

    public void put(Key key,Value val){ // 查找给定的键，找到则更新其值，否则在表中新建结点
        for (Node x = first; x != null; x = x.next){
            if (key.equals(x.key)){
                x.val = val; // 查找成功，更新
                return;
            }
        }
        first = new Node(key,val,first); // 未找到，新建结点
    }
}
