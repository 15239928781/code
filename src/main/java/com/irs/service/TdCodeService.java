package com.irs.service;

import com.irs.pojo.ShopCategory;
import com.irs.pojo.TdCode;
import com.irs.util.ResultUtil;
import com.irs.util.WxResult;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface TdCodeService {
    WxResult getTdCode(HttpServletRequest request);

    TdCode selTdCodeById(Integer tdId);

    ResultUtil getTdCodeList(Integer page, Integer limit);

    void insTdCode(ShopCategory category);

    int delTdCodeById(Integer tdId);

    int delTdCode(String carouselStr);

    List<TdCode> getAll();

    ResultUtil selectByTdId(Integer tdId);

    List<TdCode> selecttdId(Integer getfId);


    ResultUtil getVcodeList(Integer page, Integer limit);

    void deletes(String carouselStr);

    void save(TdCode tdCode);

    TdCode selectBytdId(Integer tdId);

    void update(TdCode tdCode);

    WxResult getOneImage(HttpServletRequest request);
}
