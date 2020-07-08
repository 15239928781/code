package com.irs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.irs.mapper.ProductItemMapper;
import com.irs.pojo.ProductItem;
import com.irs.pojo.ProductItemExample;
import com.irs.service.ProductItemService;
import com.irs.util.ResultUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductItemServiceImpl implements ProductItemService {

    @Autowired
    private ProductItemMapper productItemMapper;

    @Override
    public ProductItem selPItemById(Integer id) {
        return productItemMapper.selectByPrimaryKey(id);
    }

    @Override
    public ResultUtil getPItemList(Integer page, Integer limit, ProductItem search) {
        PageHelper.startPage(page, limit);
        ProductItemExample example=new ProductItemExample();
        example.setOrderByClause("i_id desc");
        ProductItemExample.Criteria criteria=example.createCriteria();
        if(search.getiName()!=null && !"".equals(search.getiName())){
            criteria.andINameLike("%"+search.getiName()+"%");
        }
        if (search.getpId()!=null && !"".equals(search.getpId())){
            criteria.andPIdEqualTo(search.getpId());
        }
        List<ProductItem> list=productItemMapper.selectByExample(example);
        PageInfo<ProductItem> pageInfo=new PageInfo<>(list);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public void insPItem(ProductItem productItem) {
        productItemMapper.insertSelective(productItem);
    }

    @Override
    public void delPItemById(Integer id) {
        productItemMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void delPItem(String carouselStr) {
        if(!StringUtils.isBlank(carouselStr)){
            String[] ids=carouselStr.split(",");
            for (String id : ids) {
                productItemMapper.deleteByPrimaryKey(Integer.parseInt(id));
            }
        }
    }

    @Override
    public void updPItem(ProductItem productItem) {
        productItemMapper.updateByPrimaryKeySelective(productItem);
    }
}
