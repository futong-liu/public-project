package com.liuft.springbootseed;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFSlideMaster;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author Futong.Liu
 * @title: Demo
 * @description: TODO
 * @date 2019/12/911:06
 */
public class Demo {

    public static void main(String[] args) throws Exception {
        String baseFileName = "temp.pptx".substring(0,"temp.pptx".lastIndexOf("."));
        System.out.println(baseFileName);
    }
}
