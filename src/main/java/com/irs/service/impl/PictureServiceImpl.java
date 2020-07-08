package com.irs.service.impl;

import com.irs.mapper.ShopPictureMapper;
import com.irs.mapper.ShopProductMapper;
import com.irs.pojo.ShopPicture;
import com.irs.pojo.ShopPictureExample;
import com.irs.pojo.ShopProduct;
import com.irs.pojo.ShopProductExample;
import com.irs.service.PictureService;
import com.irs.util.CommonUtils;
import com.irs.util.GlobalUtil;
import com.irs.util.WxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;

@Service
public class PictureServiceImpl implements PictureService
{

    @Autowired
    private ShopPictureMapper pictureMapper;
    @Autowired
    private ShopProductMapper productMapper;
    @Override
    public WxResult uploadPicture(HttpServletRequest request, MultipartFile uploadFile) {
        Map resultMap=new HashMap();
        try {
            if (request instanceof MultipartHttpServletRequest) {
                uploadFile = ((MultipartHttpServletRequest)request).getFile("file");
            }

            if(uploadFile!=null && uploadFile.getOriginalFilename()
                    !=null && uploadFile.getOriginalFilename().length()>0){
                /**
                 * 项目服务器地址路径
                 */
                String projectServerPath = request.getScheme() + "://"+request.getServerName()+":" +
                        request.getServerPort()+"/ssm/file/showPic?fileName=";
                /**
                 * 上传文件绝对路径
                 */
                String path = GlobalUtil.getValue("upfile.path");
                //原始名称
                String oldFileName = uploadFile.getOriginalFilename();

                //新的图片名称
                String newFileName = UUID.randomUUID() + oldFileName.substring(oldFileName.lastIndexOf("."));
                //新图片
                File newFile = new File(path + "\\" + newFileName);
                /**
                 * 判断路径是否存在，如果不存在就创建一个
                 */
                if (!newFile.getParentFile().exists()) {

                    newFile.getParentFile().mkdirs();
                }
                /**
                 * 创建文件
                 */
                uploadFile.transferTo(new File(path + File.separator + newFileName));
                String serverFilePatn = projectServerPath + newFileName;

                resultMap.put("error", 0);
                resultMap.put("url",serverFilePatn);
                return WxResult.ok(resultMap);

            }else{
                //返回结果
                resultMap.put("error", 1);
                resultMap.put("message", "文件异常");
                return WxResult.ok(resultMap);
            }
        } catch (Exception e) {
            resultMap.put("error", 1);
            resultMap.put("message", "文件上传发生异常");
            return WxResult.ok(resultMap);
        }
    }

    @Override
    public  List<ShopPicture> selectByPid(Integer valueOf) {


        List<ShopPicture> list = new ArrayList();
        ShopProduct shopProduct=productMapper.selectByPrimaryKey(valueOf);
        String  pptorpdf =shopProduct.getpIsgroup();

        String[] ary = pptorpdf.split(",");
        //ShopPicture shopPicture = new ShopPicture();
    for(int k=0;k<ary.length;k++){
        ShopPicture shopPicture = new ShopPicture();
        if(ary[k].indexOf(".")!=1){
         String s= ary[k].substring(0,ary[k].indexOf("."));
        System.out.println(s);
        ShopPictureExample example=new ShopPictureExample();
        example.setOrderByClause("sp_id");

        ShopPictureExample.Criteria criteria=example.createCriteria();
        criteria.andImagesLike("%"+s+"%");
        //List<ShopPicture> list = new ArrayList();
        List<ShopPicture> pictureList=pictureMapper.selectByExample(example);

        shopPicture.setPdf(pictureList);
    }
        list.add(shopPicture);
}


        return list;
    }

    @Override
    public String  selectByPid2(Integer integer) {
        List<ShopPicture> list = new ArrayList();
        ShopProduct shopProduct=productMapper.selectByPrimaryKey(integer);
        String  pptorpdf =shopProduct.getpIsgroup();
        String[] ary = pptorpdf.split(",");
        List<String> strings = new ArrayList<>();
        for(String item: ary) {
            String suffix= CommonUtils.getSuffix(String.valueOf(item));
            String fileName = CommonUtils.getFileName(item);
            if(suffix.equals("pptx")){
                item=fileName+"pdf";
                strings.add(item);
        }else{
                strings.add(item);
            }

        }

        return null;
    }

    @Override
    public List<ShopPicture> selShopPictureImg(Integer valueOf) {
        ShopPictureExample shopPictureExample = new ShopPictureExample();
        ShopPictureExample.Criteria criteria = shopPictureExample.createCriteria();
        criteria.andPIdEqualTo(valueOf);
        List<ShopPicture> shopPictures = pictureMapper.selectByExample(shopPictureExample);
        return shopPictures;
    }
}
