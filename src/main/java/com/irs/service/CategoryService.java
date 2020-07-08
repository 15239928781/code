package com.irs.service;

import com.irs.pojo.ShopCategory;
import com.irs.util.ResultUtil;
import com.irs.util.WxResult;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface CategoryService {
    WxResult getAllCategory(HttpServletRequest request);

    ShopCategory selCategoryById(Integer id);

    ResultUtil getCategoryList(Integer page, Integer limit,String type);

    void insCategory(ShopCategory category);

    int delCategoryById(Integer id);

    int delCategory(String carouselStr);

    void updCategory(ShopCategory category);

    List<ShopCategory> getAll();

    String getmenu(String pid,HttpServletRequest request);
    WxResult getmenu1(HttpServletRequest request);

    List<ShopCategory> getAllCategorys(String categoryName);

    List<ShopCategory> selCategoryBypid();

    ResultUtil selectByCId(Integer cId);

    List<ShopCategory> selectFId(Integer getfId);

    void updateShow(Integer id, Integer status);
    void updCategorySortingById(ShopCategory shopCategory);
    void updCategorySortingById2(ShopCategory shopCategory);

}
