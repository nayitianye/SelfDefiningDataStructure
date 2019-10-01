/**
 * @author yyb
 * @datetime 2019/10/1
 * 自定义实现栈的接口
 * @param <E>
 */
public interface Stack<E>{
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
