package com.baizhi.kyh.service;

import com.baizhi.kyh.enity.Chapter;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

public interface ChapterService {
    //添加章节
    void addChapter(Chapter chapter, MultipartFile audiofile, HttpServletRequest request);
}
