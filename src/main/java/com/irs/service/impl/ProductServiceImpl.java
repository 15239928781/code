package com.irs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.irs.controller.DocConverterController;
import com.irs.mapper.*;
import com.irs.pojo.*;
import com.irs.service.ProductService;
import com.irs.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private PsbMapper psbMapper;
    @Autowired
    private SubareaMapper subareaMapper;
    @Autowired
    private ShopOrderitemMapper shopOrderitemMapper;
    @Autowired
    private ShopProductMapper productMapper;

    @Autowired
    private ShopBrowseMapper shopBrowseMapper;

    @Autowired
    private ShopRollpicMapper shopRollpicMapper;

    @Autowired
    private ShopCategoryMapper categoryMapper;

    @Autowired
    private ShopCartMapper cartMapper;

    @Autowired
    private SpikeProductMapper spikeProductMapper;

    @Autowired
    private ShopProductCollectionMapper productCollectionMapper;

    @Autowired
    private ProductItemMapper productItemMapper;

    @Autowired
    private GroupsProductMapper groupsProductMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private ShopPictureMapper pictureMapper;

    //获取素材
    @Override
    public WxResult getproduct(HttpServletRequest request, Integer page, Integer limit) {
        String saveUrl = request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort() + "/ssm/file/showPic?fileName=";
        ShopProductExample example = new ShopProductExample();
        example.setOrderByClause("p_id desc");
        ShopProductExample.Criteria criteria = example.createCriteria();
//        criteria.andPIspcEqualTo(1);
        List<ShopProduct> shopProducts = productMapper.selectByExample(example);
        List<ShopProduct> newshop = new ArrayList<>();
        for (ShopProduct s : shopProducts) {
            s.setpImage(saveUrl + s.getpImage());
            int a = s.getShopCategory().getcId();
            if (a == 0 || a == -1) {
                s.setCategoryname("");
            } else {
                ShopCategory shopCategory = categoryMapper.selectByPrimaryKey(a);
                s.setCategoryname(shopCategory.getcName());
            }
//            if (newshop.size()>=10) {
//                break;
//            }
            newshop.add(s);
        }
        return WxResult.ok(newshop);
    }

    @Override
    public WxResult getcIdBypId(Integer pId, HttpServletRequest request) {
        String saveUrl = request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort() + "/ssm/file/showPic?fileName=";
        try {
            ShopCategoryExample example = new ShopCategoryExample();
            ShopCategoryExample.Criteria criteria = example.createCriteria();
            criteria.andParentidEqualTo(pId);
            List<ShopCategory> categoryList = categoryMapper.selectByExample(example);
            List<Integer> cIds = new ArrayList<>();
            for (ShopCategory category : categoryList) {
                cIds.add(category.getcId());
            }
            ShopProductExample example1 = new ShopProductExample();
            example.setOrderByClause("p_id desc");
            ShopProductExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andCIdIn(cIds);
            List<ShopProduct> productList = productMapper.selectByExample(example1);
            for (ShopProduct product : productList) {
                product.setpImage(saveUrl + product.getpImage());
            }
            Map map = new HashMap();
            map.put("categoryList", categoryList);
            map.put("productList", productList);
            return WxResult.ok(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return WxResult.fail("操作失败");
    }

    @Override
    public List<ShopProduct> getProdtct() {
        ShopProductExample example = new ShopProductExample();
        example.setOrderByClause("p_id desc");
        return productMapper.selectByExample(example);
    }

    //获取秒杀素材
    @Override
    public WxResult getspikeproduct(HttpServletRequest request, int start, int length) {
        String saveUrl = request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort() + "/ssm/file/showPic?fileName=";
        PageHelper.startPage(start, length);
        SpikeProductExample example = new SpikeProductExample();
        SpikeProductExample.Criteria criteria = example.createCriteria();
        criteria.andSpStatusEqualTo(2);
        List<SpikeProduct> spikeProducts = spikeProductMapper.selectByExample(example);
        for (SpikeProduct spikeProduct : spikeProducts) {
            spikeProduct.setpImage(saveUrl + spikeProduct.getpImage());
        }

        if (spikeProducts == null || spikeProducts.size() <= 0) {

            return WxResult.build(400, "秒杀活动已结束，无秒杀素材", spikeProducts);
        } else {
            return WxResult.ok(spikeProducts);
        }
    }

    //通过素材id获取其下列表
    @Override
    public WxResult getmenubycid(String cid, String start, String length, HttpServletRequest request) {
        List<ShopCategory> list = categoryMapper.selepid();
        for (ShopCategory s : list) {
            System.out.println(s.getParentid());
            if (s.getParentid() == Integer.parseInt(cid)) {
                return WxResult.ok();
            }
        }
        PageHelper.startPage(Integer.parseInt(start), Integer.parseInt(length));
        ShopProductExample example = new ShopProductExample();
        example.setOrderByClause("p_id desc");
        example.setOrderByClause("p_isfee asc");
        // dddd
        ShopProductExample.Criteria criteria = example.createCriteria();
        criteria.andCIdEqualTo(Integer.parseInt(cid));
        List<ShopProduct> products = productMapper.selectByExample(example);
        String saveUrl = request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort() + "/ssm/file/showPic?fileName=";
        for (ShopProduct product : products) {
            product.setpImage(saveUrl + product.getpImage());
        }
        return WxResult.ok(products);
    }


    @Override
    public WxResult getHotProduct(HttpServletRequest request, Integer page, Integer limit, int pValidity) {
        //typeid=2时，为热销的标题图片
        ShopRollpic r = shopRollpicMapper.selectByType(2);
        ShopProductExample example = new ShopProductExample();
        example.setOrderByClause("p_id desc");
        ShopProductExample.Criteria criteria = example.createCriteria();
        if (pValidity == 4) {
            criteria.andPIsonEqualTo(1);
            criteria.andPIshotEqualTo(1);
        } else {
            criteria.andPIsonEqualTo(1);
            criteria.andPIshotEqualTo(1);
            criteria.andPValidityEqualTo(pValidity);
        }


        PageHelper.startPage(page, limit);
        List<ShopProduct> list = productMapper.selectByExample(example);
        String saveUrl = request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort() + "/ssm/file/showPic?fileName=";
        /*for (ShopProduct product : list) {
            product.setpImage(saveUrl+product.getpImage());
        }
*/
        Iterator<ShopProduct> it = list.iterator();
        while (it.hasNext()) {
            ShopProduct shopProduct = it.next();
            shopProduct.setpImage(saveUrl + shopProduct.getpImage());
            if (shopProduct.getSbId() != null) {
                it.remove();
            }
        }
        PageInfo<ShopProduct> pageInfo = new PageInfo<>(list);

        r.setPlist(pageInfo.getList());
        return WxResult.build(200, "ok", r);
    }

    @Override
    public WxResult getRecommendProduct(HttpServletRequest request, Integer page, Integer limit, int pValidity) {
//        long num;
//
//        if(uid<=0){
//            num=0;
//        }else{
//           ShopBrowseExample example=new ShopBrowseExample();
//           ShopBrowseExample.Criteria criteria = example.createCriteria();
//            criteria.andUIdEqualTo(uid);
//            num=shopBrowseMapper.countByExample(example);
//        }
//       // PageHelper.startPage(page, limit);
//        List<ShopProduct> prlist;
//        if(num>0){
//            prlist=productMapper.getProductByUid(uid);
//        }else{
//            prlist=productMapper.getProductByNum();
//        }
//        String saveUrl=request.getScheme() + "://"+request.getServerName()+":" +
//                request.getServerPort()+"/ssm/file/showPic?fileName=";
//        for (ShopProduct product : prlist) {
//            product.setpImage(saveUrl+product.getpImage());
//        }
//        //PageInfo<ShopProduct> pageInfo=new PageInfo<>(prlist);
//
//        Iterator<ShopProduct> it =prlist.iterator();
//        while (it.hasNext())
//        {
//
//            ShopProduct shopProduct = it.next();
//            if(pValidity==4){
//                if(shopProduct.getSbId()!=null){
//                    it.remove();
//                }
//
//            }else{
//                if(shopProduct.getSbId()!=null||shopProduct.getpValidity()!=pValidity){
//                    it.remove();
//                }
//            }
//
//        }
//        ShopRollpic r= shopRollpicMapper.selectByType(3);//typeid=3时，为推荐的标题图片
//        if(r!=null){
//            r.setPlist(prlist);
//        }
        ShopRollpic r = shopRollpicMapper.selectByType(3);
        ShopProductExample shopProductExample = new ShopProductExample();
        ShopProductExample.Criteria criteria = shopProductExample.createCriteria();

        criteria.andPTuijianEqualTo(1);
        if (pValidity != 4) {
            criteria.andPValidityEqualTo(pValidity);
        }
        PageHelper.startPage(page, limit);
        List<ShopProduct> list = productMapper.selectByExample(shopProductExample);
        String saveUrl = request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort() + "/ssm/file/showPic?fileName=";
        Iterator<ShopProduct> it = list.iterator();
        while (it.hasNext()) {
            ShopProduct shopProduct = it.next();
            shopProduct.setpImage(saveUrl + shopProduct.getpImage());
            if (shopProduct.getSbId() != null) {
                it.remove();
            }
        }
        PageInfo<ShopProduct> pageInfo = new PageInfo<>(list);

        r.setPlist(pageInfo.getList());
        return WxResult.build(200, "ok", r);
    }

    @Override
    public WxResult getTopProduct(HttpServletRequest request) {
        PageHelper.startPage(1, 10);
        ShopRollpic r = shopRollpicMapper.selectByType(4);
        ShopProductExample example = new ShopProductExample();
        example.setOrderByClause("p_addtime desc");
        List<ShopProduct> list = productMapper.selectByExample(example);
        String saveUrl = request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort() + "/ssm/file/showPic?fileName=";
        for (ShopProduct product : list) {
            product.setpImage(saveUrl + product.getpImage());
        }
        r.setPlist(list);
        return WxResult.ok(r);
    }

    @Override
    public WxResult getProductBySearch(String key, HttpServletRequest request) {
        if ("".equals(key) || null == key) {
            return WxResult.build(400, "你的小可爱走丢了！");
        }
        System.out.println(key);
        //      String newkey=key.replace(" ", "");
        ShopProductExample example = new ShopProductExample();
        example.or().andPNameLike("%" + key + "%");
//        example.or().andPDescLike("%"+newkey+"%");
        List<ShopProduct> list = productMapper.selectByExample(example);
        String saveUrl = request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort() + "/ssm/file/showPic?fileName=";
        for (ShopProduct product : list) {
            product.setpImage(saveUrl + product.getpImage());
        }
        return WxResult.ok(list);
    }

    @Override
    public ShopProduct selProductBypid(int parseInt) {
        ShopProduct product = productMapper.selectByPrimaryKey(parseInt);
        if (product.getcId() != 0) {

            ShopCategory category = categoryMapper.selectByPrimaryKey(product.getcId());
            product.setfId(category.getParentid());
            return product;
        } else {
            return product;
        }
    }

    @Override
    public void insProduct(ShopProduct product, HttpServletRequest request) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        product.setpAddtime(sf.format(new Date()));
        int a = productMapper.insertSelective(product);

        String str = product.getpIsgroup();
        String[] ary = str.split(",");
        for (String item : ary) {
            String suffix = CommonUtils.getSuffix(String.valueOf(item));
            String saveUrl = request.getScheme() + "://" + request.getServerName() + ":" +
                    request.getServerPort() + "/ssm/file/showPic?img=imgPath&fileName=";
            String saveUrl2 = request.getScheme() + "://" + request.getServerName() + ":" +
                    request.getServerPort() + "/ssm/front/onLineReadFile?fileName=";
            String saveUrl3 = request.getScheme() + "://" + request.getServerName() + ":" +
                    request.getServerPort() + "/ssm/file/showPic?fileName=";
            if (suffix.equals("ppt") || suffix.equals("pptx") || suffix.equals("pdf")) {
                ShopProductExample shopProductExample = new ShopProductExample();
                ShopProductExample.Criteria criteria = shopProductExample.createCriteria();
                criteria.andPIsgroupEqualTo(str);
                criteria.andPImageEqualTo(product.getpImage());
                List<ShopProduct> shopProducts = productMapper.selectByExample(shopProductExample);
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
            } else if (suffix.equals("jpg") || suffix.equals("png") || suffix.equals("gif") || suffix.equals("jpeg")) {
                ShopProductExample shopProductExample = new ShopProductExample();
                ShopProductExample.Criteria criteria = shopProductExample.createCriteria();
                criteria.andPIsgroupEqualTo(str);
                criteria.andPImageEqualTo(product.getpImage());
                List<ShopProduct> shopProducts = productMapper.selectByExample(shopProductExample);

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
    }

    @Override
    public ResultUtil getProductList(Integer page, Integer limit, ShopProduct search) {
        PageHelper.startPage(page, limit);
        ShopProductExample example = new ShopProductExample();
        example.setOrderByClause("p_id desc");
        ShopProductExample.Criteria criteria = example.createCriteria();
        if (search.getpName() != null && !"".equals(search.getpName())) {
            criteria.andPNameLike("%" + search.getpName() + "%");
        }
        if (search.getcId() != null && search.getcId() != -1) {
            criteria.andCIdEqualTo(search.getcId());
        }
        if (search.getpIson() != null && search.getpIson() != -1) {
            criteria.andPIsonEqualTo(search.getpIson());
        }
        if (search.getCreateTimeStart() != null && !"".equals(search.getCreateTimeStart())) {
            criteria.andPAddtimeLessThanOrEqualTo(search.getCreateTimeStart());
        }
        if (search.getCreateTimeEnd() != null && !"".equals(search.getCreateTimeEnd())) {
            criteria.andPAddtimeLessThanOrEqualTo(search.getCreateTimeStart());
        }
        List<ShopProduct> list = productMapper.selectByExample(example);
        for (ShopProduct product : list) {
            ShopCategory category = categoryMapper.selectByPrimaryKey(product.getcId());
            if (category != null) {
                ShopCategory shopCategory = categoryMapper.selectByPrimaryKey(category.getParentid());
                product.setcName(shopCategory.getcName());
            }
            List<Psb> psbs = psbMapper.selectByPrimaryKey(product.getpId());
            for (Psb psb : psbs) {
                Subarea subarea = subareaMapper.selectByPrimaryKey(psb.getSbid());
                if (subarea != null) {
                    product.setSbName(subarea.getSbName());
                }
            }
            if (category != null && (category.getParentid() != 0)) {
                product.setcName1(category.getcName());
            }
        }

        PageInfo<ShopProduct> pageInfo = new PageInfo<>(list);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public void delProducts(String userStr) {
        String[] users = userStr.split(",");
        if (users != null && users.length > 0) {
            for (String uid : users) {
                ShopOrderitemExample shopOrderitem = new ShopOrderitemExample();
                ShopOrderitemExample.Criteria criteria = shopOrderitem.createCriteria();
                criteria.andPIdEqualTo(Integer.parseInt(uid));
                shopOrderitemMapper.deleteByExample(shopOrderitem);
                productMapper.deleteByPrimaryKey(Integer.parseInt(uid));
                PsbExample psbExample = new PsbExample();
                PsbExample.Criteria criteria2 = psbExample.createCriteria();
                criteria2.andPIdEqualTo(Integer.parseInt(uid));
                psbMapper.deleteByExample(psbExample);
            }
        }
    }

    @Override
    public void delProductByPid(String pId) {
        ShopOrderitemExample shopOrderitem = new ShopOrderitemExample();
        ShopOrderitemExample.Criteria criteria = shopOrderitem.createCriteria();
        criteria.andPIdEqualTo(Integer.parseInt(pId));
        shopOrderitemMapper.deleteByExample(shopOrderitem);
        productMapper.deleteByPrimaryKey(Integer.parseInt(pId));
        PsbExample psbExample = new PsbExample();
        PsbExample.Criteria criteria2 = psbExample.createCriteria();
        criteria2.andPIdEqualTo(Integer.parseInt(pId));
        psbMapper.deleteByExample(psbExample);

        ShopBrowseExample shopBrowseExample = new ShopBrowseExample();
        ShopBrowseExample.Criteria criteria1 = shopBrowseExample.createCriteria();
        criteria1.andPIdEqualTo(Integer.parseInt(pId));
        int i = shopBrowseMapper.deleteByExample(shopBrowseExample);
        System.out.println(i);
    }

    @Override
    public void updProduct(ShopProduct product) {
        productMapper.updateByPrimaryKeySelective(product);
    }

    @Override
    public WxResult getProductByPid(int pId, int uId, int sbId, HttpServletRequest request) {
        String saveUrl = request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort() + "/ssm";
        ShopProduct p;

        if (sbId == 0) {
            if (pId != 0) {
                p = productMapper.selectByPrimaryKey(pId);//得到商品详情
                if (p.getpDesc() != null && !"".equals(p.getpDesc())) {
               /* String newStr= HtmlUtils.replaceHtmlTag(p.getpDesc(),"img", "src", "src=\""+saveUrl+"", "\"");
                p.setpDesc(newStr);*/
                    p.setpImage(saveUrl + "/file/showPic?fileName=" + p.getpImage());
                }
                if (uId == 0) {//如果用户没有登陆 把收藏状态设为未收藏
                    p.setColloction(0 + "");
                } else {
                    ShopProductCollectionExample example1 = new ShopProductCollectionExample();
                    ShopProductCollectionExample.Criteria criteria1 = example1.createCriteria();
                    criteria1.andPIdEqualTo(pId);
                    criteria1.andUIdEqualTo(uId);
                    List<ShopProductCollection> clist = productCollectionMapper.selectByExample(example1);//获取收藏与否
                    if (clist.size() > 0 && clist != null) {
                        p.setColloction(1 + "");//如果收藏 返回1 收藏
                    } else {
                        p.setColloction(0 + "");//否则 返回0 未收藏
                    }
                }
           /* PictureExample example=new PictureExample();
            org.distribution.pojo.PictureExample.Criteria criteria = example.createCriteria();
            criteria.andPIdEqualTo(pId);
            List<Picture> images=pictureMapper.selectByExample(example);//获取商品图片！
            if(images.size()>0&&images!=null){//如果有图片
                p.setRollImages(images);
            }else{//如果没有 设置一张商品图片*/
                ShopPicture p1 = new ShopPicture();
                p1.setSpId(0);
                p1.setpId(pId);
                //p1.setImages(saveUrl+"/file/showPic?fileName="+p.getpImage());
                p1.setImages(p.getpImage());
                List<ShopPicture> plist = new ArrayList();
                plist.add(p1);
                p.setRollImages(plist);
                ProductItemExample example = new ProductItemExample();
                ProductItemExample.Criteria criteria = example.createCriteria();
                criteria.andPIdEqualTo(pId);
                List<ProductItem> itemList = productItemMapper.selectByExample(example);
                p.setProductItems(itemList);

                //根据tId查看老师
                if (p.gettId() != null && !p.gettId().equals("null")) {
                    Teacher teacher = teacherMapper.selectByPrimaryKey(p.gettId());
                    teacher.settPic(saveUrl + "/file/showPic?fileName=" + teacher.gettPic());
                    if (teacher != null) {
                        p.setTeacher(teacher);
                    }
                }
                return WxResult.ok(p);
            } else {
                p = null;
                return WxResult.build(400, "请求失败 可能是 数据去搭鹊桥了呢");
            }
        } else {
            if (pId != 0) {
                p = productMapper.selectByPrimaryKey(pId);//得到商品详情
                PsbExample psbExample = new PsbExample();
                PsbExample.Criteria criteria = psbExample.createCriteria();
                criteria.andSbidEqualTo(Long.valueOf(sbId));
                criteria.andPIdEqualTo(p.getpId());
                List<Psb> psbs = psbMapper.selectByExample(psbExample);
                for (Psb psb : psbs) {
                    if (psb.getpId() != null) {
                        if (psb.getPsbOldprices() == null) {
                            p.setpOldprice(p.getpOldprice());
                        } else {
                            p.setpOldprice(psb.getPsbOldprices());
                        }
                        if (psb.getPsbOldprices() == null) {
                            p.setpPrice(p.getpPrice());
                        } else {
                            p.setpPrice(psb.getPsbPrices());
                        }
                    }
                }
                // p.setpImage(saveUrl + "/file/showPic?fileName=" + p.getpImage());
                if (p.getpDesc() != null && !"".equals(p.getpDesc())) {
               /* String newStr= HtmlUtils.replaceHtmlTag(p.getpDesc(),"img", "src", "src=\""+saveUrl+"", "\"");
                p.setpDesc(newStr);*/
                    p.setpImage(saveUrl + "/file/showPic?fileName=" + p.getpImage());
                }
                if (uId == 0) {//如果用户没有登陆 把收藏状态设为未收藏
                    p.setColloction(0 + "");
                } else {
                    ShopProductCollectionExample example1 = new ShopProductCollectionExample();
                    ShopProductCollectionExample.Criteria criteria1 = example1.createCriteria();
                    criteria1.andPIdEqualTo(pId);
                    criteria1.andUIdEqualTo(uId);
                    List<ShopProductCollection> clist = productCollectionMapper.selectByExample(example1);//获取收藏与否
                    if (clist.size() > 0 && clist != null) {
                        p.setColloction(1 + "");//如果收藏 返回1 收藏
                    } else {
                        p.setColloction(0 + "");//否则 返回0 未收藏
                    }
                }
           /* PictureExample example=new PictureExample();
            org.distribution.pojo.PictureExample.Criteria criteria = example.createCriteria();
            criteria.andPIdEqualTo(pId);
            List<Picture> images=pictureMapper.selectByExample(example);//获取商品图片！
            if(images.size()>0&&images!=null){//如果有图片
                p.setRollImages(images);
            }else{//如果没有 设置一张商品图片*/
                ShopPicture p1 = new ShopPicture();
                p1.setSpId(0);
                p1.setpId(pId);
                //p1.setImages(saveUrl+"/file/showPic?fileName="+p.getpImage());
                p1.setImages(p.getpImage());
                List<ShopPicture> plist = new ArrayList();
                plist.add(p1);
                p.setRollImages(plist);
                ProductItemExample example2 = new ProductItemExample();
                ProductItemExample.Criteria criteria2 = example2.createCriteria();
                criteria.andPIdEqualTo(pId);
                List<ProductItem> itemList = productItemMapper.selectByExample(example2);
                p.setProductItems(itemList);

                //根据tId查看老师
                if (p.gettId() != null && !p.gettId().equals("null")) {
                    Teacher teacher = teacherMapper.selectByPrimaryKey(p.gettId());
                    teacher.settPic(saveUrl + "/file/showPic?fileName=" + teacher.gettPic());
                    if (teacher != null) {
                        p.setTeacher(teacher);
                    }
                }
//                /* 处理课程章节名称 */
//                String strName = p.getpIsgroup();
//                String[] strNameList = strName.split(",");
//                String newStrName = "";
//                for (String s : strNameList) {
////                    newStrName = s.substring(s.indexOf("?")+1);
//                    newStrName =newStrName.concat(s.substring(0, s.indexOf("&")));
//
//                    newStrName = newStrName.concat(",");
//                }
//                p.setOriName( newStrName);
                return WxResult.ok(p);
            } else {
                p = null;
                return WxResult.build(400, "请求失败 可能是 数据去搭鹊桥了呢");
            }
        }
    }

    @Override
    public WxResult getProductByCategory(Integer start, Integer length, int cId, int orders, HttpServletRequest request) {
        if (cId == 0) {
            return WxResult.build(400, "请求失败 可能是 cId去搭鹊桥了呢");
        } else {
            PageHelper.startPage(start, length);
            ShopProductExample example = new ShopProductExample();
            example.setOrderByClause("p_id desc");
            if (orders == 0) {
                example.setOrderByClause("p_addtime desc");
            } else if (orders == 1) {
                example.setOrderByClause("p_num desc");
            } else if (orders == 2) {
                example.setOrderByClause("p_price desc");
            }

            ShopProductExample.Criteria criteria = example.createCriteria();
            criteria.andCIdEqualTo(cId);
            List<ShopProduct> list = productMapper.selectByExample(example);
            String saveUrl = request.getScheme() + "://" + request.getServerName() + ":" +
                    request.getServerPort() + "/ssm/file/showPic?fileName=";
            for (ShopProduct product : list) {
                product.setpImage(saveUrl + product.getpImage());
            }
            return WxResult.ok(list);
        }

    }

    @Override
    public WxResult getBrowseList(int uId, Integer start, Integer length, HttpServletRequest request) {
        PageHelper.startPage(start, length);
        if (uId == 0) {
            return WxResult.build(400, "请求失败 可能是 uId去搭鹊桥了呢");
        } else {
            String saveUrl = request.getScheme() + "://" + request.getServerName() + ":" +
                    request.getServerPort() + "/ssm/file/showPic?fileName=";
            List<ShopProduct> list = productMapper.getBrowse(uId);
            for (ShopProduct product : list) {
                product.setpImage(saveUrl + product.getpImage());
            }
            System.out.println(list.toString());
            return WxResult.ok(list);
        }
    }

    @Override
    public List<ShopProduct> getAll(int status) {
        List<Integer> pIds = new ArrayList<>();
        ShopProductExample example = new ShopProductExample();
        example.setOrderByClause("p_id desc");
        ShopProductExample.Criteria criteria = example.createCriteria();
        criteria.andPValidityEqualTo(1);

        //排重   秒杀不能在参加拼团， 拼团不能在参加秒杀
        if (status == 1) {
            //查拼团表
            GroupsProductExample example1 = new GroupsProductExample();
            List<GroupsProduct> groupsProductsList = groupsProductMapper.selectByExample(example1);
            for (GroupsProduct groupsProduct : groupsProductsList) {
                pIds.add(groupsProduct.getpId());
                criteria.andPIdNotIn(pIds);
            }
        } else if (status == 2) {
            //查询秒杀表
            SpikeProductExample example1 = new SpikeProductExample();
            List<SpikeProduct> spikeProductList = spikeProductMapper.selectByExample(example1);
            for (SpikeProduct spikeProduct : spikeProductList) {
                pIds.add(spikeProduct.getpId());
                criteria.andPIdNotIn(pIds);
            }
        }

        List<ShopProduct> shopProducts = productMapper.selectByExample(example);
        return shopProducts;
    }

    @Override
    public WxResult getAllProduct(Integer start, Integer length) {
        PageHelper.startPage(start, length);
        ShopProductExample example = new ShopProductExample();
        example.setOrderByClause("p_id desc");
        return WxResult.ok(productMapper.selectByExample(example));
    }

    @Override
    public List<ShopProduct> getProductByCate(Integer getcId, Integer uId, HttpServletRequest request) {
        String saveUrl = request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort() + "/ssm/file/showPic?fileName=";
        ShopProductExample example = new ShopProductExample();
        example.setOrderByClause("p_id desc");
        ShopProductExample.Criteria criteria = example.createCriteria();
        if (getcId != 0) {
            criteria.andCIdEqualTo(getcId);
        }
        List<ShopProduct> list = productMapper.selectByExample(example);
        if (list.size() > 0) {
            for (ShopProduct product : list) {
                if (uId != 0) {
                    ShopCartExample example1 = new ShopCartExample();
                    ShopCartExample.Criteria criteria1 = example1.createCriteria();
                    criteria1.andPIdEqualTo(product.getpId());
                    criteria1.andUIdEqualTo(uId);
                    long count = cartMapper.countByExample(example1);
                    product.setcNum(count);
                    product.setpImage(saveUrl + product.getpImage());
                }
            }
        }
        return list;
    }
}
