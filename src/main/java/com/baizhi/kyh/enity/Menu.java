package com.baizhi.kyh.enity;

import java.io.Serializable;
import java.util.List;

public class Menu implements Serializable {
    private String id;
    private String title;
    private String href;
    private String iconCls;
    private List<Menu> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public Menu(String id, String title, String href, String iconCls, List<Menu> children) {
        this.id = id;
        this.title = title;
        this.href = href;
        this.iconCls = iconCls;
        this.children = children;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", href='" + href + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", children=" + children +
                '}';
    }

    public Menu() {
        super();
    }
}
