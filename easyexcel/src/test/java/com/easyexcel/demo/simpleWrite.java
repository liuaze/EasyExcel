package com.easyexcel.demo;/**
 * @Author: liuze
 * @Date: 2019/9/30 14:55
 */

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.easyexcel.demo.dao.ComplexHeadData;
import com.easyexcel.demo.dao.ConverterData;
import com.easyexcel.demo.dao.DemoData;
import com.easyexcel.demo.listener.DemoDataListener;
import com.easyexcel.demo.util.TestFileUtil;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *@author:liuze
 *@createDate:2019/9/30
 */
public class simpleWrite extends DemoApplicationTests {

    /**
     * 最简单的写
     */
    @Test
    public void simpleWrite(){

        String fileName = TestFileUtil.getPath()+"simpleWrite"+System.currentTimeMillis()+ ".xlsx";
        EasyExcel.write(fileName, DemoData.class).sheet("模板").doWrite(data());
    }

    private List<DemoData> data() {
        List<DemoData> list = new ArrayList<DemoData>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }

    @Test
    public void complexHeadWrite(){
        String fileName = TestFileUtil.getPath()+"simpleWrite"+System.currentTimeMillis()+".xlsx";
        EasyExcel.write(fileName, ComplexHeadData.class).sheet("复杂头").doWrite(data());

    }

    @Test
    public void converterWrite(){
        String fileName = TestFileUtil.getPath()+"simpleWrite"+System.currentTimeMillis()+".xlsx";
        EasyExcel.write(fileName, ConverterData.class).sheet("格式转换").doWrite(data());
    }

    @Test
    public void simpleRead(){
        // 写法1：
        String fileName = TestFileUtil.getPath() + File.separator + "simpleWrite1569827408968.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).sheet().doRead();

    }


}
