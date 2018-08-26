package com.baizhi.kyh.dto;

import com.baizhi.kyh.enity.Banner;

import java.io.Serializable;
import java.util.List;

public class BannerSplitDto implements Serializable {
    private Integer total;
    private List<Banner> rows;

    public BannerSplitDto() {
        super();
    }

    @Override
    public String toString() {
        return "BannerSplitDto{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Banner> getRows() {
        return rows;
    }

    public void setRows(List<Banner> rows) {
        this.rows = rows;
    }

    public BannerSplitDto(Integer total, List<Banner> rows) {
        this.total = total;
        this.rows = rows;
    }
}
