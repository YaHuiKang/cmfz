package com.baizhi.kyh.dao;

import com.baizhi.kyh.enity.Chapter;
import org.springframework.stereotype.Repository;

@Repository
public interface ChapterDao {
    //添加章节
    void insertChapter(Chapter chapter);
}