package com.easyexcel.demo.dao;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * 日期数字格式转换
 *@author:liuze
 *@createDate:2019/10/8
 */
public class ConverterData {

    @ExcelProperty(value = "标题")
    private String string;

    @DateTimeFormat("yyyy年MM月dd日HH时mm分ss秒")
    @ExcelProperty("日期")
    private Date date;

    @NumberFormat("#.##%")
    @ExcelProperty("数字")
    private Double doubleData;


}
