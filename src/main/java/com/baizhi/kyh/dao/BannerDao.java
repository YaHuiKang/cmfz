package com.baizhi.kyh.dao;

import com.baizhi.kyh.enity.Banner;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BannerDao {
    //上传
     void insertBanner(Banner banner);
    //查所有
    List<Banner> selectAllBanner();
    //删除
    void deleteOneBanner(String id);
    //修改
    void updateBanner(Banner banner);
    //查所有行
    Integer countRows();
}
