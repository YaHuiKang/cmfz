package com.baizhi.kyh.service;

import com.baizhi.kyh.aop.LogAnnotation;
import com.baizhi.kyh.dto.BannerSplitDto;
import com.baizhi.kyh.enity.Banner;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface BannerService {
    //上传
    @LogAnnotation(name = "下载")
    void uploadBanner(MultipartFile img, Integer status, String description,String url, HttpServletRequest request);
    //分页查所有
    @LogAnnotation(name = "分页查")
    BannerSplitDto queryAllBannerBySplit(Integer page, Integer rows);
    //删除
    @LogAnnotation(name="删除")
    void dropOneBanner(String id);
    //修改
    @LogAnnotation(name = "修改")
    void editBanner(Banner banner);
}
