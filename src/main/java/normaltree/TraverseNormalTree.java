package normaltree;


import java.util.ArrayList;
import java.util.List;

/**
 * @Description 遍历普通树
 * @Author lilong
 * @Date 2019-02-27 17:39
 */
public class TraverseNormalTree {
    public static void main(String[] args) {
        List<NormalTreeNode> normalTreeNodeList = new ArrayList<>();
        normalTreeNodeList.add(new NormalTreeNode(1L, 0L));
        normalTreeNodeList.add(new NormalTreeNode(2L, 0L));
        normalTreeNodeList.add(new NormalTreeNode(3L, 1L));
        normalTreeNodeList.add(new NormalTreeNode(4L, 1L));
        normalTreeNodeList.add(new NormalTreeNode(5L, 1L));
        normalTreeNodeList.add(new NormalTreeNode(6L, 2L));
        normalTreeNodeList.add(new NormalTreeNode(7L, 2L));
        normalTreeNodeList.add(new NormalTreeNode(8L, 3L));


        List<NormalTreeNode> normalTree = buildNormalTree(normalTreeNodeList);

        traverseNormalTree(normalTree);

    }

    /**
     * 构建一颗普通树
     * @param normalTreeNodeList
     */
    private static List<NormalTreeNode> buildNormalTree(List<NormalTreeNode> normalTreeNodeList) {
        return TreeParser.getTreeList(0L, normalTreeNodeList);
    }
    /**
     * 遍历多叉树
     * @param normalTree
     */
    private static void traverseNormalTree(List<NormalTreeNode> normalTree){
        //递归退出条件
        if (normalTree == null){
            return;
        }

        //遍历多叉树
        for (NormalTreeNode normalTreeNode : normalTree){
            System.out.println(normalTreeNode.getId());
        }

        //遍历多叉树
        for (NormalTreeNode normalTreeNode : normalTree){
            traverseNormalTree(normalTreeNode.getChildren());
        }
    }
}
