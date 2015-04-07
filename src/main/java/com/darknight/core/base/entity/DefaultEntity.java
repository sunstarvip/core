package com.darknight.core.base.entity;

import com.darknight.core.util.ParameterUtil;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * 默认实体对象
 * Created by DarKnight on 14-2-2.
 */
@MappedSuperclass
@Access(AccessType.PROPERTY)
public class DefaultEntity extends BaseEntity {
    /**
     * 是否启用：YES启用 NO不启用
     */
    private String enableTag = EnableTag.YES;  // 是否启用：YES启用 NO不启用
    /**
     * 是否逻辑删除：YES未逻辑删除 NO已逻辑删除
     */
    private String visibleTag = VisibleTag.YES;  // 是否逻辑删除：YES未逻辑删除 NO已逻辑删除
    /**
     * 创建时间
     * 不可更新
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    @Override
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy="uuid")
    public String getId() {
        return super.getId();
    }

    public void setId(String id) {
        super.setId(id);
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
                    DefaultEntity other = (DefaultEntity)obj;
                    return getId().equals(other.getId());
                }
            }
        }
        return false;
    }

    public interface EnableTag {
        String YES = ParameterUtil.YES;
        String NO = ParameterUtil.NO;
    }

    public interface VisibleTag {
        String YES = ParameterUtil.YES;
        String NO = ParameterUtil.NO;
    }

}
