package tree;

/**
 * @Description 测试
 * @Author lilong
 * @Date 2019-02-27 11:35
 */
public class Test {
    public static void main(String[] args) {
        BinTreeNode node1 = new BinTreeNode();
        node1.setData(2);
        node1.setLeft(null);
        node1.setRight(null);

        BinTreeNode node2 = new BinTreeNode();
        node2.setData(3);
        node2.setLeft(null);
        node2.setRight(null);

        BinTreeNode node = new BinTreeNode();
        node.setData(1);
        node.setLeft(node1);
        node.setRight(node2);

        TraverseBinTree traverseBinTree = new TraverseBinTree();
        traverseBinTree.preOrderRecursive(node);
        traverseBinTree.inOrderRecursive(node);
        traverseBinTree.postOrderRecursive(node);
    }
}
