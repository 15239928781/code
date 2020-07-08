
package com.irs.service;

import com.irs.pojo.SpikeProduct;
import com.irs.util.ResultUtil;
import com.irs.util.WxResult;

public interface SpikeService {
    void updSpike(SpikeProduct teacher);

    void delSpike(String carouselStr);

    void delSpikeById(Integer id);

    int insSpike(SpikeProduct product);

    ResultUtil getSpikeList(Integer page, Integer limit, SpikeProduct product);

    SpikeProduct selSpikeById(Integer id);

    //获取正在秒杀中的素材
    WxResult getspikes();
}

