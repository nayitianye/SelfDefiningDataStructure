/**
 * @author yyb
 * @datetime 2019/10/1
 * @description 自定义实现队列的接口
 * @param <E>
 */
public interface Queue<E> {
     int getSize();
     boolean isEmpty();
     void enqueue(E e);
     E dequeue();
     E getFront();
}
