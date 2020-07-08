package com.irs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.irs.mapper.*;
import com.irs.pojo.*;
import com.irs.service.OrdersService;
import com.irs.util.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private ShopOrdersMapper ordersMapper;
    @Autowired
    private PsbMapper psbMapper;

    @Autowired
    private ShopCartMapper cartMapper;

    @Autowired
    private ShopProductMapper productMapper;

    @Autowired
    private ShopOrderitemMapper orderitemMapper;

    @Autowired
    private ShopAddressMapper addressMapper;

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private ShopCategoryMapper categoryMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private ProductItemMapper productItemMapper;

    @Autowired
    private ShopRechargeMapper rechargeMapper;
    @Autowired
    private LevelMapper levelMapper;

    @Override
    public WxResult getTalbymoth() {
        String data = DateUtil.getDate(DateUtil.DateFormat8);
        //创建一个list存放三种不同的统计
        Map maps = new HashMap();
        //创建一个map   存放收入数据
        Map<Integer, String> incomemap = new HashMap();
        //创建一个map   存放新增用户数据
        Map<Integer, String> userMap = new HashMap();
        //创建一个map   存放订单总数数据
        Map<Integer, String> ordermap = new HashMap();
        //制造默认数据
        for (int i = 1; i <= 12; i++) {
            if (i >= 1 && i <= 9) {
                incomemap.put(i, "0");
                userMap.put(i, "0");
                ordermap.put(i, "0");
            } else {
                incomemap.put(i, "0");
                userMap.put(i, "0");
                ordermap.put(i, "0");
            }
        }
        //收入一年中每个月的统计
        List<ShopOrders> shopOrders = ordersMapper.getTalbymoth(data);
        //如果查询没有结果，使用默认数据
        if (shopOrders == null || shopOrders.size() <= 0) {
            com.alibaba.fastjson.JSONArray jsonArray = new com.alibaba.fastjson.JSONArray();
            //遍历map中的值
            for (String value : incomemap.values()) {
                jsonArray.add(value);
            }
            maps.put("income", jsonArray);
        } else {
            //如果有结果替换数据
            for (ShopOrders orders : shopOrders) {
                incomemap.put(orders.getMoth(), "" + orders.getTotal() + "");
            }
            com.alibaba.fastjson.JSONArray jsonArray = new com.alibaba.fastjson.JSONArray();
            //遍历map中的值
            for (String value : incomemap.values()) {
                jsonArray.add(value);
            }
            maps.put("income", jsonArray);
        }
        //新增用户一年中每个月的统计
        List<Users> users = usersMapper.getUerBymoth(data);
        //如果查询没有结果，使用默认数据
        if (users == null || users.size() <= 0) {
            com.alibaba.fastjson.JSONArray jsonArray = new com.alibaba.fastjson.JSONArray();
            //遍历map中的值
            for (String value : incomemap.values()) {
                jsonArray.add(value);
            }
            maps.put("users", jsonArray);
        } else {
            //如果有结果替换数据
            for (Users user : users) {
                userMap.put(user.getMoth(), user.getSumuser());
            }
            com.alibaba.fastjson.JSONArray jsonArray = new com.alibaba.fastjson.JSONArray();
            //遍历map中的值
            for (String value : userMap.values()) {
                jsonArray.add(value);
            }
            maps.put("users", jsonArray);
        }
        //订单总数一年中每个月的统计
        List<ShopOrders> shopOrders1 = ordersMapper.getorderbymoth(data);
        //如果查询没有结果，使用默认数据
        if (shopOrders1 == null || shopOrders1.size() <= 0) {
            com.alibaba.fastjson.JSONArray jsonArray = new com.alibaba.fastjson.JSONArray();
            //遍历map中的值
            for (String value : ordermap.values()) {
                jsonArray.add(value);
            }
            maps.put("orders", jsonArray);
        } else {
            //如果有结果替换数据
            for (ShopOrders orders : shopOrders1) {
                ordermap.put(orders.getMoth(), "" + orders.getSumorder() + "");
            }
            com.alibaba.fastjson.JSONArray jsonArray = new com.alibaba.fastjson.JSONArray();
            //遍历map中的值
            for (String value : ordermap.values()) {
                jsonArray.add(value);
            }
            maps.put("orders", jsonArray);
        }
        return WxResult.ok(maps);
    }

    @Override
    public ShopOrders selectByOrderNum(String out_trade_no) {
        ShopOrdersExample example = new ShopOrdersExample();
        ShopOrdersExample.Criteria criteria = example.createCriteria();
        criteria.andOOrdernumEqualTo(out_trade_no);
        List<ShopOrders> ordersList = ordersMapper.selectByExample(example);
        if (ordersList.size() > 0) {
            return ordersList.get(0);
        }
        return null;
    }

    @Override
    public ResultUtil getTeacherNumList(Integer page, Integer limit, ShopOrders orders) {
        PageHelper.startPage(page, limit);
        //查询所有老师
        TeacherExample example = new TeacherExample();
        List<Teacher> teacherList = teacherMapper.selectByExample(example);

//        List<Integer> ordernumList=new ArrayList<>();
        for (Teacher teacher : teacherList) {
            List<Integer> count = new ArrayList<>();
            Double sum = 0.0;
            ShopProductExample example1 = new ShopProductExample();
            ShopProductExample.Criteria criteria = example1.createCriteria();
            criteria.andTIdEqualTo(teacher.gettId());
            //查询出对应的商品id
            List<ShopProduct> productsList = productMapper.selectByExample(example1);
            List<Integer> pIds = new ArrayList<>();
            Double sumPrices = 0.0;
            for (ShopProduct product : productsList) {
                pIds.add(product.getpId());
                //根据PID查找销量
                ShopOrderitemExample example3 = new ShopOrderitemExample();
                ShopOrderitemExample.Criteria criteria3 = example3.createCriteria();
                if (orders.getCreateTimeStart() != null && !orders.getCreateTimeStart().equals("")) {
                    criteria3.andR2GreaterThanOrEqualTo(orders.getCreateTimeStart());
                }
                if (orders.getCreateTimeEnd() != null && !orders.getCreateTimeStart().equals("")) {
                    criteria3.andR2LessThanOrEqualTo(orders.getCreateTimeEnd());
                }
                criteria3.andPIdEqualTo(product.getpId());
                List<ShopOrderitem> orderitemList = orderitemMapper.selectByExample(example3);

                //根据订单详情查看订单编号，判断订单是否支付成功
                for (ShopOrderitem shopOrderitem : orderitemList) {
                    ShopOrders shopOrders = ordersMapper.selectByPrimaryKey(shopOrderitem.getoId());
                    if (shopOrders!=null){
                        if (!shopOrders.getoState().equals(1)) {
                            sumPrices += shopOrderitem.getSubtotal();
                            count.add(shopOrderitem.getoId());
                        }
                    }

                }
                if (count.size() > 0) {
                    sum += sumPrices;
                }

            }
            String sum2 = String.format("%.2f", sum);
            teacher.settNum(count.size());
            teacher.setSumPrices(sum2);
        }
        PageInfo<Teacher> pageInfo = new PageInfo<Teacher>(teacherList);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public ResultUtil sumTotalByTime(String createTimeStart, String createTimeEnd) {
        Map map = new HashMap();
        //累计总收入
        //累计总收入
        Double subtotal = ordersMapper.sumTotalByTime(createTimeStart, createTimeEnd);
        String subtotalstr = "";
        if (subtotal == null || "".equals(subtotal)) {
            subtotalstr = 0.0 + "";
        } else {
            subtotalstr = String.format("%.2f", subtotal);
        }
        map.put("subtotal", subtotalstr);
        return ResultUtil.ok(map);
    }

    @Override
    public List<ShopOrderitem> selectByOrderId(Integer getoId) {
        ShopOrderitemExample example = new ShopOrderitemExample();
        ShopOrderitemExample.Criteria criteria = example.createCriteria();
        criteria.andOIdEqualTo(getoId);
        List<ShopOrderitem> orderitemList = orderitemMapper.selectByExample(example);
        return orderitemList;
    }



    @Override
    public WxResult getproductbyuid(int uid, int start, int length, HttpServletRequest request) {

        String saveUrl = request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort() + "/ssm/file/showPic?fileName=";
        Map map = new HashMap();

        //根据用户id查询订单编号
        ShopRechargeExample example = new ShopRechargeExample();
        ShopRechargeExample.Criteria criteria = example.createCriteria();
        criteria.andUIdEqualTo(uid);
        List<ShopRecharge> rechargeList = rechargeMapper.selectByExample(example);
        //1、找到订单编号2、根据订单编号找到订单id 3、根据订单id找到商品id
        List<String> ordernums = new ArrayList<>();
        for (ShopRecharge recharge : rechargeList) {
            ordernums.add(recharge.getOrdernum());
        }
        //根据订单编号查找订单id
        if (ordernums.size() > 0) {
//            PageHelper.startPage(start, length);
            ShopOrdersExample example3 = new ShopOrdersExample();
            ShopOrdersExample.Criteria criteria3 = example3.createCriteria();
            criteria3.andOOrdernumIn(ordernums);
            List<Integer> orderIds = new ArrayList<>();
            List<ShopOrders> ordersList = ordersMapper.selectByExample(example3);
            for (ShopOrders orders : ordersList) {
                orderIds.add(orders.getoId());
            }

            PageHelper.startPage(start, length);
            ShopOrderitemExample example2 = new ShopOrderitemExample();
            example2.setOrderByClause("r2 desc");
            ShopOrderitemExample.Criteria criteria2 = example2.createCriteria();
            criteria2.andOIdIn(orderIds);
            List<ShopOrderitem> orderitemList = orderitemMapper.selectByExample(example2);
            for (ShopOrderitem orderitem : orderitemList) {
                ShopProduct product = productMapper.selectByPrimaryKey(orderitem.getpId());
                if (product != null) {
                    orderitem.setpName(product.getpName());
                    orderitem.setpImage(saveUrl + product.getpImage());
                    orderitem.setFileName(String.valueOf(product.getpIsgroup()));
                    orderitem.setType(product.getpValidity());
                }
            }
            PageInfo<ShopOrderitem> pageInfo=new PageInfo<>(orderitemList);
            map.put("orderitemList", pageInfo.getList());
            return WxResult.build(200, "ok", map);
        }
        List<ShopOrderitem> orderitemList = new ArrayList<>();

        PageInfo<ShopOrderitem> pageInfo=new PageInfo<>(orderitemList);
        map.put("orderitemList", pageInfo.getList());
        return WxResult.build(200, "ok", map);
    }

    @Override
    public WxResult addOrderByCart(int uId, String cidlist) {
        System.out.println(cidlist);
        if ("".equals(cidlist) || null == cidlist) {
            return WxResult.build(400, "参数不能为空！");
        }
//		String arr[]=cidlist.split(",");
        JSONObject job = null;
        List<Integer> cli = new ArrayList<Integer>();
        JSONArray arr = JSONArray.fromObject(cidlist);
        for (int i = 0; i < arr.size(); i++) {
            job = arr.getJSONObject(i);
            System.out.println(job);
            if (job.get("cId") != null && !"".equals(job.get("cId"))) {
                Object ob = job.get("cId");
                System.out.println(Integer.valueOf(String.valueOf(ob)));
                cli.add(i, Integer.valueOf(String.valueOf(ob)));
            }
        }
//		for (String s : arr) {
//			System.out.println(s);
//		}
        Map map = new HashMap();
        try {
//			Address address=addressMapper.selectByPrimaryKey(aId);
            Date d = new Date();
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


            int oderid = (int) (Math.random() * 100000000);
            map.put("orderid", oderid);
//			List<Integer> cli=new ArrayList<Integer>();
            if (cli.size() > 0) {
//
//				for (int i = 0; i <cidlist.size(); i++) {
////					cli.add(i, cidlist.get(i).getcId());
//					System.out.println(cidlist.get(i));
//				}
                ShopCartExample example = new ShopCartExample();
                example.createCriteria().andCIdIn(cli);
                List<ShopCart> list = cartMapper.selectByExample(example);
                double sumtotal = 0;
                if (list.size() > 0 && list != null) {
                    for (ShopCart cart : list) {
                        ShopProduct product = productMapper.selectByPrimaryKey(cart.getpId());
                        ;
                        cart.getNum();
                        double total = cart.getNum() * product.getpPrice();
//						System.out.println(total);
                        sumtotal += total;
                        System.out.println(total);
                        ShopOrderitem item = new ShopOrderitem();
                        item.setOiCount(cart.getNum());
                        item.setSubtotal(total);
                        item.setpId(cart.getpId());
                        item.setoId(oderid);
                        orderitemMapper.insertSelective(item);
                    }
                    ShopOrders o = new ShopOrders();
                    o.setoId(oderid);
                    o.setOrdertime(sf.format(d));
                    o.setuId(uId);
//					o.setPhone(address.getaTel());
//					o.setoAddress(address.getaProvice()+address.getaCity()+address.getaArea()+address.getaAddress());
//					o.setoOrdernum( new SimpleDateFormat("yyyyMMddHHmmss").format(d)+PayUtil.createCode(6));
                    o.setoIsshow(false);
                    o.setoState(1);
                    o.setTotal(sumtotal);
                    System.out.println(sumtotal);
                    int a = ordersMapper.insertSelective(o);
                    if (a > 0) {
                        cartMapper.deleteByExample(example);
                    }
                }
            }
        } catch (Exception e) {
            return WxResult.fail("操作失败!");
        }
        return WxResult.build(200, "成功！", map);
    }

    @Override
    public WxResult getOrederByOid(int oId, HttpServletRequest request) {
        String strDirPath = request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort();
        ShopOrders orders;
        try {
            orders = ordersMapper.selectByPrimaryKey(oId);
            ShopOrderitemExample example = new ShopOrderitemExample();
            ShopOrderitemExample.Criteria criteria = example.createCriteria();
            criteria.andOIdEqualTo(oId);

            List<ShopOrderitem> list = orderitemMapper.getItemList(oId);
            for (ShopOrderitem shopOrderitem : list) {
                shopOrderitem.setpImage(strDirPath + "/ssm/file/showPic?fileName=" + shopOrderitem.getpImage());
            }
            orders.setList(list);
        } catch (Exception e) {
            return WxResult.build(400, "操作异常");
        }
        return WxResult.ok(orders);
    }

    @Override
    public WxResult addOrderSimple(int pId, int uId, int type, int count,int sbId) {
        if (pId == 0 || count == 0) {
            return WxResult.fail("参数不能为空！");
        }

        Date d = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Map map = new HashMap();

        try {
if(sbId==0){
    ShopProduct product = productMapper.selectByPrimaryKey(pId);
//			Address address=addressMapper.selectByPrimaryKey(aId);
    double total = count * product.getpPrice();

    int oderid = (int) (Math.random() * 100000000);
    map.put("orderid", oderid);
    ShopOrders o = new ShopOrders();
    o.setoId(oderid);
    o.setOrdertime(sf.format(d));
    if (uId != 0) {
        o.setuId(uId);
    }
//			o.setPhone(address.getaTel());
//			o.setoAddress(address.getaProvice()+address.getaCity()+address.getaArea()+address.getaAddress());
    o.setoState(1);
    o.setoIsshow(false);
    o.setTotal(total);
    int a = ordersMapper.insertSelective(o);
    if (a > 0) {
        ShopOrderitem item = new ShopOrderitem();
        item.setOiCount(count);
        item.setSubtotal(total);
        item.setpId(pId);
        item.setoId(oderid);
        item.setR1(type + "");
        item.setR2(sf.format(d));
        orderitemMapper.insertSelective(item);
    }
}else{
    PsbExample psbExample = new PsbExample();
    PsbExample.Criteria criteria = psbExample.createCriteria();
    criteria.andSbidEqualTo(Long.valueOf(sbId));
    criteria.andPIdEqualTo(pId);
    List<Psb> psbs = psbMapper.selectByExample(psbExample);
    if(!psbs.isEmpty()){

        Double psbPrices =psbs.get(0).getPsbPrices();
        if(psbPrices==null){
            ShopProduct shopProduct = productMapper.selectByPrimaryKey(psbs.get(0).getpId());
             psbPrices = shopProduct.getpPrice();
        }else{
             psbPrices = psbs.get(0).getPsbPrices();
        }
        double total = count *psbPrices;
        int oderid = (int) (Math.random() * 100000000);
        map.put("orderid", oderid);
        ShopOrders o = new ShopOrders();
        o.setoId(oderid);
        o.setOrdertime(sf.format(d));
        if (uId != 0) {
            o.setuId(uId);
        }
//			o.setPhone(address.getaTel());
//			o.setoAddress(address.getaProvice()+address.getaCity()+address.getaArea()+address.getaAddress());
        o.setoState(1);
        o.setoIsshow(false);
        o.setTotal(total);
        int a = ordersMapper.insertSelective(o);
        if (a > 0) {
            ShopOrderitem item = new ShopOrderitem();
            item.setOiCount(count);
            item.setSubtotal(total);
            item.setpId(pId);
            item.setoId(oderid);
            item.setR1(type + "");
            item.setR2(sf.format(d));
            orderitemMapper.insertSelective(item);
        }
    }


}

        } catch (Exception e) {
            return WxResult.fail("操作异常！");
        }
        return WxResult.build(200, "成功！", map);
    }

    @Override
    public WxResult addOrderAddress(int oId, int aId) {
        Map map;
        try {
            map = new HashMap();
            Date d = new Date();
            ShopAddress address = addressMapper.selectByPrimaryKey(aId);
            String odrnum = new SimpleDateFormat("yyyyMMddHHmmss").format(d) + PayUtil.createCode(6);
            ShopOrders o = new ShopOrders();
            o.setoId(oId);
            o.setoIsshow(true);
            o.setoOrdernum(odrnum);
            o.setPhone(address.getaTel());
            o.setuName(address.getaName());
            o.setoAddress(address.getaProvice() + address.getaCity() + address.getaArea() + address.getaAddress());

            /*ShopDistributorExample example=new ShopDistributorExample();
            int uid=ordersMapper.selectByPrimaryKey(oId).getuId();
            int comId=userMapper.selectByPrimaryKey(uid).getComId();
            System.out.println(comId);
            example.createCriteria().andComIdEqualTo(comId);
            ShopDistributor distributor=distributorMapper.selectByExample(example).get(0);
            o.setdId(distributor.getdId());*/
            ordersMapper.updateByPrimaryKeySelective(o);
            map.put("odrnum", odrnum);
        } catch (Exception e) {
            return WxResult.fail("操作失败");
        }
        return WxResult.build(200, "成功！", map);
    }

    @Override
    public WxResult getOrderByUser(int uId, int oState, HttpServletRequest request) {
        ShopOrdersExample example1 = new ShopOrdersExample();
        example1.setOrderByClause("ordertime desc");
        ShopOrdersExample.Criteria createCriteria = example1.createCriteria();
        createCriteria.andUIdEqualTo(uId);
        createCriteria.andOIsshowEqualTo(true);
        if (oState != 0) {
            createCriteria.andOStateEqualTo(oState);
        }
        List<ShopOrders> list = ordersMapper.selectByExample(example1);
        for (ShopOrders o : list) {
            List<ShopOrderitem> itemlist = orderitemMapper.getItemList(o.getoId());
            String saveUrl = request.getScheme() + "://" + request.getServerName() + ":" +
                    request.getServerPort() + "/ssm/file/showPic?fileName=";
            for (ShopOrderitem shopOrderitem : itemlist) {
                shopOrderitem.setpImage(saveUrl + shopOrderitem.getpImage());
            }
            if (itemlist.size() > 0 && itemlist != null) {
                o.setList(itemlist);
            }
        }
        return WxResult.ok(list);
    }

    @Override
    public ShopOrders selOrderById(Integer id) {
        return ordersMapper.selectByPrimaryKey(id);
    }

    @Override
    public ResultUtil getOrdersList(Integer page, Integer limit, ShopOrders search) {
        PageHelper.startPage(page, limit);
        ShopOrdersExample example = new ShopOrdersExample();
        example.setOrderByClause("ordertime desc");
        ShopOrdersExample.Criteria criteria = example.createCriteria();
        if (search.getPhone() != null && !"".equals(search.getPhone())) {
            criteria.andPhoneLike("%" + search.getPhone() + "%");
        }
        if (search.getoState() != null && search.getoState() != -1) {

            criteria.andOStateEqualTo(search.getoState());
        }
        if (search.getCreateTimeStart() != null && !"".equals(search.getCreateTimeStart())) {
            criteria.andOrdertimeLessThanOrEqualTo(search.getCreateTimeStart());
        }
        if (search.getCreateTimeEnd() != null && !"".equals(search.getCreateTimeEnd())) {
            criteria.andOrdertimeLessThanOrEqualTo(search.getCreateTimeEnd());
        }
        List<ShopOrders> list = ordersMapper.selectByExample(example);
        for (ShopOrders orders : list) {
            ShopOrderitemExample shopOrderitemExample= new ShopOrderitemExample();
            ShopOrderitemExample.Criteria criteria1riteria= shopOrderitemExample.createCriteria();
            criteria1riteria.andOIdEqualTo(orders.getoId());
            List<ShopOrderitem> shopOrderitems=  orderitemMapper.selectByExample(shopOrderitemExample);
           if(!shopOrderitems.isEmpty()){
               ShopOrderitem shopOrderitem = shopOrderitems.get(0);
               Integer integer = shopOrderitem.getpId();

               ShopProduct ShopProduct  =  productMapper.selectByPrimaryKey(integer);
               orders.setRemark(String.valueOf( ShopProduct.getpValidity()));
           }

            Users users = usersMapper.selectByPrimaryKey(orders.getuId());

            if (users != null) {
                orders.setuName(users.getuName());
            }

            String money = orders.getMoney();
            Double total = orders.getTotal();
            if(money!=null&&total!=null){
                double v = Double.parseDouble(money);


                BigDecimal b1 = new BigDecimal(v);
                BigDecimal b2 = new BigDecimal(total);
                double subtract = b2.subtract(b1).doubleValue();
                orders.setYhmoney(subtract);
                //String str = String.valueOf(b6);
            }else{
                orders.setYhmoney(null);
            }



        }
        PageInfo<ShopOrders> pageInfo = new PageInfo<>(list);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public void delOrders(String userStr) {
        String[] users = userStr.split(",");
        List<Integer> oIds = new ArrayList<Integer>();
        if (users != null && users.length > 0) {
            for (String uid : users) {
                oIds.add(Integer.valueOf(uid));


            }
        }
        ShopOrdersExample example = new ShopOrdersExample();
        ShopOrdersExample.Criteria criteria = example.createCriteria();
        criteria.andOIdIn(oIds);
        ordersMapper.deleteByExample(example);
    }

    @Override
    public void delOrderByOid(String oId) {
        ordersMapper.deleteByPrimaryKey(Integer.parseInt(oId));
    }

    @Override
    public void updateOStatus(String oId) {
        ShopOrders orders = ordersMapper.selectByPrimaryKey(Integer.parseInt(oId));
        orders.setoState(3);
        ordersMapper.updateByPrimaryKeySelective(orders);
    }

    @Override
    public ResultUtil getOrderItemList(Integer page, Integer limit, ShopOrderitem search) {
        PageHelper.startPage(page, limit);
        ShopOrderitemExample example = new ShopOrderitemExample();
        example.setOrderByClause("oi_id desc");
        ShopOrderitemExample.Criteria criteria = example.createCriteria();
        criteria.andOIdEqualTo(search.getoId());
        List<ShopOrderitem> list = orderitemMapper.selectByExample(example);
        for (ShopOrderitem shopOrderitem : list) {
            System.out.println(shopOrderitem.getR1());
//            if (shopOrderitem.getR1().equals("1")) {
            ShopProduct product = productMapper.selectByPrimaryKey(shopOrderitem.getpId());
            shopOrderitem.setpName(product.getpName());
            if (product.getcId() != null && !product.getcId().equals("null")) {
                ShopCategory category = categoryMapper.selectByPrimaryKey(product.getcId());
                shopOrderitem.setcName(category.getcName());
            } else {
                shopOrderitem.setcName("暂无");
            }
           /* } else {
                ProductItem productItem=productItemMapper.selectByPrimaryKey(shopOrderitem.getpId());
                if (productItem != null) {
                    shopOrderitem.setpName(productItem.getiName());
                }
            }*/
        }
        PageInfo<ShopOrderitem> pageInfo = new PageInfo<>(list);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public void delOrderItem(String userStr) {
        String[] users = userStr.split(",");
        List<Integer> oIds = new ArrayList<Integer>();
        if (users != null && users.length > 0) {
            for (String uid : users) {
                oIds.add(Integer.valueOf(uid));
            }
        }
        ShopOrderitemExample example = new ShopOrderitemExample();
        ShopOrderitemExample.Criteria criteria = example.createCriteria();
        criteria.andOiIdIn(oIds);
        orderitemMapper.deleteByExample(example);
    }

    @Override
    public void delOrderItemByOid(String oId) {
        orderitemMapper.deleteByPrimaryKey(Integer.parseInt(oId));
    }

    @Override
    public WxResult updateOrderStatus(ShopOrders orders) {
        System.out.println(orders.getoOrdernum());
        try {
            ShopOrdersExample example = new ShopOrdersExample();
            ShopOrdersExample.Criteria criteria = example.createCriteria();
            if (orders.getoOrdernum() != null) {
                criteria.andOOrdernumEqualTo(orders.getoOrdernum());
            }
            if (orders.getoId() != null) {
                criteria.andOIdEqualTo(orders.getoId());
            }

            ordersMapper.updateByExampleSelective(orders, example);
        } catch (Exception e) {
            return WxResult.build(400, "操作异常");
        }
        return WxResult.build(200, "成功");
    }

    @Override
    public WxResult delOrder(int oId) {
        try {
            ShopOrderitemExample example = new ShopOrderitemExample();
            example.createCriteria().andOIdEqualTo(oId);
            orderitemMapper.deleteByExample(example);
            ordersMapper.deleteByPrimaryKey(oId);
        } catch (Exception e) {
            return WxResult.fail("操作异常！");
        }
        return WxResult.build(200, "请求成功！");
    }

    @Override
    public ResultUtil getIndex() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String todaytime = df.format(new Date());
        Map map = new HashMap();
        //累计总收入
        Double subtotal = ordersMapper.sumTotal();
        //String format = new DecimalFormat("#.00").format(subtotal);
        BigDecimal b = new BigDecimal(subtotal);
        double f1 = b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        String subtotalstr = "";
        if (subtotal == null || "".equals(subtotal)) {
            subtotalstr = 0.0 + "";
        } else {
           // subtotalstr = String.valueOf(subtotal);
            subtotalstr = String.valueOf(f1);
        }
        map.put("subtotal", subtotalstr);
        //今日收入
        Double todayTotal = ordersMapper.Today(todaytime+"%");
       // String format2 = new DecimalFormat("#.00").format(todayTotal);
        if(todayTotal==null){
            todayTotal=0.0;
        }
        BigDecimal b1 = new BigDecimal(todayTotal);
        double f2 = b1.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        String todayTotalstr = "";
        if (todayTotal == null || "".equals(todayTotal)) {
            todayTotalstr = 0.0 + "";
        } else {
            //todayTotalstr = String.valueOf(todayTotal);
            todayTotalstr = String.valueOf(f2);
        }
        map.put("todayTotal", todayTotalstr);
        //今日新增用户
        UsersExample example = new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();
//        criteria.andUCreatetimeLike(todaytime);
        criteria.andUCreatetimeLike("%"+todaytime+"%");
        List<Users> users = usersMapper.selectByExample(example);
        map.put("todayuser", users.size());
        return ResultUtil.ok(map);
    }

    @Override
    public String selMoneyByOrdernum(String prices, String ordernum) {
        ShopOrdersExample shopOrdersExample = new ShopOrdersExample();
        ShopOrdersExample.Criteria criteria = shopOrdersExample.createCriteria();
        criteria.andOOrdernumEqualTo(ordernum);
        List<ShopOrders> list = ordersMapper.selectByExample(shopOrdersExample);
        ShopOrders ShopOrders = list.get(0);
        ShopOrderitemExample shopOrderitemExample = new ShopOrderitemExample();
        ShopOrderitemExample.Criteria criteria2 = shopOrderitemExample.createCriteria();
        criteria2.andOIdEqualTo(list.get(0).getoId());
        List<ShopOrderitem> orderslist = orderitemMapper.selectByExample(shopOrderitemExample);
 double num = 0;
        for (ShopOrderitem shopOrderitem : orderslist) {
            ShopProduct shopProduct = productMapper.selectByPrimaryKey(shopOrderitem.getpId());
            if (shopProduct.getpValidity() == 3) {
                double mon1 = shopOrderitem.getSubtotal();
                num += mon1;
                //return String.valueOf(num);
            } else {
                Users user = usersMapper.selectByPrimaryKey(list.get(0).getuId());

                Level level = levelMapper.selectByPrimaryKey(user.getuLevel());
                String dz = level.getLeDiscount();
                System.out.println("=================" + dz);
                //double a=Double.parseDouble(dz);
                // int a=Integer.parseInt(dz);
                if (dz.equals("10")) {
                    // return String.valueOf(0);
                    double mon = shopOrderitem.getSubtotal();
                    num += mon;
                    System.out.println("=-================================================十折" + num);
                    // String.valueOf(num);

                } else if (dz.equals("0")) {
                    num += 0.01;
                    //return String.valueOf(0.01);
                } else {
                    double mon = shopOrderitem.getSubtotal();

                    BigDecimal b1 = new BigDecimal(dz);
                    BigDecimal b2 = new BigDecimal(10);
                    double b3 = b1.divide(b2, 2, BigDecimal.ROUND_HALF_UP).doubleValue();
                    BigDecimal b4 = new BigDecimal(b3);
                    BigDecimal b5 = new BigDecimal(mon);
                    double b6 = b4.multiply(b5).setScale(2, RoundingMode.HALF_EVEN).doubleValue();//
                   // String str = String.valueOf(b6);

                    if (b6==0 || b6==0.0) {
                        num += mon;
                        System.out.println("=======================================1到9折=0" + num);

                       // return String.valueOf(num);
                    } else {
                        num += b6;
                        System.out.println("=======================================1到9折" + num);
                       // return str;
                    }

                }

            }

        }
return String.valueOf(num);
    }

    @Override
    public String selMoneyByOrdernum2(String ordernum) {
        ShopOrdersExample shopOrdersExample = new ShopOrdersExample();
        ShopOrdersExample.Criteria criteria = shopOrdersExample.createCriteria();
        criteria.andOOrdernumEqualTo(ordernum);
        List<ShopOrders> list = ordersMapper.selectByExample(shopOrdersExample);
        ShopOrders ShopOrders = list.get(0);
        ShopOrderitemExample shopOrderitemExample = new ShopOrderitemExample();
        ShopOrderitemExample.Criteria criteria2 = shopOrderitemExample.createCriteria();
        criteria2.andOIdEqualTo(list.get(0).getoId());
        List<ShopOrderitem> orderslist = orderitemMapper.selectByExample(shopOrderitemExample);
        double num = 0;
        for (ShopOrderitem shopOrderitem : orderslist) {
            num = shopOrderitem.getSubtotal();
        }



        return String.valueOf(num);
    }

}
