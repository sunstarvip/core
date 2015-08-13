package com.darknight.core.base.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据表格对象
 * Created by DarKnight on 2015/4/8.
 */
public class DataGridEntity<D extends DefaultEntity> implements Serializable {
    private Long total = 0L;
    private List<D> rows = new ArrayList<>();

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<D> getRows() {
        return rows;
    }

    public void setRows(List<D> rows) {
        this.rows = rows;
    }
}
