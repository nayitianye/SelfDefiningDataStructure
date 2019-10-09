/**
 * @author yyb
 * @datetime 2019/10/9
 * @description  自定义的并查集  find操作为O(1)  union操作为O(n)
 */
public class UnionFind_QuickFind implements UnionFind {
    private int[] id;
    public UnionFind_QuickFind(int size){
        id=new int[size];
        for(int i=0;i<id.length;i++){
            id[i]=i;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    /**
     * 查找元素p所对应的集合编号
     * @param p
     * @return
     */
    private int find(int p){
        if(p<0&&p>=id.length){
            throw new IllegalArgumentException("p is out of bound.");
        }
        return id[p];
    }

    /**
     * 查找元素p和元素q是否所属一个集合
     * @param p
     * @param q
     * @return
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p)==find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pID=find(p);
        int qID=find(q);
        if(pID==qID){
            return;
        }
        for(int i=0;i<id.length;i++){
            if(id[i]==pID){
                id[i]=qID;
            }
        }
    }
}
