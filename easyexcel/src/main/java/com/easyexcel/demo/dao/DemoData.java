package com.easyexcel.demo.dao;/**
 * @Author: liuze
 * @Date: 2019/9/30 14:47
 */

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;
import java.util.Date;

/**
 * 简单的写
 *@author:liuze
 *@createDate:2019/9/30
 */
@Data
public class DemoData {
    @ExcelProperty("pin")
    private String string;

    String s = "" ;









}
