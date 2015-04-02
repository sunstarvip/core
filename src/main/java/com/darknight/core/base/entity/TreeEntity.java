package com.darknight.core.base.entity;

import com.darknight.core.util.ParameterUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 树型实体对象
 * Created by DarKnight on 2015/4/1.
 */
public class TreeEntity extends BaseEntity {
    /**
     * 节点名称
     */
    private String text;
    /**
     * 节点展开状态
     */
    private String state;
    /**
     * 父节点ID
     */
    private String parentId;

    /**
     * 子节点对象列表
     */
    private List<? extends TreeEntity> children = new ArrayList<>();

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<? extends TreeEntity> getChildren() {
        return children;
    }

    public void setChildren(List<? extends TreeEntity> children) {
        this.children = children;
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

    public interface State {
        public static final String OPEN = ParameterUtil.OPEN;
        public static final String CLOSED = ParameterUtil.CLOSED;
    }
}
