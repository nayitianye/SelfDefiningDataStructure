public class NumArray {
    private SegmentTree<Integer> segmentTree;
    public NumArray(int[] nums) {
        Integer[] data = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            data[i]=nums[i];
        }
        segmentTree=new SegmentTree<>(data,(a,b)->a+b);
    }

    public int sumRange(int i,int j){
        if(segmentTree==null){
            throw new IllegalArgumentException("Segment Tree is null");
        }
        return segmentTree.query(i,j);
    }
}
