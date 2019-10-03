import java.util.Random;
/**
 * @author yyb
 * @datetime 2019/10/3
 * @description 自定义实现最大堆
 * @param <E>
 */
public class MaxHeap<E extends Comparable<E> > {
    private Array<E> data;

    public MaxHeap(int capacity){
        data=new Array<>(capacity);
    }

    public MaxHeap(){
        data=new Array<>();
    }

    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        for(int i = parent(arr.length - 1) ; i >= 0 ; i --)
            siftDown(i);
    }
    /**
     * 返回对中的元素个数
     * @return
     */
    public int size(){
        return data.getSize();
    }

    /**
     * 返回一个布尔值，表示堆中是否为空
     * @return
     */
    public boolean isEmpty(){
        return data.isEmpty();
    }

    /**
     * 返完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
     * @param index
     * @return
     */
    private int parent(int index){
        if(index==0){
           throw  new IllegalArgumentException("index-0 doesn`t have parent.");
        }
        return (index-1)/2;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
     * @param index
     * @return
     */
    private int leftChild(int index){
        return index*2+1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
     * @param index
     * @return
     */
    private int rigthChild(int index){
        return index*2+2;
    }

    /**
     * 向堆中添加元素
     * @param e
     */
    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize()-1);
    }

    private void siftUp(int k){
        while(k>0&&data.get(parent(k)).compareTo(data.get(k))<0){
            data.swap(k,parent(k));
            k=parent(k);
        }
    }

    /**
     * 查看堆中的最大元素
     * @return
     */
    public E findMax(){
        if(data.getSize()==0){
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        }
        return data.get(0);
    }

    /**
     * 取出堆中最大元素
     * @return
     */
    public E extractMax(){
        E ret=findMax();
        data.swap(0,data.getSize()-1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    private void siftDown(int k) {
        while(leftChild(k)<data.getSize()){
            int j=leftChild(k);
            if(j+1<data.getSize()&&data.get(j+1).compareTo(data.get(j))>0){
                j=rigthChild(k);
                //data[j]是leftchild和rightchild中的最大值
            }
            if(data.get(k).compareTo(data.get(j))>=0){
                break;
            }
            data.swap(k,j);
            k=j;
        }
    }

    /**
     * 取出堆中的最大元素，并且替换成元素e
     * @param e
     * @return
     */
    public E replace(E e){

        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

    //索引堆  N叉堆  二项堆  斐波拉契堆 广义队列
    public static void main(String[] args) {
        int n=1000000;
        MaxHeap<Integer> maxHeap=new MaxHeap<>();
        Random random=new Random();
        for(int i=0;i<n;i++){
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=maxHeap.extractMax();
        }
        for(int i=1;i<n;i++){
            if(arr[i-1]<arr[i]){
                throw new IllegalArgumentException("Error");
            }
        }
    }

}
