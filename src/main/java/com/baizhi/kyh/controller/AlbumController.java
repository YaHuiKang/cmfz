package com.baizhi.kyh.controller;

import com.baizhi.kyh.enity.Album;
import com.baizhi.kyh.service.AlbumService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("album")
public class AlbumController {
    @Resource(name = "albumService")
    private AlbumService albumService;

    //插入
    @RequestMapping("addAlbum")
    public void addAlbum(Album album, MultipartFile img2, HttpServletRequest request){
        albumService.addAlbum(album,img2,request);
    }

    //查所有专辑
    @RequestMapping("queryAllAlbum")
    public List<Album> queryAllAlbum(){
        return albumService.queryAllAlbum();
    }

    //查所有专辑以及专辑下的所有章节
    @RequestMapping("queryAlbumAndCha")
    public List<Album> queryAlbumAndCha(){
        return albumService.queryAlbumAndCha();
    }

    //查一个
    @RequestMapping("queryAlbumById")
    public Album queryAlbumById(String id){
        return albumService.queryAlbumById(id);
    }

 }
