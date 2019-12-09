package com.liuft.springbootseed;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFSlideMaster;

import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @author Futong.Liu
 * @title: PPTUtil
 * @description: TODO
 * @date 2019/12/913:38
 */
public class PPTUtil {
    public static void split(InputStream inputStream,String basePath,String baseFileName)throws Exception{
        XMLSlideShow ppt = new XMLSlideShow(inputStream);
        for(XSLFSlideMaster master : ppt.getSlideMasters()){
            for (int j = 0; j < master.getSlideShow().getSlides().size(); j++) {
                XSLFSlide slide = master.getSlideShow().getSlides().get(j);
                XMLSlideShow newPPt = new XMLSlideShow();
                newPPt.createSlide().importContent(slide);
                newPPt.write(new FileOutputStream(basePath+baseFileName+(j+1)+".pptx"));
            }
        }
    }
}
