package com.irs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.irs.annotation.MyException;
import com.irs.mapper.ShopActivityMapper;
import com.irs.mapper.ShopCategoryMapper;
import com.irs.mapper.ShopProductMapper;
import com.irs.pojo.*;
import com.irs.service.CategoryService;
import com.irs.service.ProductService;
import com.irs.util.JsonUtils;
import com.irs.util.ResultUtil;
import com.irs.util.WxResult;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ShopCategoryMapper categoryMapper;

    @Autowired
    private ShopActivityMapper shopActivityMapper;

    @Autowired
    private ShopProductMapper shopProductMapper;
    @Autowired
    private  ShopCategoryMapper shopCategoryMapper;






    @Override
    public WxResult getAllCategory(HttpServletRequest request) {
        Map map=new HashMap();
        ShopCategoryExample example=new ShopCategoryExample();
        example.setOrderByClause("c_sorting desc");
        ShopActivityExample example2=new ShopActivityExample();
        ShopActivityExample.Criteria criteria = example2.createCriteria();
        criteria.andAStatusEqualTo(1);
        List<ShopActivity> alist = shopActivityMapper.selectByExample(example2);
        ShopCategoryExample.Criteria criteria1=example.createCriteria();
        criteria1.andCIsshowEqualTo(1);
        List<ShopCategory> clist = categoryMapper.selectByExample(example);
        String strDirPath = request.getScheme() + "://"+request.getServerName()+":" +
                request.getServerPort();
        for (ShopCategory category : clist) {
            category.setcImage(strDirPath+"/ssm/file/showPic?fileName="+category.getcImage());
        }
        if(alist.size()>0&&alist!=null){
            map.put("isActivity", 1);
            map.put("alist", alist);
            map.put("clist", clist);
        }else{
            map.put("isActivity", 0);
//			map.put("alist", alist);
            map.put("clist", clist);
        }
        return WxResult.ok(map);
    }

    @Override
    public ShopCategory selCategoryById(Integer id) {
        ShopCategory shopCategory = categoryMapper.selectByPrimaryKey(id);
        return shopCategory;
    }

    @Override
    public List<ShopCategory> selCategoryBypid() {
        ShopCategoryExample example = new ShopCategoryExample();
        ShopCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentidEqualTo(0);
        return categoryMapper.selectByExample(example);
    }
    @Override
    public ResultUtil selectByCId(Integer cId) {
        ShopCategoryExample example=new ShopCategoryExample();
        ShopCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentidEqualTo(cId);

        return ResultUtil.ok(categoryMapper.selectByExample(example));
    }

    @Override
    public List<ShopCategory> selectFId(Integer getfId) {
        ShopCategoryExample example=new ShopCategoryExample();
        ShopCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentidEqualTo(getfId);

        return categoryMapper.selectByExample(example);
    }

    @Override
    public void updateShow(Integer id, Integer status) {
        ShopCategory category=categoryMapper.selectByPrimaryKey(id);
        category.setcIsshow(status);
        categoryMapper.updateByPrimaryKeySelective(category);
    }

    @Override
    public void updCategorySortingById(ShopCategory shopCategory) {
        ShopCategory shopCategory1 = shopCategoryMapper.selectByPrimaryKey(shopCategory.getcId());
        shopCategory1.setcSorting(shopCategory.getcSorting());
        shopCategoryMapper.updateByPrimaryKey(shopCategory1);
    }
    @Override
    public void updCategorySortingById2(ShopCategory shopCategory) {
        ShopCategory shopCategory1 = shopCategoryMapper.selectByPrimaryKey(shopCategory.getcId());
        shopCategory1.setcSorting(shopCategory.getcSorting());
        shopCategoryMapper.updateByPrimaryKey(shopCategory1);
    }


    @Override
    public ResultUtil getCategoryList(Integer page, Integer limit,String type) {
        //如果type等于0 获取app当中所有的一级列表
        if ("0".equals(type)){
            PageHelper.startPage(page, limit);
            ShopCategoryExample example=new ShopCategoryExample();
            ShopCategoryExample.Criteria criteria = example.createCriteria();
            criteria.andParentidEqualTo(0);
            example.setOrderByClause("c_sorting desc");
            List<ShopCategory> list=categoryMapper.selectByExample(example);
            PageInfo<ShopCategory> pageInfo = new PageInfo<ShopCategory>(list);
            ResultUtil resultUtil = new ResultUtil();
            resultUtil.setCode(0);
            resultUtil.setCount(pageInfo.getTotal());
            resultUtil.setData(pageInfo.getList());
            return resultUtil;
        }else{
            //如果type不等于0 获取app当中所有的二级列表
            PageHelper.startPage(page, limit);
            ShopCategoryExample example=new ShopCategoryExample();
            ShopCategoryExample.Criteria criteria = example.createCriteria();
            criteria.andParentidNotEqualTo(0);
            example.setOrderByClause("c_sorting desc");
            List<ShopCategory> list=categoryMapper.selectByExample(example);
            for (ShopCategory shopCategory : list){
                //通过cid获取一级列表的名称
                ShopCategory sc = categoryMapper.selectByPrimaryKey(shopCategory.getParentid());
                shopCategory.setpName(sc.getcName());
            }
            PageInfo<ShopCategory> pageInfo = new PageInfo<ShopCategory>(list);
            ResultUtil resultUtil = new ResultUtil();
            resultUtil.setCode(0);
            resultUtil.setCount(pageInfo.getTotal());
            resultUtil.setData(pageInfo.getList());
            return resultUtil;
        }
    }

    @Override
    public void insCategory(ShopCategory category) {
        long a = categoryMapper.countByExample(null);
        try {
           /* if (a >= 4) {
                MyException myException=new MyException();
                myException.setData(ResultUtil.error("最多四个，不能再加了！"));
                throw myException;
            } else {*/
          /* if (category.getParentid()==null){
               category.setParentid(0);
           }*/
                categoryMapper.insertSelective(category);
//            }
        }catch (MyException e){
            throw e;
        }

    }

    @Override
    public int delCategoryById(Integer id) {
        ShopCategoryExample example=new ShopCategoryExample();
        ShopCategoryExample.Criteria criteria=example.createCriteria();
        criteria.andParentidEqualTo(id);
        List<ShopCategory> list=categoryMapper.selectByExample(example);
        if (list.size()>0){
            return 0;
        }
        categoryMapper.deleteByPrimaryKey(id);
        return 1;
    }

    @Override
    public int delCategory(String carouselStr) {
        if(!StringUtils.isBlank(carouselStr)){
            String[] ids=carouselStr.split(",");
            for (String id : ids) {
                ShopCategoryExample example=new ShopCategoryExample();
                ShopCategoryExample.Criteria criteria=example.createCriteria();
                criteria.andParentidEqualTo(Integer.parseInt(id));
                List<ShopCategory> list=categoryMapper.selectByExample(example);
                if (list.size()>0){
                    return 0;
                }
                categoryMapper.deleteByPrimaryKey(Integer.parseInt(id));
            }
        }
        return 1;
    }

    @Override
    public void updCategory(ShopCategory category) {



        categoryMapper.updateByPrimaryKeySelective(category);
    }

    @Override
    public List<ShopCategory> getAll() {
        ShopCategoryExample example=new ShopCategoryExample();
        ShopCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentidEqualTo(0);
        List<ShopCategory> onemenu = categoryMapper.selectByExample(example);


        return onemenu;
    }

    @Override
    public List<ShopCategory> getAllCategorys(String categoryName) {
        ShopCategoryExample example=new ShopCategoryExample();
        ShopCategoryExample.Criteria criteri=example.createCriteria();
        List<ShopCategory> categories = new ArrayList<>();
        if (categoryName == "0" || "0".equals(categoryName)) {
            categories = categoryMapper.selectByExample(null);
        } else {
            criteri.andCNameLike("%"+categoryName+"%");
            categories = categoryMapper.selectByExample(example);
        }
        return categories;
    }

    //通过pid获取菜单列表
    @Override
    public String getmenu(String pid,HttpServletRequest request){
        String saveUrl=request.getScheme() + "://"+request.getServerName()+":" +
                request.getServerPort()+"/ssm/file/showPic?fileName=";
        JSONArray jsonArray = new JSONArray();
        //如果pid是0，获取一级和二级列表
        if (pid == null || "".equals(pid) || "0".equals(pid)){
            ShopCategoryExample example = new ShopCategoryExample();
            ShopCategoryExample.Criteria criteria = example.createCriteria();
            criteria.andParentidEqualTo(0);
            List<ShopCategory> shopCategories = categoryMapper.selectByExample(example);
            for (ShopCategory s: shopCategories){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("cateName",s.getcName());
                jsonObject.put("cId",s.getcId());
                jsonObject.put("img",saveUrl+s.getcImage());
                //获取二级列表
                if (s.getcId() == 1){
                    ShopCategoryExample example1 = new ShopCategoryExample();
                    ShopCategoryExample.Criteria criteria1 = example1.createCriteria();
                    criteria1.andParentidEqualTo(1);
                    List<ShopCategory> shopCategories1 = categoryMapper.selectByExample(example1);
                    com.alibaba.fastjson.JSONArray jsonArray1 = new com.alibaba.fastjson.JSONArray();
                    //存放cid 便于获取此素材的所有课程
                    List<Integer> list = new ArrayList<>();
                    for(ShopCategory category : shopCategories1){
                        com.alibaba.fastjson.JSONObject jsonObject1 = new com.alibaba.fastjson.JSONObject();
                        jsonObject1.put("cateName",category.getcName());
                        jsonObject1.put("cId",category.getcId());
                        list.add(category.getcId());
                        //获取下面所有的课程
                        ShopProductExample example2 = new ShopProductExample();
                        ShopProductExample.Criteria criteria2 = example2.createCriteria();
                        criteria2.andCIdIn(list);
                        List<ShopProduct> products = shopProductMapper.selectByExample(example2);
                        jsonObject1.put("productlist",products);
                        jsonArray1.add(jsonObject1);
                    }
                    jsonObject.put("son",jsonArray1);
                }else {
                    jsonObject.put("son",new com.alibaba.fastjson.JSONArray());
                }
                jsonArray.add(jsonObject);
            }
            com.alibaba.fastjson.JSONObject jsonObject = new com.alibaba.fastjson.JSONObject();
            jsonObject.put("status",200);
            jsonObject.put("msg","ok");
            jsonObject.put("data",jsonArray);
            return jsonObject.toString();
        }else {
            //如果pid不是0获取pid对应的列表
            ShopCategoryExample example1 = new ShopCategoryExample();
            ShopCategoryExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andParentidEqualTo(Integer.parseInt(pid));
            List<ShopCategory> shopCategories1 = categoryMapper.selectByExample(example1);
            if (shopCategories1 == null||shopCategories1.size()<=0) {
                return JsonUtils.objectToJson(WxResult.ok("无数据"));
            }
            return JsonUtils.objectToJson(WxResult.ok(shopCategories1));
        }
    }
    @Override
    public WxResult getmenu1(HttpServletRequest request){
        String saveUrl=request.getScheme() + "://"+request.getServerName()+":" +
                request.getServerPort()+"/ssm/file/showPic?fileName=";
        //等待存放第一级数据
        com.alibaba.fastjson.JSONArray jsonArray = new com.alibaba.fastjson.JSONArray();
        //查询出一级列表
        ShopCategoryExample example = new ShopCategoryExample();
        example.setOrderByClause("c_sorting desc");
        ShopCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentidEqualTo(0);
        List<ShopCategory> shopCategories = categoryMapper.selectByExample(example);
        for (ShopCategory shopCategory:shopCategories){
            com.alibaba.fastjson.JSONObject jsonObject1 = new com.alibaba.fastjson.JSONObject();
            jsonObject1.put("cName",shopCategory.getcName());
            jsonObject1.put("img",saveUrl+shopCategory.getcImage());
            jsonObject1.put("cId",shopCategory.getcId());
            //存放二级列表  通过一级列表的id   就是二级列表的父id
            com.alibaba.fastjson.JSONArray jsonArray1 = new com.alibaba.fastjson.JSONArray();
            ShopCategoryExample example1 = new ShopCategoryExample();
            example.setOrderByClause("c_sorting desc");
            ShopCategoryExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andParentidEqualTo(shopCategory.getcId());
            List<ShopCategory> shopCategories1 = categoryMapper.selectByExample(example1);
            //获取二级列表
            for (ShopCategory shopCategory1 : shopCategories1){
                com.alibaba.fastjson.JSONObject jsonObject2 = new com.alibaba.fastjson.JSONObject();
                jsonObject2.put("cName",shopCategory1.getcName());
                jsonObject2.put("cId",shopCategory1.getcId());
                jsonObject2.put("pId",shopCategory1.getParentid());
                jsonObject2.put("img",saveUrl+shopCategory1.getcImage());
                jsonArray1.add(jsonObject2);
            }
            jsonObject1.put("son",jsonArray1);
            jsonArray.add(jsonObject1);
        }
        return WxResult.ok(jsonArray);
    }
}
