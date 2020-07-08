package com.irs.controller;

import com.alibaba.druid.util.StringUtils;
import com.irs.util.GlobalUtil;
import org.artofsolving.jodconverter.OfficeDocumentConverter;
import org.artofsolving.jodconverter.office.DefaultOfficeManagerConfiguration;
import org.artofsolving.jodconverter.office.OfficeManager;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.regex.Pattern;

public class DocConverterController {

    public static void main(String[] args) {
        String path = GlobalUtil.getValue("upfile.path");
        String name = "byb.pptx";
        String infilr = path + "/" + name;
        String namem = "byb";
        String targetfile = path + "/" + namem + ".pdf";
        // String infilr="F:\\byb.pptx";
        // String targetfile="F:\\byb.pdf";
        File file = new File(infilr);
        File file1 = new File(targetfile);
        office2pdf(infilr, targetfile);
    }

    public void onLineReadFile(String fileName, HttpServletResponse response) {
        try {
            //文件夹路径
            String mkPath = GlobalUtil.getValue("upfile.path");
            String originSourcePath = mkPath + "/" + fileName;
            //获取预览文件的路径
            String outputSourcePath = DocConverterController.getOutputFilePath(originSourcePath);
            File pdfFile = new File(outputSourcePath);
            while (!pdfFile.exists()) {
                Thread.sleep(1000);
            }
            //输出pdf到浏览器
            BufferedInputStream br = new BufferedInputStream(new FileInputStream(pdfFile));
            byte[] buf = new byte[1024];
            int len = 0;
            response.reset(); // 非常重要
            response.setContentType("application/pdf;charset=utf-8");
            response.setHeader("Content-Disposition",
                    "inline; filename=" + java.net.URLEncoder.encode(pdfFile.getName(), "UTF-8"));

            OutputStream out = response.getOutputStream();
            while ((len = br.read(buf)) != -1)
                out.write(buf, 0, len);
            br.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 连接OpenOffice.org 并且启动OpenOffice.org
     *
     * @return
     */
    public static OfficeManager getOfficeManager() {
        DefaultOfficeManagerConfiguration config;
        config = new DefaultOfficeManagerConfiguration();
        // 设置OpenOffice.org 3的安装目录
        config.setOfficeHome(getOfficeHome());
        // 启动OpenOffice的服务
        OfficeManager officeManager = config.buildOfficeManager();
        officeManager.start();
        return officeManager;
    }

    /**
     * 转换文件
     *
     * @param inputFile
     * @param outputFilePath_end
     * @param inputFilePath
     * @param outputFilePath_end
     * @param converter
     */
    public static File converterFile(File inputFile, String outputFilePath_end, String inputFilePath,
                                     OfficeDocumentConverter converter) {
        File outputFile = new File(outputFilePath_end);
        // 假如目标路径不存在,则新建该路径
        if (!outputFile.getParentFile().exists()) {
            outputFile.getParentFile().mkdirs();
        }
        converter.convert(inputFile, outputFile);
        System.out.println("文件：" + inputFilePath + "\n转换为\n目标文件：" + outputFile + "\n成功!");
        return outputFile;
    }

    /**
     * 使Office2003-2007全部格式的文档(.doc|.docx|.xls|.xlsx|.ppt|.pptx) 转化为pdf文件<br>
     *
     * @param inputFilePath 源文件路径，如："e:/test.docx"
     *                      目标文件路径，如："e:/test_docx.pdf"
     * @return
     */
    public static File office2pdf(String inputFilePath, String outputFilePath_end) {
        OfficeManager officeManager = null;
        try {
            if (StringUtils.isEmpty(inputFilePath)) {
                System.out.println("输入文件地址为空，转换终止!");
                return null;
            }
            File inputFile;
            String originSourceTxtName = inputFilePath.substring(inputFilePath.lastIndexOf("."));
            if (originSourceTxtName.equalsIgnoreCase(".txt")) {
                //是txt则需要转化为odt，然后再转为pdf
                outputFilePath_end = outputFilePath_end.replaceAll("." + getPostfix(outputFilePath_end), ".txt.pdf");
                System.out.println(outputFilePath_end);

            }
            inputFile = new File(inputFilePath); // 用于处理PDF文档
            if (!inputFile.exists() && !getPostfix(inputFilePath).equals("txt")) {
                System.out.println("输入文件不存在，转换终止!");
                return null;
            }
            // 获取OpenOffice的安装路劲
            officeManager = getOfficeManager();
            // 连接OpenOffice
            OfficeDocumentConverter converter = new OfficeDocumentConverter(officeManager);
            return converterFile(inputFile, outputFilePath_end, inputFilePath, converter);
        } catch (Exception e) {
            System.out.println("转化出错!");
        } finally {
            // 停止openOffice
            if (officeManager != null) {
                officeManager.stop();
            }
        }
        return null;
    }

    /**
     * 根据操作系统的名称，获取OpenOffice.org 3的安装目录<br>
     * 如我的OpenOffice.org 3安装在：C:/Program Files (x86)/OpenOffice.org 3<br>
     *
     * @return OpenOffice.org 3的安装目录
     */
    public static String getOfficeHome() {

        String osName = System.getProperty("os.name");
        System.out.println("操作系统名称:" + osName);
        if (Pattern.matches("Linux.*", osName)) {
            return "/opt/openoffice.org3";
        } else if (Pattern.matches("Windows.*", osName)) {
            return "C:\\byb\\open";
        } else if (Pattern.matches("Mac.*", osName)) {
            return "/Applications/OpenOffice.org.app/Contents/";
        }
        return null;
    }

    /**
     * 获取输出文件的路径
     *
     * @param inputFilePath
     * @return
     */
    public static String getOutputFilePath(String inputFilePath) {
        String outputFilePath = inputFilePath.replaceAll("." + getPostfix(inputFilePath), ".pdf");
        return outputFilePath;
    }

    /**
     * 获取inputFilePath的后缀名，如："e:/test.pptx"的后缀名为："pptx"<br>
     *
     * @param inputFilePath
     * @return
     */
    public static String getPostfix(String inputFilePath) {
        return inputFilePath.substring(inputFilePath.lastIndexOf(".") + 1);
    }
}
