package com.baizhi.kyh.dao;

import com.baizhi.kyh.enity.Album;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumDao {
    //添加
    void insertAlbum(Album album);

    //查看章节详情
    Album selectOneAlbum(String id);

    //查所有
    List<Album> selectAllAlbum();

    //查专辑以及专辑下的章节
    List<Album> selectAlbumAndCha();

    //根据专辑id查专辑详情
    Album selectAlbumById(String id);
}