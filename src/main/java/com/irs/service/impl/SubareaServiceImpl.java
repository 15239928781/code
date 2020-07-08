package com.irs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.irs.controller.DocConverterController;
import com.irs.mapper.*;
import com.irs.pojo.*;
import com.irs.service.SubareaService;
import com.irs.util.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class SubareaServiceImpl implements SubareaService {
    @Autowired
    private ShopPictureMapper pictureMapper;

    @Autowired
    private ShopProductMapper shopProductMapper;
    @Autowired
    private LevelMapper levelMapper;

    @Autowired
    private SubareaMapper subareaMapper;
    @Autowired
    private SvlMapper svlMapper;

    @Autowired
    private PsbMapper psbMapper;
    @Override
    public Subarea selSubareaById(Long id) {
        return subareaMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updSubarea(Subarea subarea) {
        subareaMapper.updateByPrimaryKeySelective(subarea);
    }

    @Override
    public void delSubareaById(Long sbId) {
        subareaMapper.deleteByPrimaryKey(sbId);
        PsbExample psbExample = new PsbExample();
        PsbExample.Criteria criteria = psbExample.createCriteria();
        criteria.andSbidEqualTo(sbId);
        psbMapper.deleteByExample(psbExample);

    }

    @Override
    public void delSubarea(String carouselStr) {
        List<Long> leids=new ArrayList<>();
        if(!StringUtils.isBlank(carouselStr)){
            String[] ids=carouselStr.split(",");
            for (String id : ids) {
                leids.add(Long.parseLong(id));

                PsbExample psbExample = new PsbExample();
                PsbExample.Criteria criteria2 = psbExample.createCriteria();
                criteria2.andSbidEqualTo(Long.parseLong(id));
                psbMapper.deleteByExample(psbExample);
            }
        }
        SubareaExample example=new SubareaExample();
        SubareaExample.Criteria criteria=example.createCriteria();
        criteria.andSbIdIn(leids);
        subareaMapper.deleteByExample(example);


    }

    @Override
    public Subarea checkSubareaByleName(String leName) {
        SubareaExample example=new SubareaExample();
        SubareaExample.Criteria criteria=example.createCriteria();
        criteria.andSbNameEqualTo(leName);
        List<Subarea> list=subareaMapper.selectByExample(example);
        if(list.size()>0) return list.get(0);
        return null;
}

    @Override
    public void insSubarea(Subarea subarea) {
        subareaMapper.insertSelective(subarea);
    }

    @Override
    public ResultUtil setSubarea(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        SubareaExample example=new SubareaExample();
        example.setOrderByClause("sb_id desc");
        SubareaExample.Criteria criteria=example.createCriteria();
        List<Subarea>  list=subareaMapper.selectByExample(example);
      for(Subarea subarea:list){
          SvlExample svlExample = new SvlExample();
          SvlExample.Criteria criteria1 = svlExample.createCriteria();
          criteria1.andSbIdEqualTo(subarea.getSbId());
          List<Svl> svl = svlMapper.selectByExample(svlExample);
         if(!svl.isEmpty()){
             Integer leId = svl.get(0).getLeId();
            if(leId!=null){
                Level level = levelMapper.selectByPrimaryKey(leId);
                subarea.setLeName(level.getLeName());
            }

         }

      }


        PageInfo<Subarea> pageInfo=new PageInfo<>(list);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public void updsubareaStatusById(Long sbId, Integer sbIsshow) {
        Subarea carousel = subareaMapper.selectByPrimaryKey(sbId);
        carousel.setSbIsshow(sbIsshow);

        subareaMapper.updateByPrimaryKey(carousel);
    }

    @Override
    public void instPSbProduct(String carouselStr,Long sbId) {
        List<Long> leids=new ArrayList<>();
        if(!StringUtils.isBlank(carouselStr)){
            String[] ids=carouselStr.split(",");
            for (String id : ids) {
               // leids.add(Long.parseLong(id));
                /*PsbExample psbExample = new PsbExample();
                PsbExample.Criteria criteria = psbExample.createCriteria();*/

                   Psb psd1 = new Psb();
                   psd1.setpId(Integer.parseInt(id));
                   psd1.setSbid(sbId);
                   psbMapper.insertSelective(psd1);



            }
        }

    }

    @Override
    public ResultUtil lookProduct(Integer page, Integer limit, String sbId) {
        PsbExample psbExample = new PsbExample();
        PsbExample.Criteria criteria = psbExample.createCriteria();


        return null;
    }

    @Override
    public ResultUtil getProductList(Integer page, Integer limit, Long sbId) {

        PsbExample psbExample = new PsbExample();
        PsbExample.Criteria criteria = psbExample.createCriteria();
        criteria.andSbidEqualTo(sbId);
        List<Psb> psbs = psbMapper.selectByExample(psbExample);
        for (Psb psb: psbs) {
            ShopProduct shopProduct = shopProductMapper.selectByPrimaryKey(psb.getpId());
            Subarea subarea = subareaMapper.selectByPrimaryKey(sbId);
            psb.setpName(shopProduct.getpName());
            psb.setSbName(subarea.getSbName());
        }
        PageInfo<Psb> pageInfo=new PageInfo<>(psbs);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public Psb selSubareaProduct(Integer pId, Long sbId) {
        PsbExample psbExample = new PsbExample();
        PsbExample.Criteria criteria = psbExample.createCriteria();
        criteria.andSbidEqualTo(sbId);
        criteria.andPIdEqualTo(pId);
        List<Psb> psbs = psbMapper.selectByExample(psbExample);

        if(!psbs.isEmpty()) {


            for (Psb psb : psbs) {

                ShopProduct shopProduct = shopProductMapper.selectByPrimaryKey(psb.getpId());
                Subarea subarea = subareaMapper.selectByPrimaryKey(sbId);
                psb.setpName(shopProduct.getpName());
                psb.setSbName(subarea.getSbName());
            }
            Psb psb = psbs.get(0);
            return psb;
        }
return null;

    }

    @Override
    public Psb updateProduct(Psb psb) {
        PsbExample psbExample = new PsbExample();
        PsbExample.Criteria criteria = psbExample.createCriteria();
        criteria.andSbidEqualTo(psb.getSbid());
        criteria.andPIdEqualTo(psb.getpId());
        psbMapper.updateByExampleSelective(psb,psbExample);

        return null;
    }

    @Override
    public void delSubareaProducts(String userStr, Long sbId) {
        if(!StringUtils.isBlank(userStr)){
            String[] ids=userStr.split(",");
            for (String id : ids) {
                PsbExample psbExample = new PsbExample();
                PsbExample.Criteria criteria = psbExample.createCriteria();
                criteria.andSbidEqualTo(sbId);
                criteria.andPIdEqualTo(Integer.parseInt(id));
                psbMapper.deleteByExample(psbExample);
            }
        }
    }

    @Override
    public ResultUtil getProductListFirst(Integer page, Integer limit, Long sbId) {
        PageHelper.startPage(page, limit);
        ShopProductExample example=new ShopProductExample();
        example.setOrderByClause("p_id desc");
        ShopProductExample.Criteria criteria=example.createCriteria();
        //criteria.andSbIdNotEqualTo(sbId);
        criteria.andSbIdIsNull();
        List<ShopProduct> shopProducts = shopProductMapper.selectByExample(example);
     /*  for(ShopProduct shopProduct:shopProducts){
           PsbExample psbExample = new PsbExample();
           PsbExample.Criteria criteria2 = psbExample.createCriteria();
           criteria2.andSbidEqualTo(sbId);
           criteria2.andPIdEqualTo(shopProduct.getpId());
           List<Psb> psbs = psbMapper.selectByExample(psbExample);
           *//* if(!psbs.isEmpty()){
                 shopProducts.remove(shopProduct);
                shopProducts.re
                }*//*




       }*/


        Iterator<ShopProduct> it =shopProducts.iterator();
        while (it.hasNext())
        {
            ShopProduct shopProduct = it.next();
            PsbExample psbExample = new PsbExample();
            PsbExample.Criteria criteria2 = psbExample.createCriteria();
            criteria2.andSbidEqualTo(sbId);
            criteria2.andPIdEqualTo(shopProduct.getpId());
            List<Psb> psbs = psbMapper.selectByExample(psbExample);
            if (!psbs.isEmpty())
            {
                /*if(shopProduct.getSbId()!=sbId&&shopProduct.getSbId()!=null){
                    it.remove();
                }*/
                it.remove();
            }
            Long sbId1 = shopProduct.getSbId();
            if(sbId!=shopProduct.getSbId()&&shopProduct.getSbId()!=null){
                it.remove();
            }
        }
        PageInfo<ShopProduct> pageInfo=new PageInfo<>(shopProducts);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;

    }

    @Override
    public WxResult getSubareaPro(HttpServletRequest request, Integer page, Integer limit,String sbId, int pValidity) {
 /*List<ShopProduct> list=productMapper.selectByExample(example);

        for (ShopProduct product : list) {
            product.setpImage(saveUrl+product.getpImage());
        }*/
        String saveUrl=request.getScheme() + "://"+request.getServerName()+":" +
                request.getServerPort()+"/ssm/file/showPic?fileName=";
        Subarea subarea = subareaMapper.selectByPrimaryKey(Long.parseLong(sbId));
       // PageHelper.startPage(page, limit);
        PsbExample psbExample = new PsbExample();
        PsbExample.Criteria criteria = psbExample.createCriteria();
        criteria.andSbidEqualTo(Long.parseLong(sbId));
        List<Psb> psbs = psbMapper.selectByExample(psbExample);

       //PageHelper.startPage(page, limit);
        List<ShopProduct> shopProducts = new ArrayList<ShopProduct>();
        for(Psb psb :psbs){
             if(psb.getpId()!=null){
                 Integer integer = psb.getpId();
                 ShopProduct shopProduct = shopProductMapper.selectByPrimaryKey(integer);

                 Double psbPrices= psb.getPsbOldprices();
                   if(psb.getPsbOldprices()==null){
                       shopProduct.setpOldprice(shopProduct.getpOldprice());
                   }else{
                       shopProduct.setpOldprice(psb.getPsbOldprices());
                   }
                   if(psb.getPsbOldprices()==null){
                       shopProduct.setpPrice(shopProduct.getpPrice());
                   }else{
                       shopProduct.setpPrice(psb.getPsbPrices());
                   }



                 shopProduct.setpImage(saveUrl+shopProduct.getpImage());


                       shopProducts.add(shopProduct);



    }

    /*ShopProductExample shopProductExample = new ShopProductExample();
    ShopProductExample.Criteria criteria1 = shopProductExample.createCriteria();*/


}
        List<ShopProduct> shopProducts0 = new ArrayList<ShopProduct>();//0
        List<ShopProduct> shopProducts1 = new ArrayList<ShopProduct>();//1
        List<ShopProduct> shopProducts3 = new ArrayList<ShopProduct>();
        for (ShopProduct shopProduct : shopProducts) {
            if(shopProduct.getpValidity()==0){
                shopProducts0.add(shopProduct);
            }else if(shopProduct.getpValidity()==1){
                shopProducts1.add(shopProduct);
            }else{
                shopProducts3.add(shopProduct);
            }



        }
        List<ShopProduct> shopProducts10 = new ArrayList<ShopProduct>();
        List<ShopProduct> page1;
        if(pValidity==0) {
             page1 = PageLimit.page(shopProducts0, page, limit);
           if(page1==null){
               page1=shopProducts10;
           }

            System.out.println(page1);
            // PageInfo<ShopProduct> pageInfo=new PageInfo<>(shopProducts);

        }else if(pValidity==1){
            page1 = PageLimit.page(shopProducts1, page, limit);
            if(page1==null){
                page1=shopProducts10;
            }
        }else if(pValidity==3){
            page1 = PageLimit.page(shopProducts3, page, limit);
            if(page1==null){
                page1=shopProducts10;
            }
        }else{
            page1 = PageLimit.page(shopProducts, page, limit);
            if(page1==null){
                page1=shopProducts10;
            }
        }

//

        //int current=page;
       // int  pageSize=limit;
//
        //int totalCount=shopProducts.size();

       // int pageCount = (totalCount / pageSize) + ((totalCount % current > 0) ? 1 : 0);
       // int start=(current-1) * pageSize;
        //int end = current==pageCount ? totalCount : current * pageSize;
       // List<ShopProduct> tempList = new ArrayList<>(shopProducts.subList(2, shopProducts.size()));


       // List<ShopProduct> updateList=shopProducts.subList(1,2);
        subarea.setShopProductList(page1);
        return WxResult.ok(subarea);
    }



    @Override
    public WxResult getSubarea(HttpServletRequest request) {

        SubareaExample psbExample = new SubareaExample();
        SubareaExample.Criteria criteria = psbExample.createCriteria();
        criteria.andSbIsshowEqualTo(1);
        List<Subarea> psbs = subareaMapper.selectByExample(psbExample);


        return WxResult.ok(psbs);
    }

    @Override
    public void guanlianVIP(Integer leId, String sbId) {
        SvlExample svlExample = new SvlExample();
        SvlExample.Criteria criteria1 = svlExample.createCriteria();
        criteria1.andSbIdEqualTo(Long.parseLong(sbId));
        List<Svl> svls = svlMapper.selectByExample(svlExample);
        if(svls.isEmpty()){
            Svl svl = new Svl();
            svl.setLeId(leId);
            svl.setSbId(Long.parseLong(sbId));
            svlMapper.insert(svl);
        }else{
            Svl svl = new Svl();
            svl.setLeId(leId);
            svl.setSbId(Long.parseLong(sbId));
            svlMapper.updateByExampleSelective(svl,svlExample);
        }


    }

    @Override
    public ResultUtil setLevel(Integer page, Integer limit,String sbId) {

        PageHelper.startPage(page, limit);
        LevelExample example=new LevelExample();
        example.setOrderByClause("le_id desc");
        LevelExample.Criteria criteria=example.createCriteria();
        List<Level>  list=levelMapper.selectByExample(example);

        for(Level level :list){
            SubareaExample subareaExample = new SubareaExample();
            Subarea subarea = subareaMapper.selectByPrimaryKey(Long.parseLong(sbId));

            SvlExample svlExample2 = new SvlExample();
            SvlExample.Criteria criteria2 = svlExample2.createCriteria();
            criteria2.andSbIdEqualTo(Long.parseLong(sbId));
            List<Svl> svls2 = svlMapper.selectByExample(svlExample2);
if(svls2.isEmpty()){
    level.setStatus2(0);
}else{
    level.setStatus2(1);
}

            SvlExample svlExample = new SvlExample();
            SvlExample.Criteria criteria1 = svlExample.createCriteria();
            criteria1.andLeIdEqualTo(level.getLeId());
           // criteria1.andSbIdEqualTo(Long.parseLong(sbId));
            List<Svl> svls = svlMapper.selectByExample(svlExample);
            if(svls.isEmpty()){
                level.setStatus(0);

            }else{
                level.setStatus(1);

            }
        }

        PageInfo<Level> pageInfo=new PageInfo<>(list);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;


    }

    @Override
    public void quxiaoVIP(Integer leId, String sbId) {
        SvlExample svlExample = new SvlExample();
        SvlExample.Criteria criteria1 = svlExample.createCriteria();
        criteria1.andLeIdEqualTo(leId);
        criteria1.andSbIdEqualTo(Long.parseLong(sbId));
        svlMapper.deleteByExample(svlExample);
    }

    @Override
    public List<Subarea> getAll() {

        SubareaExample subareaExample = new SubareaExample();
        /*SubareaExample.Criteria criteria = subareaExample.createCriteria();*/
        List<Subarea> subareas = subareaMapper.selectByExample(subareaExample);
        return subareas;
    }

    @Override
    public void inszhidingProduct(ShopProduct shopProduct,HttpServletRequest request) {
        /*String str= shopProduct.getpIsgroup();
        String[] ary = str.split(",");
        for(String item: ary){
            String suffix= CommonUtils.getSuffix(String.valueOf(item));
            String path= GlobalUtil.getValue("upfile.path");

            List<String> arrayList=new ArrayList<>();
            File pptFile=new File(path+"/"+item);
            File imgFile=new File(path+"/img");
            if(!imgFile.exists()){
                imgFile.mkdirs();
            }
            String saveUrl=request.getScheme() + "://"+request.getServerName()+":" +
                    request.getServerPort()+"/ssm/file/showPic?img=imgPath&fileName=";
            List<String> list=new ArrayList<>();
            if (suffix.equals("ppt")){
                arrayList=PPTtoImage.doPPT2003toImage(pptFile,imgFile,list,CommonUtils.getFileName(item));
            }else if(suffix.equals("pptx")){
                arrayList=PPTtoImage.doPPT2007toImage(pptFile,imgFile,list,CommonUtils.getFileName(item));
            }else if(suffix.equals("pdf")){
                arrayList= PDFUTil.pdfs(pptFile,imgFile,arrayList,CommonUtils.getFileName(item));;
            }
            //  pAddtime
            SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
            shopProduct.setpAddtime(sf.format(new Date()));
            int a=shopProductMapper.insertSelective(shopProduct);

            ShopProductExample shopProductExample = new ShopProductExample();
            ShopProductExample.Criteria criteria = shopProductExample.createCriteria();
            criteria.andPIsgroupEqualTo(str);
            //criteria.andSbIdEqualTo(shopProduct.getSbId());
            criteria.andPImageEqualTo(shopProduct.getpImage());

            List<ShopProduct> shopProducts = shopProductMapper.selectByExample(shopProductExample);
            List<ShopPicture> pictureList=new ArrayList<>();
            for (String s : arrayList) {
                ShopPicture picture=new ShopPicture();
                picture.setImages(saveUrl+s);
                if(shopProducts.get(0)!=null){
                    picture.setpId(shopProducts.get(0).getpId());
                }else{
                    picture.setpId(shopProducts.get(0).getpId());
                }

                pictureList.add(picture);
            }
            if (pictureList.size()>0){
                pictureMapper.insertForeach(pictureList);
            }
        }
*/

        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
        shopProduct.setpAddtime(sf.format(new Date()));
        int a=shopProductMapper.insertSelective(shopProduct);
        String str= shopProduct.getpIsgroup();
        String[] ary = str.split(",");
        for(String item: ary) {
            String suffix = CommonUtils.getSuffix(String.valueOf(item));
            String saveUrl3=request.getScheme() + "://"+request.getServerName()+":" +
                    request.getServerPort()+"/ssm/file/showPic?fileName=";
            String saveUrl = request.getScheme() + "://" + request.getServerName() + ":" +
                    request.getServerPort() + "/ssm/file/showPic?img=imgPath&fileName=";
            String saveUrl2 = request.getScheme() + "://" + request.getServerName() + ":" +
                    request.getServerPort() + "/ssm/front/onLineReadFile?fileName=";
            //List<String> list=new ArrayList<>();
            if (suffix.equals("ppt") || suffix.equals("pptx") || suffix.equals("pdf")) {
                ShopProductExample shopProductExample = new ShopProductExample();
                ShopProductExample.Criteria criteria = shopProductExample.createCriteria();
                criteria.andPIsgroupEqualTo(str);
                criteria.andPImageEqualTo(shopProduct.getpImage());
                List<ShopProduct> shopProducts = shopProductMapper.selectByExample(shopProductExample);

                if (suffix.equals("ppt") || suffix.equals("pptx")) {
                    String fileName = CommonUtils.getFileName(item);
                    String path = GlobalUtil.getValue("upfile.path");
                    String infilr = path + "/" + item;
                    String targetfile = path + "/" + fileName + "pdf";
                    String name2 = fileName + "pdf";
                    File pptFile = new File(infilr);
                    File imgFile = new File(targetfile);
                    DocConverterController.office2pdf(infilr, targetfile);

                    List<String> arrayList = new ArrayList<>();
                    File pdfFile = new File(path + "/" + name2);
                    File imgFile2 = new File(path + "/img");
                    if (!imgFile2.exists()) {
                        imgFile2.mkdirs();
                    }
                    arrayList = PDFUTil.pdfs(pdfFile, imgFile2, arrayList, CommonUtils.getFileName(item));
                    List<ShopPicture> pictureList = new ArrayList<>();
                    for (String s : arrayList) {
                        ShopPicture picture = new ShopPicture();
                        picture.setImages(saveUrl + s);
                        if (shopProducts.get(0) != null) {
                            picture.setpId(shopProducts.get(0).getpId());
                        } else {
                            picture.setpId(shopProducts.get(0).getpId());
                        }

                        pictureList.add(picture);
                    }
                    if (pictureList.size() > 0) {
                        pictureMapper.insertForeach(pictureList);
                    }
                } else {
                    String path = GlobalUtil.getValue("upfile.path");
                    List<String> arrayList = new ArrayList<>();
                    File pdfFile = new File(path + "/" + item);
                    File imgFile2 = new File(path + "/img");
                    if (!imgFile2.exists()) {
                        imgFile2.mkdirs();
                    }
                    arrayList = PDFUTil.pdfs(pdfFile, imgFile2, arrayList, CommonUtils.getFileName(item));
                    List<ShopPicture> pictureList = new ArrayList<>();
                    for (String s : arrayList) {
                        ShopPicture picture = new ShopPicture();
                        picture.setImages(saveUrl + s);
                        if (shopProducts.get(0) != null) {
                            picture.setpId(shopProducts.get(0).getpId());
                        } else {
                            picture.setpId(shopProducts.get(0).getpId());
                        }

                        pictureList.add(picture);
                    }
                    if (pictureList.size() > 0) {
                        pictureMapper.insertForeach(pictureList);
                    }
                }


            }else if(suffix.equals("jpg")||suffix.equals("png")||suffix.equals("gif")||suffix.equals("jpeg")) {
                ShopProductExample shopProductExample = new ShopProductExample();
                ShopProductExample.Criteria criteria = shopProductExample.createCriteria();
                criteria.andPIsgroupEqualTo(str);
                criteria.andPImageEqualTo(shopProduct.getpImage());
                List<ShopProduct> shopProducts = shopProductMapper.selectByExample(shopProductExample);

                ShopPicture picture = new ShopPicture();
                picture.setImages(saveUrl3 + item);
                if (shopProducts.get(0) != null) {
                    picture.setpId(shopProducts.get(0).getpId());
                } else {
                    picture.setpId(shopProducts.get(0).getpId());
                }
                pictureMapper.insert(picture);
            }


        }
        //shopProductMapper.insert(shopProduct);
        ShopProductExample shopProductExample2 = new ShopProductExample();
        ShopProductExample.Criteria criteria2 = shopProductExample2.createCriteria();
        criteria2.andPIsgroupEqualTo(shopProduct.getpIsgroup());
        criteria2.andSbIdEqualTo(shopProduct.getSbId());
        List<ShopProduct> shopProducts2 = shopProductMapper.selectByExample(shopProductExample2);
        if (!shopProducts2.isEmpty()) {

            Psb psb = new Psb();
            psb.setpId(shopProducts2.get(0).getpId());
            psb.setSbid(shopProducts2.get(0).getSbId());
            psb.setPsbOldprices(shopProducts2.get(0).getpOldprice());
            psb.setPsbPrices(shopProducts2.get(0).getpPrice());
            psbMapper.insert(psb);

        }
    }

    @Override
    public WxResult getShopType(HttpServletRequest request,int pValidity) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        String saveUrl=request.getScheme() + "://"+request.getServerName()+":" +
                request.getServerPort()+"/ssm/file/showPic?img=imgPath&fileName=";
        ShopProductExample shopProductExample = new ShopProductExample();
      if(pValidity==4){
          List<ShopProduct> shopProducts = shopProductMapper.selectByExample(shopProductExample);
          for(ShopProduct shopProduct:shopProducts){
              shopProduct.setpImage(saveUrl+shopProduct.getpImage());
          }
            return WxResult.ok(shopProducts);
      }else{
          ShopProductExample.Criteria criteria = shopProductExample.createCriteria();
          criteria.andPValidityEqualTo(pValidity);
          List<ShopProduct> shopProducts = shopProductMapper.selectByExample(shopProductExample);
          for(ShopProduct shopProduct:shopProducts){
              shopProduct.setpImage(saveUrl+shopProduct.getpImage());
          }
          return WxResult.ok(shopProducts);
      }




    }
}
