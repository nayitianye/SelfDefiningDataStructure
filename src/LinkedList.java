/**
 * @author yyb
 * @datetime 2019/10/1
 * @description 自定义实现的链表结构
 * @param <E>
 */
public class LinkedList <E>{
    /**
     * 节点内部类
     */
    private class Node{
        public E e;
        public Node next;

        public Node(E e,Node next){
            this.e=e;
            this.next=next;
        }
        public Node(E e){
            this(e,null);
        }
        public Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
    private Node dummyHead;
    int size;

    public LinkedList(){
        dummyHead=new Node();
        size=0;
    }

    /**
     * 获取链表中的元素个数
     * @return
     */
    public int geiSize(){
        return size;
    }

    /**
     * 判断链表元素个数是否为空
     * @return
     */
    public boolean isEmpty(){
        return size==0;
    }

    /**
     * 在链表的index(0-based)位置添加新的元素e
     * 在链表中不是一个常用的操作，练习用
     * @param index
     * @param e
     */
    public void add(int index,E e){
        if(index<0|| index>size){
            throw  new IllegalArgumentException("Add failed. Illegal Index .");
        }
        Node prev=dummyHead;
        for(int i=0;i<index;i++){
            prev=prev.next;
        }
//            Node node=new Node(e);
//            node.next=prev.next;
//            prev.next=node;
        prev.next=new Node(e,prev.next);
        size++;
    }

    /**
     * 在链表头添加新的元素e
     * @param e
     */
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * 在链表结尾添加元素e
     * @param e
     */
    public void addLast(E e){
        add(size,e);
    }

    /**
     * 获得链表的index(0-based)位置元素e
     * 在链表中不是一个常用的操作，练习用
     * @param index
     */
    public E get(int index){
        if(index<0|| index>=size){
            throw  new IllegalArgumentException("Add failed. Illegal Index .");
        }
        Node cur=dummyHead.next;
        for(int i=0;i<index;i++){
            cur=cur.next;
        }
        return cur.e;
    }

    /**
     * 获得链表的第一个元素
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 获得链表的最后一个元素
     * @return
     */
    public E getLast(){
        return get(size-1);
    }

    /**
     * 修改链表的第index(0-based)个位置的元素为e
     * 在链表中不是一个常用的操作，练习用
     * @param index
     * @param e
     */
    public void set(int index,E e){
        if(index<0|| index>=size){
            throw  new IllegalArgumentException("Add failed. Illegal Index .");
        }
        Node cur=dummyHead.next;
        for(int i=0;i<index;i++){
            cur=cur.next;
        }
        cur.e=e;
    }

    /**
     * 查找链表中是否有元素e
     * @param e
     * @return
     */
    public boolean contain(E e){
        Node cur=dummyHead.next;
        while(cur!=null){
            if(cur.e.equals(e)){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }

    /**
     * 从链表中删除index(0-based)位置的元素，返回删除的元素
     * @param index
     * @return
     */
    public E remove(int index){
        if(index<0|| index>=size){
            throw  new IllegalArgumentException("Add failed. Illegal Index .");
        }
        Node prev=dummyHead;
        for(int i=0;i<index;i++){
            prev=prev.next;
        }
        Node retNode=prev.next;
        prev.next=retNode.next;
        retNode.next=null;
        size--;
        return  retNode.e;
    }

    /**
     * 从链表中删除第一个元素，返回删除的元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 从链表中删除最后一个元素，返回删除的元素
     * @return
     */
    public E removeLast(){
        return remove(size-1);
    }
    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();
//        Node cur=dummyHead.next;
//        while(cur!=null){
//            res.append(cur+ "->");
//            cur=cur.next;
//        }
        for(Node cur=dummyHead.next;cur!=null;cur=cur.next){
            res.append(cur+ "->");
        }
        res.append("NULL");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList=new LinkedList<>();
        for(int i=0;i<5;i++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(2,666);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);
    }
}
