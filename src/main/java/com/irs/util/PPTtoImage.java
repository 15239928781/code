package com.irs.util;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.poi.hslf.model.Slide;
import org.apache.poi.hslf.model.TextRun;
import org.apache.poi.hslf.usermodel.RichTextRun;
import org.apache.poi.hslf.usermodel.SlideShow;
import org.apache.poi.xslf.usermodel.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PPTtoImage {
    public static void main(String[] args) {
        // 读入PPT文件
        File file = new File("D:\\pdf\\111.ppt");
        File imgFile=new File("D:\\pdf\\img");
        List<String> list=new ArrayList<>();
   //    List<String> arrayList=doPPT2003toImage(file,imgFile,list);
//      List<String> arrayList = doPPT2007toImage(file,imgFile,list);
       /* for (String s : arrayList) {
            System.out.println(s);
        }*/
    }
    /**
     * 转换全部的pdf
     * @param
     *             //String fileAddress,String filename,String type
     */
    public static List<String>   pdf2png(File pdfFile, File imgFile, List<String> list,String fileName) {
        // 将pdf装图片 并且自定义图片得格式大小
       //File file = new File(fileAddress+"\\"+filename+".pdf");
        try {
           FileInputStream is = new FileInputStream(pdfFile);
            PDDocument doc = PDDocument.load(is);
            is.close();
            PDFRenderer renderer = new PDFRenderer(doc);
            int pageCount = doc.getNumberOfPages();
            for (int i = 0; i < pageCount; i++) {
                BufferedImage image = renderer.renderImageWithDPI(i, 144); // Windows native DPI
                //BufferedImage srcImage = resize(image, 240, 240);//产生缩略图

                String absolutePath = imgFile.getAbsolutePath()+"/"+ (fileName+i + 1) + ".PNG";
                File jpegFile = new File(absolutePath);
                // 图片路径存放
                list.add((fileName+i + 1) + ".PNG");
                // 如果图片存在，则不再生成
                if (jpegFile.exists()) {
                    continue;
                }
                // 这里设置图片的存放路径和图片的格式(jpeg,png,bmp等等),注意生成文件路径
                FileOutputStream out = new FileOutputStream(jpegFile);
                ImageIO.write(image, ".PNG", out);
            }
            System.out.println("PPT转换成图片 成功！");
            return list;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("PPT转换成图片 发生异常！");
        }
        return list;
    }




    /**
     * ppt2003 文档的转换 后缀名为.ppt
     * @param pptFile ppt文件
     * @param imgFile 图片将要保存的目录（不是文件）
     * @return
     */
    public static List<String> doPPT2003toImage(File pptFile, File imgFile, List<String> list,String fileName) {
        try {
            FileInputStream is = new FileInputStream(pptFile);
            SlideShow ppt = new SlideShow(is);
            //及时关闭掉 输入流
            is.close();
            Dimension pgsize = ppt.getPageSize();
            Slide[] slide = ppt.getSlides();
            for (int i = 0; i < slide.length; i++) {
                //System.out.println("第" + i + "页。");
                //TextRun[] truns = slide[i].getTextRuns();
                System.out.print("第" + i + "页。");
                if(slide[i].getNotesSheet()!=null&&slide[i].getNotesSheet().getTextRuns()!=null){
                    //获取第一个备注
                    System.out.println("备注：" + slide[i].getNotesSheet().getTextRuns()[0].getText());
                }
                TextRun[] truns = slide[i].getTextRuns();
                for (int k = 0; k < truns.length; k++) {
                    RichTextRun[] rtruns = truns[k].getRichTextRuns();
                    //System.out.println(rtruns.getText());
                    for (int l = 0; l < rtruns.length; l++) {
                        // 原有的字体索引 和 字体名字
                        //int index = rtruns[l].getFontIndex();
                        //String name = rtruns[l].getFontName();
                        //System.out.println("原有的字体索引 和 字体名字: "+index+" - "+name);
                        // 重新设置 字体索引 和 字体名称 是为了防止生成的图片乱码问题
                        rtruns[l].setFontIndex(1);
                        rtruns[l].setFontName("宋体");
                        // 获取文本列表
                        System.out.println(rtruns[l].getText());
                    }
                }
                //根据幻灯片大小生成图片
                BufferedImage img = new BufferedImage(pgsize.width,pgsize.height, BufferedImage.TYPE_INT_RGB);
                Graphics2D graphics = img.createGraphics();
                graphics.setPaint(Color.white);
                graphics.fill(new Rectangle2D.Float(0, 0, pgsize.width,pgsize.height));
                slide[i].draw(graphics);
                // 图片的保存位置
                String absolutePath = imgFile.getAbsolutePath()+"/"+ (fileName+i + 1) + ".jpeg";
                File jpegFile = new File(absolutePath);
                // 图片路径存放
                list.add((fileName+i + 1) + ".jpeg");
                // 如果图片存在，则不再生成
                if (jpegFile.exists()) {
                    continue;
                }
                // 这里设置图片的存放路径和图片的格式(jpeg,png,bmp等等),注意生成文件路径
                FileOutputStream out = new FileOutputStream(jpegFile);
                ImageIO.write(img, "jpeg", out);
                out.close();
            }
            System.out.println("PPT转换成图片 成功！");
            return list;
        } catch (Exception e) {
            System.out.println("PPT转换成图片 发生异常！");
        }
        return list;
    }




    /**
     * ppt2007文档的转换 后缀为.pptx
     * @param pptFile PPT文件
     * @param imgFile 图片将要保存的路径目录（不是文件）
     * @param list 存放文件名的 list
     * @return
     */
    public static List<String> doPPT2007toImage(File pptFile,File imgFile,List<String> list,String fileName) {
        FileInputStream is = null ;
        try {
            is = new FileInputStream(pptFile);
            XMLSlideShow xmlSlideShow = new XMLSlideShow(is);
            is.close();
            // 获取大小
            Dimension pgsize = xmlSlideShow.getPageSize();
            // 获取幻灯片
            XSLFSlide[] slides = xmlSlideShow.getSlides();
            for (int i = 0 ; i < slides.length ; i++) {
                // 解决乱码问题
                XSLFShape[] shapes = slides[i].getShapes();
                for (XSLFShape shape : shapes) {
                    if (shape instanceof XSLFTextShape) {
                        XSLFTextShape sh = (XSLFTextShape) shape;
                        List<XSLFTextParagraph> textParagraphs = sh.getTextParagraphs();

                        for (XSLFTextParagraph xslfTextParagraph : textParagraphs) {
                            List<XSLFTextRun> textRuns = xslfTextParagraph.getTextRuns();
                            for (XSLFTextRun xslfTextRun : textRuns) {
                                xslfTextRun.setFontFamily("宋体");
                                xslfTextRun.getText();
                                System.out.println(xslfTextRun.getText());

                            }
                        }
                    }
                }
                //根据幻灯片大小生成图片
                BufferedImage img = new BufferedImage(pgsize.width,pgsize.height, BufferedImage.TYPE_INT_RGB);
                Graphics2D graphics = img.createGraphics();
                graphics.setPaint(Color.white);
                graphics.fill(new Rectangle2D.Float(0, 0, pgsize.width,pgsize.height));
                // 最核心的代码
                slides[i].draw(graphics);
                //图片将要存放的路径
                String absolutePath = imgFile.getAbsolutePath()+"/"+ (fileName+i + 1) + ".jpeg";
                File jpegFile = new File(absolutePath);
                // 图片路径存放
                list.add((fileName+i + 1) + ".jpeg");
                //如果图片存在，则不再生成
                if (jpegFile.exists()) {
                    continue;
                }
                // 这里设置图片的存放路径和图片的格式(jpeg,png,bmp等等),注意生成文件路径
                FileOutputStream out = new FileOutputStream(jpegFile);

                // 写入到图片中去
                ImageIO.write(img, "jpeg", out);
                out.close();
            }
            System.out.println("PPT转换成图片 成功！");
            return list;
        } catch (Exception e) {
            System.out.println("PPT转换成图片 发生异常！");
        }
        return list;
    }

}