/**
 * @author yyb
 * @datetime 2019/10/3
 * @description 自定义实现集合的接口
 * @param <E>
 */
public interface Set<E> {
    void add(E e);
    void remove(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();
}
