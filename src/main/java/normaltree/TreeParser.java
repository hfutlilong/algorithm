package normaltree;

import java.util.ArrayList;
import java.util.List;

/**
 * 把普通列表解析成树状结构
 */
public class TreeParser {

    /**
     * 生成树状结构
     * @param topId
     * @param entityList
     * @param <E>
     * @return
     */
    public static <E extends TreeEntity<E>> List<E> getTreeList(Long topId, List<E> entityList) {
        if (entityList == null){
            throw new NullPointerException();
        }

        List<E> resultList = new ArrayList<>();

        //获取顶层元素集合
        Long parentId;
        for (E entity : entityList) {
            parentId = entity.getParentId();
            if(parentId == null || topId.equals(parentId)){
                resultList.add(entity);
            }
        }

        //获取每个顶层元素的子数据集合
        for (E entity : resultList) {
            entity.setChildren(getSubList(entity.getId(),entityList));
        }

        return resultList;
    }

    /**
     * 获取子元素
     * @param id
     * @param entityList
     * @param <E>
     * @return
     */
    private static <E extends TreeEntity<E>> List<E> getSubList(Long id, List<E> entityList) {
        List<E> childList=new ArrayList<>();
        Long parentId;

        //子集的直接子对象
        for (E entity : entityList) {
            parentId = entity.getParentId();
            if(id.equals(parentId)){
                childList.add(entity);
            }
        }

        //递归：子集的间接子对象
        for (E entity : childList) {
            entity.setChildren(getSubList(entity.getId(), entityList));
        }

        //递归退出条件
        if(childList.size()==0){
            return null;
        }

        return childList;
    }
}