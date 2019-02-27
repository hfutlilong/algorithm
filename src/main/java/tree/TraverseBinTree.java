package tree;

/**
 * @Description 前序遍历、中序遍历、后序遍历
 * @Author lilong
 * @Date 2019-02-27 11:26
 */
public class TraverseBinTree {
    /**
     * 前序遍历（递归）
     * @param root
     */
    public void preOrderRecursive(BinTreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.getData());
        preOrderRecursive(root.getLeft());
        preOrderRecursive(root.getRight());
    }

    /**
     * 中序遍历（递归）
     * @param root
     */
    public void inOrderRecursive(BinTreeNode root) {
        if (root == null) {
            return;
        }

        preOrderRecursive(root.getLeft());
        System.out.println(root.getData());
        preOrderRecursive(root.getRight());
    }

    /**
     * 后序遍历（递归）
     * @param root
     */
    public void postOrderRecursive(BinTreeNode root) {
        if (root == null) {
            return;
        }

        preOrderRecursive(root.getLeft());
        preOrderRecursive(root.getRight());
        System.out.println(root.getData());
    }
}
