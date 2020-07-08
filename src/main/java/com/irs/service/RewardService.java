package com.irs.service;

import com.irs.pojo.Integrals;
import com.irs.pojo.IntegralsReward;
import com.irs.util.ResultUtil;

public interface RewardService {
    public IntegralsReward selLevelById(Integer id);

    public ResultUtil getRewardList(Integer page, Integer limit);

    public void insReward(IntegralsReward reward);

    public void updReward(IntegralsReward reward);

    public void delReward(String carouselStr);

    public void delLevelById(Integer id);

    public IntegralsReward checkRewardByPrices(String prices);

    IntegralsReward select();

    void inserIntegralis(Integrals integrals);
}
