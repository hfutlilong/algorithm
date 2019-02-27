package normaltree;

import java.util.List;

public interface TreeEntity<E> {
    /**
     * 获取id
     * @return
     */
    Long getId();

    /**
     * 获取上级分类id
     */
    Long getParentId();

    /**
     * 设置下一层级分类
     */
    void setChildren(List<E> children);
}
