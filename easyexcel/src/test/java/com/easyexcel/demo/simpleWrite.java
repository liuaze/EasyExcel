package com.easyexcel.demo;/**
 * @Author: liuze
 * @Date: 2019/9/30 14:55
 */

import com.alibaba.excel.EasyExcel;
import com.easyexcel.demo.dao.DemoData;
import com.easyexcel.demo.util.TestFileUtil;
import org.junit.Test;

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


}
