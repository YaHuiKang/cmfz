package com.baizhi.kyh.controller;

import com.baizhi.kyh.dto.UserEchartsDto;
import com.baizhi.kyh.enity.User;
import com.baizhi.kyh.service.UserService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Resource(name = "userService")
    private UserService userService;

    @RequestMapping("addUser")
    public void addUser(User user, MultipartFile photoww, HttpServletRequest request) {
        userService.addUser(user, photoww, request);
    }

    //查所有
    @RequestMapping("queryAllUser")
    public List<User> queryAllUser(){
        return userService.queryAllUser();
    }
    //下载表格
    @RequestMapping("/downloadExcel")
    public void downloadExcel(User user,HttpServletResponse response) {
        //创建工作簿对象
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建工作表
        HSSFSheet sheet = workbook.createSheet("用户表");
        //创建标题行
        HSSFRow row = sheet.createRow(0);
        String[] title = {"法名","姓名","省份","城市","创建时间"};
        HSSFCell cell = null;
        for(int i=0;i<title.length;i++){
            cell =  row.createCell(i);
            cell.setCellValue(title[i]);
        }

        //日期的处理
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        HSSFDataFormat dataFormat = workbook.createDataFormat();
        cellStyle.setDataFormat(dataFormat.getFormat("yyyy-MM-dd"));
        //获取数据转化格式
        List<User> users = userService.queryAllUser();
        for (int i=1;i<=users.size();i++){
            row = sheet.createRow(i);
            cell = row.createCell(0);
            cell.setCellValue(users.get(i-1).getDharmaName());
            HSSFCell cell1 = row.createCell(1);
            cell1.setCellValue(users.get(i-1).getName());
            HSSFCell cell2 = row.createCell(2);
            cell2.setCellValue(users.get(i-1).getProvince());
            HSSFCell cell3 = row.createCell(3);
            cell3.setCellValue(users.get(i-1).getCity());
            HSSFCell cell4 = row.createCell(4);
            cell4.setCellValue(users.get(i-1).getCreateTime());
            cell4.setCellStyle(cellStyle);
        }
        String fileName = "用户报表("+new SimpleDateFormat("yyyy-MM-dd").format(new Date())+").xls";
        try {
            fileName = new String(fileName.getBytes("gbk"), "iso-8859-1");
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("content-disposition","attachment;fileName="+fileName);
            workbook.write(response.getOutputStream());
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/customer")
    public void customer(String texts,String fields,HttpServletResponse response){
        //创建工作簿对象
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("指定用户");
        String[] titles = texts.split(",");
        String[] params = fields.split(",");
        Row row = sheet.createRow(0);
        for (int i=0;i<titles.length;i++){
            row.createCell(i).setCellValue(titles[i]);
        }
        List<User> users = userService.queryAllUser();

        for (int i=0;i<users.size();i++) {
            Class<? extends User> aClass = users.get(i).getClass();
            Row row1 = sheet.createRow(i + 1);
            for (int j = 0; j < params.length; j++) {
                String methodName = "get" + params[j].substring(0, 1).toUpperCase() + params[j].substring(1);
                Object a = null;
                try {
                    a = aClass.getDeclaredMethod(methodName, null).invoke(users.get(i), null);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (a instanceof Date) {
                    DataFormat dataFormat = workbook.createDataFormat();
                    short format = dataFormat.getFormat("yyyy-MM-dd");
                    CellStyle cellStyle = workbook.createCellStyle();
                    cellStyle.setDataFormat(format);
                    Cell cell = row1.createCell(j);
                    cell.setCellStyle(cellStyle);
                    cell.setCellValue((Date) a);
                }else {
                    row1.createCell(j).setCellValue(String.valueOf(a));
                }
            }
        }
        String filePattern = "部分用户表("+new SimpleDateFormat("yyyy-MM-dd").format(new Date())+").xls";
        try {
            filePattern = new String(filePattern.getBytes("gbk"), "iso-8859-1");
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("content-disposition","attachment;filePattern="+filePattern);
            workbook.write(response.getOutputStream());
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //导入
    @RequestMapping("importExcel")
    public void importExcel(User user,MultipartFile excel){
        userService.uploadExcel(user,excel);
    }

    //根据性别查用户
    @RequestMapping("queryUserBySex")
    public List<UserEchartsDto> queryUserBySex(Integer sex){
        return userService.queryUserBySex(sex);
    }
    //根据注册时间统计用户数量
    @RequestMapping("conutUserByTime")
    public Map<String, Object> conutUserByTime(){
        Map<String, Object> map = userService.conutUserByTime();
        return  map;
    }
}
