package com.irs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.irs.mapper.*;
import com.irs.pojo.*;
import com.irs.pojo.vo.ProductSaleVo;
import com.irs.service.IntegralUseService;
import com.irs.util.CommonUtils;
import com.irs.util.ResultUtil;
import com.irs.util.WxResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IntegralUseServiceImpl implements IntegralUseService {

    @Autowired
    private IntegralUseMapper integralUseMapper;

    @Autowired
    private ShopProductMapper shopProductMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private IntegralsMapper integralsMapper;

    @Autowired
    private ShopOrderitemMapper orderitemMapper;

    @Autowired
    private ShopOrdersMapper ordersMapper;


    //查询首页素材排行
    @Override
    public ResultUtil getpropaihang(Integer page, Integer limit, ProductSaleVo productSaleVo) {
        PageHelper.startPage(page, limit);

        ShopProductExample example = new ShopProductExample();
        ShopProductExample.Criteria criteria = example.createCriteria();
        List<ShopProduct> productList = shopProductMapper.selectByExample(example);
        for (ShopProduct product : productList) {
            Double sum = 0.0;
            List<Integer> orderNum = new ArrayList<>();
            Integer i = 0;
            ShopOrderitemExample example1 = new ShopOrderitemExample();
            ShopOrderitemExample.Criteria criteria1 = example1.createCriteria();
            if (productSaleVo.getCreateTimeStart() != null && !productSaleVo.getCreateTimeStart().equals("")) {
                criteria1.andR2GreaterThanOrEqualTo(productSaleVo.getCreateTimeStart());
            }
            if (productSaleVo.getCreateTimeEnd() != null && !productSaleVo.getCreateTimeStart().equals("")) {
                criteria1.andR2LessThanOrEqualTo(productSaleVo.getCreateTimeEnd());
            }
            criteria1.andPIdEqualTo(product.getpId());
            List<ShopOrderitem> orderitemList = orderitemMapper.selectByExample(example1);
            for (ShopOrderitem shopOrderitem : orderitemList) {
                ShopOrders orders = ordersMapper.selectByPrimaryKey(shopOrderitem.getoId());
                if (orders!=null){
                    if (!orders.getoState().equals(1)) {
                        if (!shopOrderitem.getOiCount().equals(1)) {
                            i = shopOrderitem.getOiCount();
                        }
                        sum += shopOrderitem.getSubtotal();
                        orderNum.add(shopOrderitem.getoId());
                    }
                }

            }
            product.setSales(String.valueOf(orderNum.size() + i));
            product.setPrivace(String.format("%.2f", sum));
            if (product.gettId() != null && !product.gettId().equals("")) {
                Teacher teacher = teacherMapper.selectByPrimaryKey(product.gettId());
                product.settName(teacher.gettName());
            } else {
                product.settName("暂无");
            }
        }
        PageInfo<ShopProduct> pageInfo = new PageInfo<>(productList);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public List<Teacher> getTeacher(HttpServletRequest request) {
       /* List<ShopProduct> shopProducts = shopProductMapper.getTeacher();
        System.out.println(shopProducts.toString());
        //创建返回到前台的实体类
        List<Teacher> productSaleVos = new ArrayList<>();
        for (ShopProduct product : shopProducts){
            Teacher teacher=teacherMapper.selectByPrimaryKey(product.gettId());
            productSaleVos.add(teacher);
        }*/
        String strDirPath = request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort();
        PageHelper.startPage(1, 5);
        TeacherExample example = new TeacherExample();
        example.setOrderByClause("t_id desc");
        TeacherExample.Criteria criteria = example.createCriteria();
        List<Teacher> teacherList = teacherMapper.selectByExample(example);
        for (Teacher teacher : teacherList) {
            // teacher.settPic(strDirPath+"/ssm/file/showPic?fileName="+teacher.gettPic());
            teacher.settPic(strDirPath + "/ssm/file/showPic?fileName=" + teacher.gettPic());
        }
        return teacherList;
    }

    @Override
    public WxResult integralsbyuid(String uid) {
        IntegralsExample example = new IntegralsExample();
        IntegralsExample.Criteria criteria = example.createCriteria();
        criteria.andUIdEqualTo(Integer.valueOf(uid));
        List<Integrals> list = integralsMapper.selectByExample(example);
        Map map = new HashMap();
        map.put("list", list);
        if (list.size() > 0) {
            //收入积分
            int count = integralsMapper.sumIntegral(1, Integer.parseInt(uid));
            //支出
            int subcount = integralsMapper.sumIntegral(0, Integer.parseInt(uid));
            map.put("sum", count - subcount);
        } else {
            map.put("sum", 0);
        }

        return WxResult.ok(map);
    }

    @Override
    public List<ProductSaleVo> getpropaihang2(Integer oState) {
        return null;
    }

    @Override
    public List<IntegralUse> getAll() {

        IntegralUseExample example = new IntegralUseExample();
        example.setOrderByClause("iu_id desc");
        IntegralUseExample.Criteria criteria = example.createCriteria();
        List<IntegralUse> list = integralUseMapper.selectByExample(example);
        return list;
    }

    @Override
    public IntegralUse selLevelById(Integer id) {
        return integralUseMapper.selectByPrimaryKey(id);
    }

    @Override
    public ResultUtil getIntegralUseList(Integer page, Integer limit) {
        IntegralUseExample example = new IntegralUseExample();
        example.setOrderByClause("iu_id desc");
        IntegralUseExample.Criteria criteria = example.createCriteria();
        List<IntegralUse> list = integralUseMapper.selectByExample(example);
        PageInfo<IntegralUse> pageInfo = new PageInfo<>(list);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public void insIntegralUse(IntegralUse integralUse) {
        integralUseMapper.insertSelective(integralUse);
    }

    @Override
    public void updIntegralUse(IntegralUse integralUse) {
        integralUseMapper.updateByPrimaryKeySelective(integralUse);
    }

    @Override
    public void delIntegralUse(String carouselStr) {
        List<Integer> iuids = new ArrayList<>();
        if (!StringUtils.isBlank(carouselStr)) {
            String[] ids = carouselStr.split(",");
            for (String id : ids) {
                iuids.add(Integer.parseInt(id));
            }
        }
        IntegralUseExample example = new IntegralUseExample();
        IntegralUseExample.Criteria criteria = example.createCriteria();
        criteria.andIuIdIn(iuids);
        integralUseMapper.deleteByExample(example);
    }

    @Override
    public void delLevelById(Integer id) {
        integralUseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public IntegralUse checkIntegralUseByPrices(String num) {
        IntegralUseExample example = new IntegralUseExample();
        IntegralUseExample.Criteria criteria = example.createCriteria();
        criteria.andIuNumEqualTo(Integer.valueOf(num));
        List<IntegralUse> list = integralUseMapper.selectByExample(example);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}
