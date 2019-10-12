/**
 * @author yyb
 * @datetime 2019/10/12
 * @description 基于AVLTree实现了set接口
 * @param <E>
 */
public class AVLSet <E extends Comparable<E>> implements Set<E>{
    private AVLTree<E,Object> avl;

    public AVLSet(){
        avl=new AVLTree<>();
    }

    @Override
    public int getSize() {
        return avl.getSize();
    }

    @Override
    public boolean isEmpty() {
        return avl.isEmpty();
    }

    @Override
    public void add(E e) {
        avl.add(e,null);
    }

    @Override
    public boolean contains(E e) {
        return avl.contains(e);
    }

    @Override
    public void remove(E e) {
        avl.remove(e);
    }
}
