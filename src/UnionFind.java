/**
 * @author yyb
 * @datetime 2019/10/9
 * @description 自定义实现并查集的接口
 */
public interface UnionFind {
    int getSize();
    boolean isConnected(int p,int q);
    void unionElements(int p,int q);
}
