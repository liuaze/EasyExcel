package com.easyexcel.demo.dao;/**
 * @Author: liuze
 * @Date: 2019/9/30 14:47
 */

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;
import java.util.Date;

/**
 *@author:liuze
 *@createDate:2019/9/30
 */
@Data
public class DemoData {
    @ExcelProperty("标题")
    private String string;
    @ExcelProperty("日期")
    private Date date;
    @ExcelProperty("数字")
    private Double doubleData;
}
