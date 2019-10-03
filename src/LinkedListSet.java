import java.util.ArrayList;

/**
 * @author yyb
 * @datetime 2019/10/3
 * @description 通过自定义的链表实现Set集合
 * @param <E>
 */
public class LinkedListSet<E> implements Set<E> {
    private LinkedList<E> list;

    public LinkedListSet() {
        list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.geiSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(E e) {
        return list.contain(e);
    }

    @Override
    public void add(E e) {
        if(!list.contain(e)){
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");
        ArrayList<String> words1=new ArrayList<>();
        FileOperation.readFile("resources/pride-and-prejudice.txt",words1);
        System.out.println("Total words: "+words1.size());
        LinkedListSet<String> set1=new LinkedListSet<>();
        for(String word:words1){
            set1.add(word);
        }
        System.out.println("Total different words: " + set1.getSize());
    }
}
