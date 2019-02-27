package tree;

/**
 * @Description 二叉树
 * @Author lilong
 * @Date 2019-02-27 10:23
 */
public class BinTreeNode {
    private int data;
    private BinTreeNode left;
    private BinTreeNode right;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinTreeNode left) {
        this.left = left;
    }

    public BinTreeNode getRight() {
        return right;
    }

    public void setRight(BinTreeNode right) {
        this.right = right;
    }
}
