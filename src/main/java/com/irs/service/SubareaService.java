package com.irs.service;

import com.irs.pojo.*;
import com.irs.util.ResultUtil;
import com.irs.util.WxResult;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface SubareaService {
    Subarea selSubareaById(Long id);

    void updSubarea(Subarea subarea);

    void delSubareaById(Long sbId);

    void delSubarea(String carouselStr);

    Subarea checkSubareaByleName(String leName);

    void insSubarea(Subarea subarea);

    ResultUtil setSubarea(Integer page, Integer limit);

    void updsubareaStatusById(Long sbId, Integer sbIsshow);

    void instPSbProduct(String carouselStr,Long sbId);

    ResultUtil lookProduct(Integer page, Integer limit, String sbId);

    ResultUtil getProductList(Integer page, Integer limit, Long sbId);

    Psb selSubareaProduct(Integer pId, Long sbId);

    Psb updateProduct(Psb psb);

    void delSubareaProducts(String userStr, Long sbId);

    ResultUtil getProductListFirst(Integer page, Integer limit, Long sbId);

    WxResult getSubareaPro(HttpServletRequest request, Integer page, Integer limit,String sbId, int pValidity);

    WxResult getSubarea(HttpServletRequest request);

    void guanlianVIP(Integer leId, String sbId);

    ResultUtil setLevel(Integer page, Integer limit,String sbId);

    void quxiaoVIP(Integer leId, String sbId);

    List<Subarea> getAll();

    void inszhidingProduct(ShopProduct shopProduct,HttpServletRequest request);

    WxResult getShopType(HttpServletRequest request,int pValidity);
}
