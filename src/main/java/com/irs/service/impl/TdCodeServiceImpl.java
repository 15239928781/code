package com.irs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.irs.mapper.TdCodeMapper;
import com.irs.pojo.*;
import com.irs.service.TdCodeService;
import com.irs.util.ResultUtil;
import com.irs.util.WxResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Service
public class TdCodeServiceImpl implements TdCodeService {
    @Autowired
    private TdCodeMapper tdCodeMapper;
    @Override
    public WxResult getTdCode(HttpServletRequest request) {
        return null;
    }

    @Override
    public TdCode selTdCodeById(Integer tdId) {
        return null;
    }

    @Override
    public ResultUtil getTdCodeList(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
//        ShopCategoryExample example=new ShopCategoryExample();
//        ShopCategoryExample.Criteria criteria = example.createCriteria();
//        criteria.andParentidEqualTo(0);
//        example.setOrderByClause("c_sorting desc");
//        List<ShopCategory> list=categoryMapper.selectByExample(example);
//        PageInfo<ShopCategory> pageInfo = new PageInfo<ShopCategory>(list);
//        ResultUtil resultUtil = new ResultUtil();
//        resultUtil.setCode(0);
//        resultUtil.setCount(pageInfo.getTotal());
//        resultUtil.setData(pageInfo.getList());
//        return resultUtil;
        TdCodeExample example = new TdCodeExample();
        example.setOrderByClause("td_id desc");
        TdCodeExample.Criteria criteria = example.createCriteria();
        List<TdCode> list=tdCodeMapper.selectByExample(example);
        PageInfo<TdCode> pageInfo = new PageInfo<>(list);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return  resultUtil;


    }

    @Override
    public void insTdCode(ShopCategory category) {

    }

    @Override
    public int delTdCodeById(Integer tdId) {
        return 0;
    }

    @Override
    public int delTdCode(String carouselStr) {
        return 0;
    }


    @Override
    public List<TdCode> getAll() {
        return null;
    }


    @Override
    public ResultUtil selectByTdId(Integer tdId) {
        TdCodeExample example = new TdCodeExample();
        TdCodeExample.Criteria criteria = example.createCriteria();
        criteria.andTdIdEqualTo(tdId);
        return ResultUtil.ok(tdCodeMapper.selectByExample(example));
    }

    @Override
    public List<TdCode> selecttdId(Integer getfId) {
        return null;
    }

    @Override
    public ResultUtil getVcodeList(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        TdCodeExample example = new TdCodeExample();
        example.setOrderByClause("td_id desc");
        TdCodeExample.Criteria criteria = example.createCriteria();
        List<TdCode> list=tdCodeMapper.selectByExample(example);
        PageInfo<TdCode> pageInfo = new PageInfo<>(list);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return  resultUtil;
    }

    @Override
    public void deletes(String carouselStr) {
        if(!StringUtils.isBlank(carouselStr)){
            String[] ids=carouselStr.split(",");
            for (String id : ids) {
               /* TdCodeExample example = new TdCodeExample();
                TdCodeExample.Criteria criteria = example.createCriteria();
                criteria.andTdIdEqualTo(Integer.parseInt(id));*/
                tdCodeMapper.deleteByPrimaryKey(Integer.parseInt(id));

            }
        }
    }

    @Override
    public void save(TdCode tdCode) {
        tdCodeMapper.insert(tdCode);
    }

    @Override
    public TdCode selectBytdId(Integer tdId) {
        TdCode tdCode = tdCodeMapper.selectByPrimaryKey(tdId);
        return tdCode;
    }

    @Override
    public void update(TdCode tdCode) {
//        tdCodeMapper.updateByPrimaryKey(tdCode);
        tdCodeMapper.updateByPrimaryKeySelective(tdCode);
    }

    @Override
    public WxResult getOneImage(HttpServletRequest request) {

        String saveUrl=request.getScheme() + "://"+request.getServerName()+":" +
                request.getServerPort()+"/ssm";

        TdCodeExample example=new TdCodeExample();
        TdCodeExample.Criteria criteria = example.createCriteria();

        List<TdCode> list=tdCodeMapper.selectByExample(example);
        String strDirPath = request.getScheme() + "://"+request.getServerName()+":" +
                request.getServerPort();
        for (TdCode tdCode : list) {
            //tdCode.setImgurl(strDirPath+"/ssm/file/showPic?fileName="+tbCarousel.getImgurl());
            tdCode.setBackground(strDirPath+"/ssm/file/showPic?fileName="+tdCode.getBackground());
            tdCode.setTdCode(strDirPath+"/ssm/file/showPic?fileName="+tdCode.getTdCode());
        }
        TdCode tdCode = list.get(0);
        return WxResult.build(200, "ok", tdCode);
    }
}
