package com.baizhi.kyh.controller;

import com.baizhi.kyh.enity.Chapter;
import com.baizhi.kyh.service.ChapterService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@RequestMapping("chapter")
public class ChapterController {
    @Resource(name = "chapterService")
    private ChapterService chapterService;
    //添加章节
    @RequestMapping("addChapter")
    public void addChapter(Chapter chapter, MultipartFile audiofile, HttpServletRequest request){
        chapterService.addChapter(chapter,audiofile,request);
    }
}
