package com.darknight.core.base.entity;

import com.darknight.core.util.ParameterUtil;

import java.io.Serializable;

/**
 * 用于封装RESTful请求的返回值
 * Created by DarKnight on 2015/4/19.
 */
public class ResultEntity implements Serializable {
    /**
     * 用来保存请求执行状态
     * success：成功；fail：失败（默认值）
     */
    String status = Status.FAIL;
    /**
     * 用来保存请求返回的JSON数据
     */
    String dataInfo;
    /**
     * 用来保存请求返回的操作消息
     */
    String msgInfo;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDataInfo() {
        return dataInfo;
    }

    public void setDataInfo(String dataInfo) {
        this.dataInfo = dataInfo;
    }

    public String getMsgInfo() {
        return msgInfo;
    }

    public void setMsgInfo(String msgInfo) {
        this.msgInfo = msgInfo;
    }

    public interface Status {
        String SUCCESS = ParameterUtil.SUCCESS;
        String FAIL = ParameterUtil.FAIL;
    }
}
