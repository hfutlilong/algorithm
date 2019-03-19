package tree.normaltree;

import java.util.List;

/**
 * @Description 一颗普通树
 * @Author lilong
 * @Date 2019-02-27 17:32
 */
public class NormalTreeNode implements TreeEntity<NormalTreeNode> {
    /**
     * 分类id
     */
    private Long id;

    /**
     * 父节点id
     */
    private Long parentId;

    /**
     * 子节点
     */
    private List<NormalTreeNode> children;

    public NormalTreeNode() {

    }

    public NormalTreeNode(Long id, Long parentId) {
        this.id = id;
        this.parentId = parentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public List<NormalTreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<NormalTreeNode> children) {
        this.children = children;
    }
}
