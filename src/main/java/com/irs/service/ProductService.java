package com.irs.service;

import com.irs.pojo.ShopProduct;
import com.irs.util.ResultUtil;
import com.irs.util.WxResult;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ProductService {
    WxResult getHotProduct(HttpServletRequest request,Integer page,Integer limit,int pValidity);

    WxResult getRecommendProduct(HttpServletRequest request,Integer page,Integer limit,int pValidity);

    WxResult getTopProduct(HttpServletRequest request);

    WxResult getProductBySearch(String key,HttpServletRequest request);

    ShopProduct selProductBypid(int parseInt);

    void insProduct(ShopProduct product,HttpServletRequest request);

    ResultUtil getProductList(Integer page, Integer limit, ShopProduct search);

    void delProducts(String userStr);

    void delProductByPid(String pId);

    void updProduct(ShopProduct product);

    WxResult getProductByPid(int pId, int uId,int sbId ,HttpServletRequest request);

    WxResult getProductByCategory(Integer start, Integer length, int cId, int orders,HttpServletRequest request);

    WxResult getBrowseList(int uId, Integer start, Integer length,HttpServletRequest request);

    List<ShopProduct> getAll(int status);

    WxResult getAllProduct(Integer start, Integer length);

    List<ShopProduct> getProductByCate(Integer getcId,Integer uId,HttpServletRequest request);

    //通过父id获取列表
    WxResult getmenubycid(String cid,String start,String length, HttpServletRequest request);

    //获取秒杀素材
    WxResult getspikeproduct(HttpServletRequest request,int start,int length);

    //随机获取素材
    WxResult getproduct(HttpServletRequest request,Integer page, Integer limit);

    WxResult getcIdBypId(Integer pId,HttpServletRequest request);

    List<ShopProduct> getProdtct();
}
