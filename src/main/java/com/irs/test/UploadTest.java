package com.irs.test;

import java.io.*;

public class UploadTest {

    //文件的分割
    public static void Split(String SrcFilePath,int SingleGoalFileSize,String GoalFileDirectory){//SingleGoalFileSize单位：M
        if("".equals(SrcFilePath) || SrcFilePath == null || "".equals(GoalFileDirectory) || GoalFileDirectory == null){
            System.out.println("分割失败!");
            return;
        }

        File SrcFile = new File(SrcFilePath);
        long SrcFileSize = SrcFile.length();//源文件的大小
        long SingleFileSize = 1024 * 1024 * SingleGoalFileSize;//分割后的单个文件大小(单位字节)

        int GoalFileNum = (int)(SrcFileSize/SingleFileSize);
        GoalFileNum = SrcFileSize % SingleFileSize == 0 ? GoalFileNum : GoalFileNum + 1;

        int x1 = SrcFilePath.lastIndexOf("\\");
        int x2 = SrcFilePath.lastIndexOf(".");

        String SrcFileName = SrcFilePath.substring(x1,x2);

        FileInputStream fis = null;
        BufferedInputStream bis = null;
        byte bytes[] = new byte[1024 * 1024];//每次读取文件的大小
        int len = -1;

        try{
            fis = new FileInputStream(SrcFilePath);
            bis = new BufferedInputStream(fis);

            for(int i = 0; i < GoalFileNum; i++){
                //分割后的单个文件完整路径名
                String CompleteSingleGoalFilePath = GoalFileDirectory + File.separator + SrcFileName + "-" + i + SrcFilePath.substring(x2);
                FileOutputStream fos = new FileOutputStream(CompleteSingleGoalFilePath);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                int count = 0;
                while((len = bis.read(bytes))!=-1){
                    bos.write(bytes,0,len);//从源文件读取规定大小的字节数写入到单个目标文件中
                    count += len;
                    if(count >= SingleFileSize)
                        break;
                }
                bos.flush();
                bos.close();
                fos.close();
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if(bis != null) {
                    bis.close();
                }

                if(fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //文件的合并
    public static void Merge(String SingleFilePath[],String GoalFileDirectory){
        if(GoalFileDirectory == null || "".equals(GoalFileDirectory)){
            System.out.println("合并失败!");
            return;
        }

        int x1 = SingleFilePath[0].lastIndexOf("\\");
        int x2 = SingleFilePath[0].lastIndexOf(".");
        String GoalFileName = SingleFilePath[0].substring(x1,x2);

        //合并后的完整路径名
        String CompleteGoalFilePath = GoalFileDirectory + File.separator + GoalFileName.substring(0,GoalFileName.lastIndexOf("-"))+ SingleFilePath[0].substring(x2);

        byte bytes[] = new byte[1024 * 1024];//每次读取文件的大小
        int len = -1;

        FileOutputStream fos = null;//将数据合并到目标文件中
        BufferedOutputStream bos = null;//使用缓冲字节流写入数据
        try{
            fos = new FileOutputStream(CompleteGoalFilePath);
            bos = new BufferedOutputStream(fos);

            for(int i = 0; i < SingleFilePath.length; i++){
                if(SingleFilePath[i] == null || "".equals(SingleFilePath)){
                    System.exit(0);
                }

                FileInputStream fis = new FileInputStream(SingleFilePath[i]);//从分割后的文件读取数据
                BufferedInputStream bis = new BufferedInputStream(fis);//使用缓冲字节流读取数据
                while ((len = bis.read(bytes))!= -1)
                    bos.write(bytes, 0, len);

                bis.close();
                fis.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (bos != null)
                    bos.close();

                if(fos != null)
                    fos.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Split("D:\\迅雷下载\\阳光电影www.ygdy8.com.物怪.BD.720p.韩语中字.mkv", 20, "D:\\迅雷下载2");
       /* String[] MergeFilePath = new String[14];
        for(int i = 0; i < MergeFilePath.length; i++)
            MergeFilePath[i] = new String("E:\\2\\video-" + i + ".mp4");
        Merge(MergeFilePath,"E:\\1");*/
    }
}
