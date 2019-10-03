import java.util.ArrayList;

/**
 * @author yyb
 * @datetime 2019/10/3
 * @description 通过自定义的二叉搜索树实现Set集合
 * @param <E>
 */
public class BinarySearchTreeSet<E extends Comparable<E>> implements Set<E> {
    private BinarySearchTree<E> bst;

    public BinarySearchTreeSet(){
        bst=new BinarySearchTree<>();
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");
        ArrayList<String> words1=new ArrayList<>();
        FileOperation.readFile("resources/pride-and-prejudice.txt",words1);
        System.out.println("Total words: "+words1.size());
        BinarySearchTreeSet<String> set1=new BinarySearchTreeSet<>();
        for(String word:words1){
            set1.add(word);
        }
        System.out.println("Total different words: " + set1.getSize());
    }
}
