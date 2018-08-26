package com.baizhi.kyh.service;

import com.baizhi.kyh.dao.UserDao;
import com.baizhi.kyh.dto.UserEchartsDto;
import com.baizhi.kyh.enity.User;
import com.baizhi.kyh.util.SecurityCode;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Resource(name = "userDao")
    private UserDao userDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<User> queryAllUser() {
        return userDao.selectAllUser();
    }

    //添加
    @Override
    public void addUser(User user, MultipartFile photoww, HttpServletRequest request) {
        //生成用户id
        UUID uuid = UUID.randomUUID();
        String userId = uuid.toString().replaceAll("-", "");
        //调用工具类生成随机四位数作为盐
        String securityCode = SecurityCode.getSecurityCode();
        user.setSalt(securityCode);
        //密码加盐
        String password = user.getPassword() + securityCode;
        String md5 = DigestUtils.md5Hex(password);
        user.setPassword(md5);

        //获取路径
        String realPath = request.getSession().getServletContext().getRealPath("/");
        File file = new File(realPath + "banner");
        if (!file.exists()) {
            file.mkdir();
        }
        //生成UUID
        UUID uuid2 = UUID.randomUUID();
        //获取图片的原始名
        String originalFilename = photoww.getOriginalFilename();
        String newname = uuid2 + originalFilename;
        //UUID和图片名生成图片名称
        try {
            photoww.transferTo(new File(realPath + "banner" + newname));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //照片
        user.setPhoto(newname);
        //创建时间
        Date date = new Date();
        user.setCreateTime(date);
        userDao.insertUser(user);
    }

    //上传
    @Override
    public void uploadExcel(User user, MultipartFile excel) {
        try {
            InputStream inputStream = excel.getInputStream();
            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            HSSFSheet sheet = workbook.getSheetAt(0);
            for (int i = 1; i < sheet.getLastRowNum(); i++) {
                //生成用户id
                UUID uuid = UUID.randomUUID();
                String userId = uuid.toString().replaceAll("-", "");
                user.setId(userId);
                user.setPhoto("1");
                user.setSalt("123");
                user.setPhoneNum("11");
                user.setSex(1);
                user.setSign("11");
                user.setStatus(1);
                user.setUsername("11");
                HSSFRow row1 = sheet.getRow(i);
                String s = row1.getCell(0).getStringCellValue();
                System.out.println(s);
                String stringCellValue = row1.getCell(1).getStringCellValue();
                System.out.println(stringCellValue);
                user.setName(row1.getCell(0).getStringCellValue());
                user.setDharmaName(row1.getCell(1).getStringCellValue());
                user.setProvince(row1.getCell(2).getStringCellValue());
                user.setCity(row1.getCell(3).getStringCellValue());
                user.setCreateTime(row1.getCell(4).getDateCellValue());
                userDao.insertUser(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<UserEchartsDto> queryUserBySex(Integer sex) {
        return userDao.seletUserBySex(sex);

    }
    @Override
    public Map<String, Object> conutUserByTime() {
        Map<String, Object> map = new HashMap<>();
        Date date = new Date();
        Date time1= new Date(date.getTime() - 1000 * 60 * 60 * 24 * 3L);
        Integer i1 = userDao.countUserByTime(time1);
        Date time2= new Date(date.getTime() - 1000 * 60 * 60 * 24 * 6L);
        Integer i2 = userDao.countUserByTime(time2);
        Date time3= new Date(date.getTime() - 1000 * 60 * 60 * 24 * 9L);
        Integer i3 = userDao.countUserByTime(time3);
        Date time4= new Date(date.getTime() - 1000 * 60 * 60 * 24 * 12L);
        Integer i4 = userDao.countUserByTime(time4);
        String[] strs = {"3天","6天","9天","12天"};
        Integer[] ints = {i1,i2,i3,i4};
        map.put("intervals",strs);
        map.put("counts",ints);
        return map;
    }

}
