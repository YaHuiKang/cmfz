package com.baizhi.kyh.service;

import com.baizhi.kyh.dao.AlbumDao;
import com.baizhi.kyh.enity.Album;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service("albumService")
@Transactional
public class AlbumServiceImpl implements AlbumService {
    @Resource(name = "albumDao")
    private AlbumDao albumDao;
    //添加
    @Override
    public void addAlbum(Album album, MultipartFile img, HttpServletRequest request) {
        UUID uuid = UUID.randomUUID();
        String uId = uuid.toString().replaceAll("-", "");
        album.setId(uId);
        //获取路径
        String realPath = request.getSession().getServletContext().getRealPath("/");
        realPath = realPath + "banner";
        File file = new File(realPath);
        if (!file.exists()) {
            file.mkdir();
        }
        //获取图片的原始名
        UUID uuid2 = UUID.randomUUID();
        String originalFilename = img.getOriginalFilename();
        //获取原始名的后缀
        String extension = FilenameUtils.getExtension(originalFilename);
        //给图片重命名
        String newName = uuid2 + "." + extension;
        try {
            img.transferTo(new File(realPath+"/"+newName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        album.setCoverImg(newName);
        albumDao.insertAlbum(album);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Album> queryAllAlbum() {
        return albumDao.selectAllAlbum();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Album> queryAlbumAndCha() {
        return albumDao.selectAlbumAndCha();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Album queryAlbumById(String id) {
        return albumDao.selectAlbumById(id);
    }
}
