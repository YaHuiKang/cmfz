package com.baizhi.kyh.service;

import com.baizhi.kyh.dao.BannerDao;
import com.baizhi.kyh.dto.BannerSplitDto;
import com.baizhi.kyh.enity.Banner;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("bannerService")
@Transactional
public class BannerServiceImpl implements BannerService {
    @Resource(name = "bannerDao")
    private BannerDao bannerDao;

    //上传
    @Override
    public void uploadBanner(MultipartFile img, Integer status, String description,String url, HttpServletRequest request) {
        //设置id为uuid
        UUID uuid1 = UUID.randomUUID();
        String string = uuid1.toString();
        String strId = string.replaceAll("-", "");
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
        Banner banner = new Banner(strId,newName, realPath, description, status, new Date(),url);
        bannerDao.insertBanner(banner);
    }
    //查所有
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public BannerSplitDto queryAllBannerBySplit(Integer page, Integer rows) {
        BannerSplitDto bannerSplitDto = new BannerSplitDto();
        Page<Banner> sp = PageHelper.startPage(page, rows);
        bannerDao.selectAllBanner();
        List<Banner> result = sp.getResult();
        Integer i = bannerDao.countRows();
        bannerSplitDto.setRows(result);
        bannerSplitDto.setTotal(i);
        return bannerSplitDto;
    }
    //删除
    @Override
    public void dropOneBanner(String id) {
        bannerDao.deleteOneBanner(id);
    }

    //更改
    @Override
    public void editBanner(Banner banner) {
        bannerDao.updateBanner(banner);
    }
}
