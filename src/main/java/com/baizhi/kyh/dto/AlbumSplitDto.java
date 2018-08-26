package com.baizhi.kyh.dto;

import com.baizhi.kyh.enity.Album;

import java.io.Serializable;
import java.util.List;

public class AlbumSplitDto implements Serializable {
    private Integer total;
    private List<Album> rows;

    public AlbumSplitDto() {
        super();
    }

    @Override
    public String toString() {
        return "AlbumSplitDto{" +
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

    public List<Album> getRows() {
        return rows;
    }

    public void setRows(List<Album> rows) {
        this.rows = rows;
    }

    public AlbumSplitDto(Integer total, List<Album> rows) {
        this.total = total;
        this.rows = rows;
    }
}
