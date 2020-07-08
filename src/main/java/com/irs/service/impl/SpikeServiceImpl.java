package com.irs.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.irs.mapper.ShopProductMapper;
import com.irs.mapper.SpikeProductMapper;
import com.irs.pojo.GroupsProduct;
import com.irs.pojo.ShopProduct;
import com.irs.pojo.SpikeProduct;
import com.irs.pojo.SpikeProductExample;
import com.irs.service.SpikeService;
import com.irs.util.CommonUtils;
import com.irs.util.DateUtil;
import com.irs.util.ResultUtil;
import com.irs.util.WxResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class SpikeServiceImpl implements SpikeService {

    @Autowired
    private SpikeProductMapper spikeProductMapper;

    @Autowired
    private ShopProductMapper productMapper;

    @Override
    public void updSpike(SpikeProduct teacher) {
        String nowtime= CommonUtils.nowtime();
        if( teacher.getpCreatetime().compareTo(nowtime)<0){
            teacher.setSpStatus(2);
        }
        spikeProductMapper.updateByPrimaryKeySelective(teacher);
    }

    @Override
    public void delSpike(String carouselStr) {
        if(!StringUtils.isBlank(carouselStr)){
            String[] ids=carouselStr.split(",");
            for (String id : ids) {
                spikeProductMapper.deleteByPrimaryKey(Integer.parseInt(id));
            }
        }
    }

    @Override
    public void delSpikeById(Integer id) {
        spikeProductMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insSpike(SpikeProduct product) {
        String nowtime= CommonUtils.nowtime();
        SpikeProductExample example=new SpikeProductExample();
        SpikeProductExample.Criteria criteria=example.createCriteria();
        criteria.andPIdEqualTo(product.getpId());
        criteria.andPEndtimeGreaterThanOrEqualTo(nowtime);
        List<SpikeProduct> list=spikeProductMapper.selectByExample(example);
        if (list.size()>0){
            return 0;
        }
        ShopProduct shopProduct=productMapper.selectByPrimaryKey(product.getpId());
        product.setpName(shopProduct.getpName());
        product.setpOldprice(String.valueOf(shopProduct.getpOldprice()));
        product.setpDesc(shopProduct.getpDesc());
        product.setpImage(shopProduct.getpImage());

        if( product.getpCreatetime().compareTo(nowtime)<0){
            product.setSpStatus(1);
        }
        product.setSpStatus(2);
        spikeProductMapper.insertSelective(product);
        return 1;
    }

    @Override
    public ResultUtil getSpikeList(Integer page, Integer limit, SpikeProduct product) {
        PageHelper.startPage(page,limit);
        SpikeProductExample example=new SpikeProductExample();
        example.setOrderByClause("sp_id desc");
        SpikeProductExample.Criteria criteria=example.createCriteria();
        if (product.getpName()!=null && !"".equals(product.getpName())){
            criteria.andPNameLike("%"+product.getpName()+"%");
        }
        if (product.getSpStatus()!=null &&product.getSpStatus()!=-1){
            criteria.andSpStatusEqualTo(product.getSpStatus());
        }
        List<SpikeProduct> list=spikeProductMapper.selectByExample(example);
        for (SpikeProduct spikeProduct:list){
            //注意：SimpleDateFormat构造函数的样式与strDate的样式必须相符
            SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //加上时间
            //必须捕获异常
            try {
                Date end=sDateFormat.parse(spikeProduct.getpEndtime());
                Date start=sDateFormat.parse(spikeProduct.getpCreatetime());
                if (compareDate(start,end, DateUtil.getDate())) {
                    spikeProduct.setSpStatus(2);
                } else if (end.getTime()<DateUtil.getDate().getTime()) {
                    spikeProduct.setSpStatus(3);
                } else if (start.getTime()>DateUtil.getDate().getTime()){
                    spikeProduct.setSpStatus(1);
                }
            } catch(ParseException px) {
                px.printStackTrace();
            }
        }
        PageInfo<SpikeProduct> pageInfo=new PageInfo<>(list);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }
    // 判断时间是否在时间段内
    public static boolean compareDate(Date start, Date end, Date date) {
        if (date.getTime() >= start.getTime() && date.getTime() <= end.getTime()) {
            return true;
        }
        return false;
    }
    @Override
    public SpikeProduct selSpikeById(Integer id) {
        return spikeProductMapper.selectByPrimaryKey(id);
    }

    //获取秒杀中的素材
    @Override
    public WxResult getspikes() {
        SpikeProductExample example = new SpikeProductExample();
        SpikeProductExample.Criteria criteria = example.createCriteria();
        criteria.andSpStatusEqualTo(2);
        List<SpikeProduct> spikeProducts = spikeProductMapper.selectByExample(example);
        if (spikeProducts.size() <= 0 || null == spikeProducts ) {
            return WxResult.build(200,"无秒杀素材");
        } else {
            return WxResult.ok(spikeProducts);
        }
    }
}
