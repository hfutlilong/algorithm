package tree;

import java.util.Stack;

/**
 * @Description 前序遍历、中序遍历、后序遍历
 * @Author lilong
 * @Date 2019-02-27 11:26
 */
public class TraverseBinTree {
    /* 递归 */
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


    /* 非递归 */
    /**
     * 前序遍历
     * @param root
     */
    public void preOrder(BinTreeNode root) {
        if (root == null) {
            return;
        }

        Stack<BinTreeNode> stack = new Stack<BinTreeNode>();
        while (true) {
            while (root != null) {
                System.out.println(root.getData());
                stack.push(root);
                root = root.getLeft();
            }

            if (stack.isEmpty()) {
                break;
            }

            root = stack.pop();
            root = root.getRight();
        }
    }

    /**
     * 中序遍历
     * @param root
     */
    public void inOrder(BinTreeNode root) {
        if (root == null) {
            return;
        }

        Stack<BinTreeNode> stack = new Stack<BinTreeNode>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.getLeft();
            }

            if (stack.isEmpty()) {
                break;
            }

            root = stack.pop();
            System.out.println(root.getData());
            root = root.getRight();
        }
    }

    /**
     * 后序遍历
     * @param root
     */
    public void postOrder(BinTreeNode root) {
        if (root == null) {
            return;
        }

        Stack<BinTreeNode> stack = new Stack<BinTreeNode>();
        while (true) {
            if (root != null) {
                stack.push(root);
                root = root.getLeft();
            } else {
                if (stack.isEmpty()) {
                    System.out.println("Stack is empty.");
                    return;
                } else {
                    if (stack.peek().getRight() == null) {
                        root = stack.pop();
                        System.out.println(root.getData());
                        if (root == stack.peek().getRight()) {
                            System.out.println(stack.peek().getData());
                            stack.pop();
                        }
                    }

                    if (!stack.isEmpty()) {
                        root = stack.peek().getRight();
                    } else {
                        root = null;
                    }
                }
            }
        }
    }
}
