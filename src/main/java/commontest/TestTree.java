package commontest;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 遍历树
 * @Author lilong
 * @Date 2019-03-30 19:23
 */
public class TestTree {
    static class TreeNode {
        private int id;
        private String name;
        private TreeNode[] children;

        public TreeNode(int id, String name, TreeNode[] children) {
            this.id = id;
            this.name = name;
            this.children = children;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public TreeNode[] getChildren() {
            return children;
        }

        public void setChildren(TreeNode[] children) {
            this.children = children;
        }
    }

    public static void main(String[] args) {
        // 生成一棵普通树
        TreeNode treeNode1 = new TreeNode(1, "a1", null);
        TreeNode treeNode2 = new TreeNode(2, "a2", null);
        TreeNode treeNode3 = new TreeNode(3, "a3", null);
        TreeNode treeNode4 = new TreeNode(4, "a5", null);

        TreeNode treeNode5 = new TreeNode(5, "a5", null);
        TreeNode treeNode6 = new TreeNode(6, "a6", null);
        TreeNode treeNode7 = new TreeNode(7, "a7", null);
        TreeNode treeNode8 = new TreeNode(8, "a8", null);

        TreeNode treeNode9 = new TreeNode(9, "a9", null);
        TreeNode treeNode10 = new TreeNode(10, "a10", null);
        TreeNode treeNode11 = new TreeNode(11, "a11", null);
        TreeNode treeNode12 = new TreeNode(12, "a12", null);

        treeNode1.setChildren(new TreeNode[]{treeNode2, treeNode3, treeNode4});
        treeNode2.setChildren(new TreeNode[]{treeNode5, treeNode6});
        treeNode3.setChildren(new TreeNode[]{treeNode7});
        treeNode4.setChildren(new TreeNode[]{treeNode8});

        treeNode9.setChildren(new TreeNode[]{treeNode10, treeNode11, treeNode12});

        // 遍历树，获得想要的结果
        List<TreeNode[]> treeNodesLeft = getChildren(new TreeNode[]{treeNode1, treeNode9});

        // 把结果的id取出来
        List<int[]> treeIdList = new ArrayList<>();
        treeNodesLeft.forEach(treeNodeArray -> {
            int[] treeNodeIds = new int[treeNodeArray.length];
            for (int i = 0; i < treeNodeArray.length; i++) {
                treeNodeIds[i] = treeNodeArray[i].getId();
            }
            treeIdList.add(treeNodeIds);
        });
        System.out.println(JSON.toJSONString(treeIdList));
    }

    private static List<TreeNode[]> getChildren(TreeNode[] treeNodes) {
        List<TreeNode[]> treeNodesLeft = new ArrayList<>();
        treeNodesLeft.add(treeNodes);

        getLeftChild(treeNodes[0], treeNodesLeft);

        return treeNodesLeft;
    }

    private static void getLeftChild(TreeNode treeNode, List<TreeNode[]> treeNodeList) {
        if (treeNode == null) {
            return;
        }

        TreeNode[] children = treeNode.getChildren();
        if (children == null) {
            return;
        }

        treeNodeList.add(children);
        getLeftChild(children[0], treeNodeList);
    }
}
