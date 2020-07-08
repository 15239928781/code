package com.irs.service.impl;

import com.github.pagehelper.PageInfo;
import com.irs.mapper.IntegralsMapper;
import com.irs.mapper.IntegralsRewardMapper;
import com.irs.pojo.Integrals;
import com.irs.pojo.IntegralsReward;
import com.irs.pojo.IntegralsRewardExample;
import com.irs.service.RewardService;
import com.irs.util.ResultUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RewardServiceImpl implements RewardService {

    @Autowired
    private IntegralsRewardMapper integralsRewardMapper;

    @Autowired
    private IntegralsMapper integralsMapper;

    @Override
    public IntegralsReward selLevelById(Integer id) {
        return integralsRewardMapper.selectByPrimaryKey(id);
    }

    @Override
    public ResultUtil getRewardList(Integer page, Integer limit) {
        IntegralsRewardExample example=new IntegralsRewardExample();
        example.setOrderByClause("r_id desc");
        List<IntegralsReward> list=integralsRewardMapper.selectByExample(example);
        PageInfo<IntegralsReward> pageInfo=new PageInfo<>(list);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public void insReward(IntegralsReward reward) {
        integralsRewardMapper.insertSelective(reward);
    }

    @Override
    public void updReward(IntegralsReward reward) {
        integralsRewardMapper.updateByPrimaryKeySelective(reward);
    }

    @Override
    public void delReward(String carouselStr) {
        List<Integer> iuids=new ArrayList<>();
        if(!StringUtils.isBlank(carouselStr)){
            String[] ids=carouselStr.split(",");
            for (String id : ids) {
                iuids.add(Integer.parseInt(id));
            }
        }
        IntegralsRewardExample example=new IntegralsRewardExample();
        IntegralsRewardExample.Criteria criteria=example.createCriteria();
        criteria.andRIdIn(iuids);
        integralsRewardMapper.deleteByExample(example);
    }

    @Override
    public void delLevelById(Integer id) {
        integralsRewardMapper.deleteByPrimaryKey(id);
    }

    @Override
    public IntegralsReward checkRewardByPrices(String prices) {
        IntegralsRewardExample example=new IntegralsRewardExample();
        IntegralsRewardExample.Criteria criteria=example.createCriteria();
        criteria.andRPricesEqualTo(prices);
        List<IntegralsReward> list=integralsRewardMapper.selectByExample(example);
        if (list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public IntegralsReward select() {
        IntegralsRewardExample example=new IntegralsRewardExample();
        example.setOrderByClause("r_id desc");
        List<IntegralsReward> list=integralsRewardMapper.selectByExample(example);
        if (list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public void inserIntegralis(Integrals integrals) {
        integralsMapper.insertSelective(integrals);
    }
}
