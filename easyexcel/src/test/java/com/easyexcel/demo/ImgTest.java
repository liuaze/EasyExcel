package com.easyexcel.demo;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

/**
 *@author:liuze
 *@createDate:2019/10/11
 */
public class ImgTest {

    @Test
    public void httpsTest(){
        try {
            String url1 = "https://img30.360buyimg.com/shaidan/jfs/t1/43957/20/11701/160234/5d53d183E553db085/8093837a4b8f827f.jpg";
            String url2 = "img10.360buyimg.com/promotepic/s750x375_jfs/t1/65223/4/12348/72021/5d9c723fE08174d96/74c5f77c3a21c630.jpg";
            String url3 = "http://storage.jd.com/detail.image/805652d2-c063-45b4-bb65-76a1fbcf7c2d_img";
            HttpURLConnection connection = (HttpURLConnection) new URL(url3).openConnection();
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(5000);
            connection.setRequestMethod("GET");
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                BufferedImage read = ImageIO.read(inputStream);
                int height = read.getHeight();
                int width = read.getWidth();
                System.out.println("h="+height+",w="+width);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void urlTest(){
        try {
            String url1 = "https://img30.360buyimg.com/shaidan/jfs/t1/43957/20/11701/160234/5d53d183E553db085/8093837a4b8f827f.jpg";
            String url2 = "//img10.360buyimg.com/promotepic/s750x375_jfs/t1/65223/4/12348/72021/5d9c723fE08174d96/74c5f77c3a21c630.jpg";
            String url3 = "http://storage.jd.com/detail.image/805652d2-c063-45b4-bb65-76a1fbcf7c2d_img";
            String url4 = "https://cdn.songshuhui.net/wp-content/uploads/wpid-GmwtyhTySJ1Pf9N_eS2l-Qk7CbSrCmSGUNt70zNERFKAAgAAhgEAAEpQ-2015-05-13-19-16.jpg";
            BufferedImage read = ImageIO.read(new URL(url4));
            int height = read.getHeight();
            int width = read.getWidth();
            System.out.println("h="+height+",w="+width);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    @Test
    public void stringTest(){
        try {
            Long start = new Date().getTime();
            String url = "https://img30.360buyimg.com/shaidan/jfs/t1/43957/20/11701/160234/5d53d183E553db085/8093837a4b8f827f.jpg,//img10.360buyimg.com/promotepic/s750x375_jfs/t1/65223/4/12348/72021/5d9c723fE08174d96/74c5f77c3a21c630.jpg,http://storage.jd.com/detail.image/805652d2-c063-45b4-bb65-76a1fbcf7c2d_img";
            //String url = "https://img30.360buyimg.com/shaidan/jfs/t1/43957/20/11701/160234/5d53d183E553db085/8093837a4b8f827f.jpg";
            String[] split = url.split(",");
            StringBuffer stringBuffer = new StringBuffer();

            for (String s : split) {
                BufferedImage read = null;
                if(s.startsWith("http")){
                    read = ImageIO.read(new URL(s));
                }else{
                    String s1 = "http:"+s;
                    read = ImageIO.read(new URL(s1));
                }
                int height = read.getHeight();
                int width = read.getWidth();
                // ?W=XXX&H=XXX
                s=s+"?w="+width+"&h="+height;

                if(stringBuffer.length()>0){
                    stringBuffer.append(",");
                }
                stringBuffer.append(s);

            }
            Long end = new Date().getTime();
            System.out.println("sss="+(end-start));
            System.out.println("sb="+stringBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void replaceTest(){

        String s = "1 ，               2，3，4，5";
        String news = "";
        if(s.contains(" ")){
            s = s.replace(" ","");
        }
        if(s.contains("，")){
           news = s.replace("，", ",");
            System.out.println(news);
        }



        String[] split = news.split(",");
        System.out.println(JSON.toJSONString(split));

    }







}
