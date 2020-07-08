package com.irs.util;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.poi.hslf.model.Slide;
import org.apache.poi.hslf.model.TextRun;
import org.apache.poi.hslf.usermodel.RichTextRun;
import org.apache.poi.hslf.usermodel.SlideShow;

public class PDFUTil {
    public static void main(String[] args) {
       /* File file = new File("F:\\0916110518.pdf");
        try {
            PDDocument doc = PDDocument.load(file);
            PDFRenderer renderer = new PDFRenderer(doc);
            int pageCount = doc.getNumberOfPages();
            for (int i = 0; i < pageCount; i++) {
                // 方式1,第二个参数是设置缩放比(即像素)
                BufferedImage image = renderer.renderImageWithDPI(i, 296);
                // 方式2,第二个参数是设置缩放比(即像素)
                // BufferedImage image = renderer.renderImage(i, 2.5f);
                ImageIO.write(image, "PNG", new File("F:\\2.png"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        File file1 = new File("F:\\0916110518.pdf");
        File file2= new File("F:\\");
        List<String> arrayList=new ArrayList<>();
        PDFUTil.pdfs(file1,file2,arrayList,"4");


    }

    public static List<String> pdfs(File pptFile, File imgFile, List<String> list, String fileName) {

        // File file = new File("F:\\0916110518.pdf");

        try {
            FileInputStream is = new FileInputStream(pptFile);

            PDDocument doc = PDDocument.load(is);
            is.close();
            PDFRenderer renderer = new PDFRenderer(doc);
            int pageCount = doc.getNumberOfPages();
            for (int i = 0; i < pageCount; i++) {
                // 方式1,第二个参数是设置缩放比(即像素)
                BufferedImage image = renderer.renderImageWithDPI(i, 296);
                // 方式2,第二个参数是设置缩放比(即像素)
                // BufferedImage image = renderer.renderImage(i, 2.5f);
                // ImageIO.write(image, "PNG", new File("F:\\2.png"));
                String absolutePath = imgFile.getAbsolutePath() + "/" + (fileName + i + 1) + ".png";
                File jpegFile = new File(absolutePath);
                // 图片路径存放
                list.add((fileName + i + 1) + ".png");
                // 如果图片存在，则不再生成
                if (jpegFile.exists()) {
                    continue;
                }
                // 这里设置图片的存放路径和图片的格式(jpeg,png,bmp等等),注意生成文件路径
                FileOutputStream out = new FileOutputStream(jpegFile);
                ImageIO.write(image, "PNG", out);
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    /**
     * ppt2003 文档的转换 后缀名为.ppt
     * @param pptFile ppt文件
     * @param imgFile 图片将要保存的目录（不是文件）
     * @return
     */
    public static List<String> doPPT2003toImage(File pptFile, File imgFile, List<String> list, String fileName) {
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

}
