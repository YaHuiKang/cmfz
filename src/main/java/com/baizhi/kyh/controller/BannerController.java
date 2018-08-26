package com.baizhi.kyh.controller;

import com.baizhi.kyh.dto.BannerSplitDto;
import com.baizhi.kyh.enity.Banner;
import com.baizhi.kyh.service.BannerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("banner")
public class BannerController {
    @Resource(name = "bannerService")
    private BannerService bannerService;
    //上传
    @RequestMapping("upload")
    public void upload(MultipartFile img, Integer status, String description,String url, HttpServletRequest request){
        bannerService.uploadBanner(img, status, description,url,request);
    }

    //查所有
    @RequestMapping("queryAllBanner")
    public BannerSplitDto queryAllBanner(Integer page , Integer rows){
        return bannerService.queryAllBannerBySplit(page, rows);
    }

    //删除
    @RequestMapping("dropOneBanner")
    public void dropOneBanner(String id){
        bannerService.dropOneBanner(id);
    }
    //修改
    @RequestMapping("editBanner")
    public void editBanner(Banner banner){
        bannerService.editBanner(banner);
    }
}
