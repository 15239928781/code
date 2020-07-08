package com.irs.service;

import com.irs.pojo.ProductItem;
import com.irs.util.ResultUtil;

public interface ProductItemService {
    ProductItem selPItemById(Integer id);

    ResultUtil getPItemList(Integer page, Integer limit, ProductItem search);

    void insPItem(ProductItem productItem);

    void delPItemById(Integer id);

    void delPItem(String carouselStr);

    void updPItem(ProductItem productItem);
}
