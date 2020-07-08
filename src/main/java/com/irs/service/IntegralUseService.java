package com.irs.service;

import com.irs.pojo.IntegralUse;
import com.irs.pojo.ProductItem;
import com.irs.pojo.ShopProduct;
import com.irs.pojo.Teacher;
import com.irs.pojo.vo.ProductSaleVo;
import com.irs.util.ResultUtil;
import com.irs.util.WxResult;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IntegralUseService {
    public List<IntegralUse> getAll();

    public IntegralUse selLevelById(Integer id);

    public ResultUtil getIntegralUseList(Integer page, Integer limit);

    public void insIntegralUse(IntegralUse integralUse);

    public void updIntegralUse(IntegralUse integralUse);

    public void delIntegralUse(String carouselStr);

    public void delLevelById(Integer id);

    public IntegralUse checkIntegralUseByPrices(String prices);

    public ResultUtil getpropaihang(Integer page, Integer limit,ProductSaleVo productSaleVo);

    List<Teacher> getTeacher(HttpServletRequest request);

    WxResult integralsbyuid(String uid);

    List<ProductSaleVo> getpropaihang2(Integer oState);
}
