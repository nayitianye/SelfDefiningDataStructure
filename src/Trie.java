import java.util.TreeMap;
/**
 * @author yyb
 * @datetime 2019/10/8
 * @description  自定义的Trie字典树实现
 */
public class Trie {
    private class Node{
        public boolean isWord;
        public TreeMap<Character,Node> next;
        public Node(boolean isWord){
            this.isWord=isWord;
            next=new TreeMap<>();
        }

        public Node(){
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie(){
        root=new Node();
        size=0;
    }

    /**
     * 获得Trie中单词数量
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 向Trie中添加一个新的单词word   非递归写法
     * @param word
     */
    public void add(String word){
        Node cur=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(cur.next.get(c)==null){
                cur.next.put(c,new Node()) ;
            }
            cur=cur.next.get(c);
        }
        if(!cur.isWord){
            cur.isWord=true;
            size++;
        }
    }

    /**
     * 查找单词word是否在trie中  非递归写法
     * @param word
     * @return
     */
    public boolean contains(String word){
        Node cur=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(cur.next.get(c)==null){
                return false;
            }
            cur=cur.next.get(c);
        }
        return cur.isWord;
    }

    /**
     * 查询是否在Trie中有单词以prefix为前缀
     * @param prefix
     * @return
     */
    public boolean isPrefix(String prefix){
        Node cur=root;
        for(int i=0;i<prefix.length(); i++){
            char ch=prefix.charAt(i);
            if(cur.next.get(ch)==null){
                return false;
            }
            cur=cur.next.get(ch);
        }
        return true;
    }

}

