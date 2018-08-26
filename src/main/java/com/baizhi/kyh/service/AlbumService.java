package com.baizhi.kyh.service;

import com.baizhi.kyh.enity.Album;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface AlbumService {
    //添加
    void addAlbum(Album album, MultipartFile img, HttpServletRequest request);
    //查所有
    List<Album> queryAllAlbum();
    //查专辑以及专辑下的章节
    List<Album> queryAlbumAndCha();
    //根据专辑id查专辑详情
    Album queryAlbumById(String id);
}
