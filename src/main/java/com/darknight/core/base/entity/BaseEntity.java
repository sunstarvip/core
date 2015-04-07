package com.darknight.core.base.entity;

import com.darknight.core.util.ParameterUtil;

import java.io.Serializable;

/**
 * 基础实体对象
 * Created by DarKnight on 2015/4/1.
 */
public class BaseEntity implements Serializable {
    /**
     * 主键
     */
    private String id;  // 主键
    /**
     * 排序值 默认值为0
     */
    private Integer sort = Sort.START;  // 排序值 默认值为0

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 判断对象是否相等
     * @param obj
     * @return
     */
    public boolean equals(Object obj) {
        if(obj != null) {
            if(this == obj) {
                return true;
            }else {
                if(getClass() == obj.getClass()) {
                    BaseEntity other = (BaseEntity)obj;
                    return getId().equals(other.getId());
                }
            }
        }
        return false;
    }

    public interface Sort {
        Integer START = ParameterUtil.START;
    }
}
