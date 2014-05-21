package com.darknight.core.base.entity;

import com.darknight.core.util.ParameterUtil;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by DarKnight on 14-2-2.
 */
@MappedSuperclass
@Access(AccessType.PROPERTY)
public class DefaultEntity {
    private String id;
    private String enableTag = EnableTag.YES;
    private String visibleTag = VisibleTag.YES;
    private Integer sort = Sort.START;
    private Date createTime = new Date();
    private Date updateTime;

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy="uuid2")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEnableTag() {
        return enableTag;
    }

    public void setEnableTag(String enableTag) {
        this.enableTag = enableTag;
    }

    public String getVisibleTag() {
        return visibleTag;
    }

    public void setVisibleTag(String visibleTag) {
        this.visibleTag = visibleTag;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Column(updatable=false)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public boolean equals(Object obj) {
        if(obj != null) {
            if(this == obj) {
                return true;
            }else {
                if(getClass() == obj.getClass()) {
                    DefaultEntity other = (DefaultEntity)obj;
                    return getId().equals(other.getId());
                }
            }
        }
        return false;
    }

    public interface EnableTag {
        public static final String YES = ParameterUtil.YES;
        public static final String NO = ParameterUtil.NO;
    }

    public interface VisibleTag {
        public static final String YES = ParameterUtil.YES;
        public static final String NO = ParameterUtil.NO;
    }

    public interface Sort {
        public static final Integer START = ParameterUtil.START;
    }
}
