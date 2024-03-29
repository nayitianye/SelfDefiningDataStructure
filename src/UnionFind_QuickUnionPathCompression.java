/**
 * @author yyb
 * @datetime 2019/10/9
 * @description  自定义的并查集  find操作为O(h)  union操作为O(h)  h为树的高度  基于路径压缩优化
 */
public class UnionFind_QuickUnionPathCompression implements UnionFind{
    private int [] parent;
    private int[] sz;   //sz[i]表示以i为根的集合中元素个数

    public UnionFind_QuickUnionPathCompression(int size){
        parent=new int[size];
        sz=new int[size];
        for(int i=0;i<size;i++){
            parent[i]=i;
            sz[i]=1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * 查找元素p所对应的集合编号
     * O（h）复杂度，h为树的高度
     * @param p
     * @return
     */
    private  int find(int p){
        if(p<0||p>=parent.length){
            throw new IllegalArgumentException("p is out of bound.");
        }
        while(p!=parent[p]){
            parent[p]=parent[parent[p]];
            p=parent[p];
        }
        return p;
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

    /**
     * 合并元素p和元素q所属的集合
     * o(h)复杂度，h为树的高度
     * @param p
     * @param q
     */
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }
        //根据两个元素所在树的元素个数不同判断合并方向
        //将元素个数少的集合合并到元素个数多的集合上
        if(sz[pRoot]<sz[qRoot])
        {
            parent[pRoot] = qRoot;
            sz[qRoot]+=sz[pRoot];
        }else {    //sz[qRoot]<=sz[pRoot]
            parent[qRoot]=pRoot;
            sz[pRoot]+=sz[qRoot];
        }
    }
}
