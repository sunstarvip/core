package com.darknight.core.base.entity;

/**
 * 树型实体对象
 * Created by DarKnight on 2015/4/1.
 */
public class TreeEntity extends BaseEntity {
    /**
     * 父级ID
     */
    private String parentId;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 判断对象是否相等
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if(obj != null) {
            if(this == obj) {
                return true;
            }else {
                if(getClass() == obj.getClass()) {
                    TreeEntity other = (TreeEntity)obj;
                    return getId().equals(other.getId());
                }
            }
        }
        return false;
    }
}
