package com.baizhi.kyh.service;

import com.baizhi.kyh.dao.ChapterDao;
import com.baizhi.kyh.enity.Chapter;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.MultimediaInfo;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@Service("chapterService")
@Transactional
public class ChapterServiceImpl implements ChapterService {
    @Resource(name = "chapterDao")
    private ChapterDao chapterDao;
    @Override
    public void addChapter(Chapter chapter, MultipartFile audiofile, HttpServletRequest request) {
        //设置id为uuid
        UUID uuid1 = UUID.randomUUID();
        String string = uuid1.toString();
        String strId = string.replaceAll("-", "");
        //设置创建时间
        Date date = new Date();
        //获取路径
        String realPath = request.getSession().getServletContext().getRealPath("/");
        realPath = realPath + "audio";
        File file = new File(realPath);
        if (!file.exists()) {
            file.mkdir();
        }
        //获取音频的原始名
        UUID uuid2 = UUID.randomUUID();
        String originalFilename = audiofile.getOriginalFilename();
        //给音频重命名
        String newName = uuid2+originalFilename;
        try {
            audiofile.transferTo(new File(realPath+"/"+newName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取音频大小
        long size = audiofile.getSize();
        String s = size + "";
        File audio = new File(realPath + "/" + newName);
        Encoder encoder = new Encoder();
        String length = "";
        try {
            MultimediaInfo info = encoder.getInfo(audio);
            long duration = info.getDuration();
            long minutes = duration / 60000;
            long sec = duration % 60000 / 1000;
            length=minutes+"分"+sec+"秒";
        } catch (EncoderException e) {
            e.printStackTrace();
        }
        chapter.setUrl(newName);
        chapter.setId(strId);
        chapter.setCreateTime(date);
        chapter.setSize(s);
        chapter.setLength(length);
        chapterDao.insertChapter(chapter);
    }
}
