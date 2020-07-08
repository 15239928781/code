package com.irs.service;

import com.irs.pojo.Plupload;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.*;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;


/**
 * Plupload Service模块，同Plupload实体类一样，因为要用到Spring web相关依赖，所以不将其放在Service模块
 */
@Component    //将写好的类注入SpringIOC容器中让Controller自动装载
public class PluploadService {
    public Plupload upload(Plupload plupload, File pluploadDir){
        String fileSub = plupload.getName().substring(plupload.getName().lastIndexOf(".")).toLowerCase();
        Random d = new Random();
        String fileName = UUID.randomUUID().toString().replace("-", "") + d.nextInt(10000) + "" + fileSub;//在服务器内生成唯一文件名
        Plupload plupload1=upload(plupload, pluploadDir, fileName);
        return plupload1;
    }

    private Plupload upload(Plupload plupload,File pluploadDir,String fileName){

        int chunks = plupload.getChunks();//用户上传文件被分隔的总块数
        int nowChunk = plupload.getChunk();//当前块，从0开始

        //这里Request请求类型的强制转换可能出错，配置文件中向SpringIOC容器引入multipartResolver对象即可。
        MultipartHttpServletRequest multipartHttpServletRequest  = (MultipartHttpServletRequest)plupload.getRequest();
        //调试发现map中只有一个键值对
        MultiValueMap<String,MultipartFile> map = multipartHttpServletRequest.getMultiFileMap();

        if(map!=null){
            try{
                Iterator<String> iterator = map.keySet().iterator();
                while(iterator.hasNext()){

                    String key = iterator.next();
                    List<MultipartFile> multipartFileList = map.get(key);

                    for(MultipartFile multipartFile:multipartFileList){//循环只进行一次

                        plupload.setMultipartFile(multipartFile);//手动向Plupload对象传入MultipartFile属性值
                        File targetFile = new File(pluploadDir+"/"+fileName);//新建目标文件，只有被流写入时才会真正存在
                        if(chunks>1){//用户上传资料总块数大于1，要进行合并

                            File tempFile = new File(pluploadDir.getPath()+"/"+multipartFile.getName());
                            //第一块直接从头写入，不用从末端写入
                            savePluploadFile(multipartFile.getInputStream(),tempFile,nowChunk==0?false:true);
                            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
                            if(suffix.equals("ppt")|| suffix.equals("pptx")){
                                tempFile.renameTo(targetFile);
                                //每当文件上传完毕，将上传信息插入数据库
                                Timestamp now = new Timestamp(System.currentTimeMillis());

                                System.out.println(now);
                            }
                            if(chunks-nowChunk==1){//全部块已经上传完毕，此时targetFile因为有被流写入而存在，要改文件名字
                                tempFile.renameTo(targetFile);

                                //每当文件上传完毕，将上传信息插入数据库
                                Timestamp now = new Timestamp(System.currentTimeMillis());

                                System.out.println(now);
                                // youandmeService.uploadInfo(fileName,((User)(plupload.getRequest().getSession().getAttribute("user"))).getUsername(),now);
                            }
                        }
                        else{
                            //只有一块，就直接拷贝文件内容
                            multipartFile.transferTo(targetFile);

                            //每当文件上传完毕，将上传信息插入数据库
                            Timestamp now = new Timestamp(System.currentTimeMillis());

                            System.out.println(now);
                            // youandmeService.uploadInfo(fileName, ((User) (plupload.getRequest().getSession().getAttribute("user"))).getUsername(), now);
                        }
                        //获取视频时长
                       // Encoder encoder = new Encoder();
                        String length = "";
                        try {
                           /* MultimediaInfo m = encoder.getInfo(targetFile);
                            System.out.println("-------"+m.getDuration());
                            long ls = m.getDuration()/1000;
                            int hour = (int) (ls/3600);
                            int minute = (int) (ls%3600)/60;
                            int second = (int) (ls-hour*3600-minute*60);
                            length = hour+"时"+minute+"分"+second+"秒";*/
                            System.out.println(length);
                            //获取文件后缀名
                            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
                            /*if(!suffix.equals("mp4")&& !suffix.equals("ppt") && !suffix.equals("pptx") !suffix.equals("mp4")){
                               //将视频转为MP4格式
                                ConvertVideo.Mp4(fileName);

                            }*/
                            //删除不是以MP4格式的文件名
                            /*File file = new File("C:\\upload\\"+fileName);
                            file.delete();
                            if ((fileName != null) && (fileName.length() > 0)) {
                                int dot = fileName.lastIndexOf('.');
                                if ((dot >-1) && (dot < (fileName.length() - 1))) {
                                    fileName= fileName.substring(0, dot);
                                }
                            }*/
                            Plupload plupload1=new Plupload();
//                            if(suffix.equals("ppt")){
//                                plupload1.setName(fileName);
//                            }
//                            if (suffix.equals("pptx")){
//                                plupload1.setName(fileName);
//                            }
//                            if(suffix.equals("mp4")){
                                plupload1.setName(fileName);
//                            }

                            plupload1.setTimelength(length);
                            return plupload1;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        return null;
    }
    private void savePluploadFile(InputStream inputStream,File tempFile,boolean flag){
        OutputStream outputStream = null;
        try {
            if(flag==false){
                //从头写入
                outputStream = new BufferedOutputStream(new FileOutputStream(tempFile));
            }
            else{
                //从末端写入
                outputStream = new BufferedOutputStream(new FileOutputStream(tempFile,true));
            }
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = (inputStream.read(bytes)))>0){
                outputStream.write(bytes,0,len);
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try{
                outputStream.close();
                inputStream.close();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
