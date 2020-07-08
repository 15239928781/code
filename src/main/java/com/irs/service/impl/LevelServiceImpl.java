package com.irs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.irs.mapper.LevelMapper;
import com.irs.pojo.Level;
import com.irs.pojo.LevelExample;
import com.irs.service.LevelService;
import com.irs.util.ResultUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LevelServiceImpl implements LevelService {

    @Autowired
    private LevelMapper levelMapper;

    @Override
    public Level selLevelById(Integer id) {
        return levelMapper.selectByPrimaryKey(id);
    }

    @Override
    public ResultUtil setLevel(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        LevelExample example=new LevelExample();
        example.setOrderByClause("le_id desc");
        LevelExample.Criteria criteria=example.createCriteria();
        List<Level>  list=levelMapper.selectByExample(example);
        PageInfo<Level> pageInfo=new PageInfo<>(list);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public void insLevel(Level level) {
        levelMapper.insertSelective(level);
    }

    @Override
    public void updLevel(Level level) {
        levelMapper.updateByPrimaryKeySelective(level);
    }

    @Override
    public void delLevelById(Integer id) {
        levelMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void delLevel(String carouselStr) {
        List<Integer> leids=new ArrayList<>();
        if(!StringUtils.isBlank(carouselStr)){
            String[] ids=carouselStr.split(",");
            for (String id : ids) {
                leids.add(Integer.parseInt(id));
            }
        }
        LevelExample example=new LevelExample();
        LevelExample.Criteria criteria=example.createCriteria();
        criteria.andLeIdIn(leids);
        levelMapper.deleteByExample(example);
    }

    @Override
    public Level checkLevelByleName(String leName) {
        LevelExample example=new LevelExample();
        LevelExample.Criteria criteria=example.createCriteria();
        criteria.andLeNameEqualTo(leName);
        List<Level> list=levelMapper.selectByExample(example);
        if(list.size()>0){
            return list.get(0);
        }
        return null;
    }
}
