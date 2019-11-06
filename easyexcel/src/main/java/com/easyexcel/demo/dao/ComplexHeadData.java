package com.easyexcel.demo.dao;/**
 * @Author: liuze
 * @Date: 2019/10/8 10:14
 */

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 复杂头写入
 *@author:liuze
 *@createDate:2019/10/8
 */
@Data
public class ComplexHeadData {

    @ExcelProperty({"标题","字符串"})
    private String string;
    @ExcelProperty({"标题1","日期"})
    private Date date;
    @ExcelProperty({"标题1","数字"})
    private Double doubleData;


}
