package com.irs.controller;
import com.irs.annotation.MyException;
import com.irs.pojo.*;
import com.irs.service.*;
import com.irs.test.WarTest;
import com.irs.util.*;
import org.apache.commons.io.IOUtils;
import org.jdom2.JDOMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.util.*;

//import com.alipay.api.domain.Product;

@Controller
@RequestMapping("front")
public class CommonController {

    public static void main(String[] args) {
        System.out.println("jhsiofhiahfaisfifi");
    }

    @Autowired
    private SubareaService subareaService;
    @Autowired
    private CarouselService carouselService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private BrowseService browseService;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private RechargeService rechargeService;

    @Autowired
    private PictureService pictureService;

    @Autowired
    private GroupsProductService groupsProductService;

    @Autowired
    private GroupsBillService billService;

    @Autowired
    private SpikeService spikeService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private ShopProductCollectionService productCollectionService;

    @Autowired
    private IntegralUseService integralUseService;

    @Autowired
    private RefundService refundService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private TdCodeService tdCodeService;

    @Autowired
    private CustomerService customerService;

    @ResponseBody
    @RequestMapping(value = "/getAllPic", produces = "text/plain;charset=utf-8")
    public String getAllPic(String callback, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        WxResult result = carouselService.getAllPic(request);
        return JsonUtils.objectToJson(result);
    }

    @ResponseBody
    @RequestMapping(value = "/getOneImage", produces = "text/plain;charset=utf-8")
    public String getOneImage(String callback, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        WxResult result = tdCodeService.getOneImage(request);
        return JsonUtils.objectToJson(result);
    }

    @ResponseBody
    @RequestMapping(value = "/getAllCategory", produces = "text/plain;charset=utf-8")
    public String getAllCategory(String callback, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        WxResult result = categoryService.getAllCategory(request);
        return JsonUtils.objectToJson(result);
    }


    /**
     * 热销商品
     *
     * @param callback
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getHotProduct", produces = "text/plain;charset=utf-8")
    public String getHotProduct(String callback, HttpServletResponse response,
                                @RequestParam("page") Integer page,
                                @RequestParam("limit") Integer limit,
                                @RequestParam(value = "pValidity", defaultValue = "4") int pValidity) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        WxResult result = productService.getHotProduct(request, page, limit, pValidity);
        return JsonUtils.objectToJson(result);
    }


    /**
     * 推荐商品
     *
     * @param callback
     * @param callback
     * @param //uid
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getRecommendProduct", produces = "text/plain;charset=utf-8")
    public String getRecommendProduct(String callback, HttpServletResponse response,
                                      @RequestParam("page") Integer page,
                                      @RequestParam("limit") Integer limit,
                                      @RequestParam(value = "pValidity", defaultValue = "4") int pValidity) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        WxResult result = productService.getRecommendProduct(request, page, limit, pValidity);
        return JsonUtils.objectToJson(result);
    }

    /**
     * 其他商品
     *
     * @param callback
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getTopProduct", produces = "text/plain;charset=utf-8")
    public String getTopProduct(String callback, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        WxResult result = productService.getTopProduct(request);
        return JsonUtils.objectToJson(result);
    }


    @ResponseBody
    @RequestMapping(value = "/getCart", produces = "text/plain;charset=utf-8", method = RequestMethod.POST)
    public String getCart(String callback, @RequestParam(value = "uId", defaultValue = "0") int uId, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
//		WxResult w=cartService.addCart(cart);
        return JsonUtils.objectToJson(cartService.getCart(uId, request));
    }

    /**
     * 搜索商品
     *
     * @param callback
     * @param key
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getProductBySearch", produces = "text/plain;charset=utf-8")
    public String getProductBySearch(String callback, @RequestParam(value = "key", defaultValue = "") String key, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        WxResult result = productService.getProductBySearch(key, request);
        return JsonUtils.objectToJson(result);
    }

    /**
     * 获取用户基本信息
     *
     * @param callback
     * @param uId      当前登陆用户的编号
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getUserById", produces = "text/plain;charset=utf-8")
    public String getUserById(String callback, @RequestParam(value = "uId", defaultValue = "0") int uId,
                              HttpServletResponse response,
                              HttpServletRequest request) {
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Origin", "*");
        //Map<String, String[]> parameterMap = request.getParameterMap();

        HttpSession session = request.getSession();
        try {
            int account = (int) session.getAttribute("uid");
            System.out.println("session中的用户id是：" + account);
        } catch (Exception e) {
            List<Users> usersList = new ArrayList<>();
            WxResult result = WxResult.build(204, "请先登录", usersList);
            return JsonUtils.objectToJson(result);
        }
        WxResult result = usersService.getUserById(uId);

        return JsonUtils.objectToJson(result);
    }

    /**
     * 获取用户基本信息PC
     *
     * @param //callback
     * @param //uId      当前登陆用户的编号
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getUserByIdPC", produces = "text/plain;charset=utf-8")
    public String getUserById(String callback,
                              @RequestParam(value = "token") String token,
                              HttpServletResponse response,
                              HttpServletRequest request) {
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Origin", "*");
        HttpSession session = request.getSession();
        /*try {
            int account = (int) session.getAttribute("uid");
            System.out.println("session中的用户id是："+account);
        }catch (Exception e){
            List<Users> usersList=new ArrayList<>();
            WxResult result=WxResult.build(204,"请先登录",usersList);
            return JsonUtils.objectToJson(result);
        }*/
        WxResult userByIdPC = usersService.getUserByIdPC(token);

        return JsonUtils.objectToJson(userByIdPC);
    }

    /**
     * 加入购物车
     *
     * @param callback
     * @param cart
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addCart", produces = "text/plain;charset=utf-8", method = RequestMethod.POST)
    public String addCart(String callback, ShopCart cart, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
//		WxResult w=cartService.addCart(cart);
        return JsonUtils.objectToJson(cartService.addCart(cart));
    }

    /**
     * 商品详情
     *
     * @param callback
     * @param pId
     * @param uId
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getProductByPid", produces = "text/plain;charset=utf-8")
    public String getProductByPid(String callback,
                                  @RequestParam(value = "pId", defaultValue = "0") int pId,
                                  @RequestParam(value = "uId", defaultValue = "0") int uId,
                                  @RequestParam(value = "sbId", defaultValue = "0") int sbId,
                                  HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        WxResult result = productService.getProductByPid(pId, uId, sbId, request);
        return JsonUtils.objectToJson(result);
    }

    /**
     * 添加预览
     *
     * @param callback
     * @param browse   uId  pId
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addBrowse", produces = "text/plain;charset=utf-8", method = RequestMethod.POST)
    public String addBrowse(String callback, ShopBrowse browse, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        WxResult result = browseService.addBrowse(browse);
        return JsonUtils.objectToJson(result);
    }

    /**
     * @param callback
     * @param uId
     * @param //aId
     * @param cidlist
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addOrderByCart", produces = "text/plain;charset=utf-8", method = RequestMethod.POST)
    public String addOrderByCart(String callback, @RequestParam(value = "uId", defaultValue = "0") int uId,
                                 String cidlist,
                                 HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        WxResult result = ordersService.addOrderByCart(uId, cidlist);
        return JsonUtils.objectToJson(result);
    }

    /**
     * 根据类别搜索商品
     *
     * @param callback
     * @param start
     * @param length
     * @param cId
     * @param orders
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getProductByCategory", produces = "text/plain;charset=utf-8")
    public String getProductByCategory(String callback, Integer start, Integer length, @RequestParam(value = "cId", defaultValue = "0") int cId, @RequestParam(value = "orders", defaultValue = "0") int orders, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");

        WxResult result = productService.getProductByCategory(start, length, cId, orders, request);
        return JsonUtils.objectToJson(result);
    }

    /**
     * 通过订单编号获取订单详情
     *
     * @param callback
     * @param oId
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getOrederByOid", produces = "text/plain;charset=utf-8")
    public String getOrederByOid(String callback,
                                 @RequestParam(value = "oId", defaultValue = "0") int oId, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        WxResult result = ordersService.getOrederByOid(oId, request);
        return JsonUtils.objectToJson(result);
    }

    /**
     * 获取用户收货地址
     *
     * @param //       callback
     * @param uId
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getAddressByUser", produces = "text/plain;charset=utf-8")
    public String getAddressByUser(@RequestParam(value = "uId", defaultValue = "0") int uId, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        WxResult result = addressService.getAddressByUser(uId);
        return JsonUtils.objectToJson(result);
    }

    /**
     * 添加收货地址
     *
     * @param callback
     * @param address
     * @param response
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "/addAddress", produces = "text/plain;charset=utf-8", method = RequestMethod.POST)
    public String addAddress(String callback, ShopAddress address, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        WxResult result = addressService.addAddress(address);
        return JsonUtils.objectToJson(result);
    }

    /**
     * 编辑收货地址�޸
     *
     * @param callback
     * @param address
     * @param response
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "/editAddress", produces = "text/plain;charset=utf-8", method = RequestMethod.POST)
    public String editUserInfo(String callback, ShopAddress address, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        WxResult result = addressService.editAddress(address);
        return JsonUtils.objectToJson(result);
    }

    /**
     * 删除收货地址
     *
     * @param callback
     * @param aId
     * @param response
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "/delAddress", produces = "text/plain;charset=utf-8", method = RequestMethod.POST)
    public String delAddress(String callback, @RequestParam(value = "aId", defaultValue = "0") int aId, @RequestParam(value = "uId", defaultValue = "0") int uId, @RequestParam(value = "aStatus", defaultValue = "0") int aStatus, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        WxResult result = addressService.delAddress(aId, aStatus, uId);
        return JsonUtils.objectToJson(result);
    }

    /**
     * @param callback
     * @param uId
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getDefaultAddress", produces = "text/plain;charset=utf-8")
    public String getDefaultAddress(String callback, @RequestParam(value = "uId", defaultValue = "0") int uId, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        WxResult result = addressService.getDefaultAddress(uId);
        return JsonUtils.objectToJson(result);
    }

    @ResponseBody
    @RequestMapping(value = "/getRechargeByUser", produces = "text/plain;charset=utf-8")
    public String getRechargeByUser(String callback, @RequestParam(value = "uId", defaultValue = "0") int uId, @RequestParam(value = "type", defaultValue = "0") int type, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        WxResult result = rechargeService.getRechargeByUser(uId, type);
        return JsonUtils.objectToJson(result);
    }

    /**
     * 用户浏览足迹
     *
     * @param callback
     * @param uId
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getBrowseList", produces = "text/plain;charset=utf-8")
    public String getBrowseList(String callback, @RequestParam(value = "uId", defaultValue = "0") int uId,
                                @RequestParam(value = "start", defaultValue = "0") Integer start,
                                @RequestParam(value = "length", defaultValue = "0") Integer length,
                                HttpServletResponse response, HttpServletRequest request) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        WxResult result = productService.getBrowseList(uId, start, length, request);
        System.out.println(result.toString());
        return JsonUtils.objectToJson(result);
    }

    /**
     * 直接购买 生成订单
     *
     * @param callback
     * @param pId
     * @param uId
     * @param //aId
     * @param count
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addOrderSimple", produces = "text/plain;charset=utf-8", method = RequestMethod.POST)
    public String addOrderSimple(String callback,
                                 @RequestParam(value = "pId", defaultValue = "0") int pId,
                                 @RequestParam(value = "uId", defaultValue = "0") int uId,
                                 @RequestParam(value = "type", defaultValue = "0") int type,
                                 @RequestParam(value = "count", defaultValue = "0") int count,
                                 @RequestParam(value = "sbId", defaultValue = "0") int sbId,
                                 HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        WxResult result = ordersService.addOrderSimple(pId, uId, type, count, sbId);
        return JsonUtils.objectToJson(result);
    }

    /**
     * 给订单加上地址
     *
     * @param callback
     * @param oId
     * @param aId
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addOrderAddress", produces = "text/plain;charset=utf-8", method = RequestMethod.POST)
    public String addOrderAddress(String callback, @RequestParam(value = "oId", defaultValue = "0") int oId, @RequestParam(value = "aId", defaultValue = "0") int aId,
                                  HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        WxResult result = ordersService.addOrderAddress(oId, aId);
        System.out.println("------------" + oId + "--------" + aId);

        return JsonUtils.objectToJson(result);
    }

    /**
     * 通过用户id 获取 订单列表
     *
     * @param callback
     * @param uId
     * @param oState
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getOrderByUser", produces = "text/plain;charset=utf-8")
    public String getOrderByUser(String callback,
                                 @RequestParam(value = "uId", defaultValue = "0") int uId, @RequestParam(value = "oState", defaultValue = "0") int oState, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        WxResult result = ordersService.getOrderByUser(uId, oState, request);
        return JsonUtils.objectToJson(result);
    }

    /**
     * 修改用户信息
     *
     * @param callback
     * @param user
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editUserInfo", produces = "text/plain;charset=utf-8", method = RequestMethod.POST)
    public String editUserInfo(String callback, Users user, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        WxResult result = usersService.editUserInfo(user);
        return JsonUtils.objectToJson(result);
    }

    /**
     * 退出登录
     *
     * @param //uId
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/logout", produces = "text/plain;charset=utf-8")
    public String logout(HttpServletResponse response, HttpServletRequest request) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        HttpSession session = request.getSession();
        session.removeAttribute("uid");
        return JsonUtils.objectToJson(WxResult.ok("退出成功"));
    }


    /**
     * 播放视频前 判断是否都登录
     *
     * @param //fileName
     * @param //uId
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/player", produces = "text/plain;charset=utf-8")
    public String player(HttpServletRequest request, HttpServletResponse response,
                         @RequestParam(value = "fileName", defaultValue = "0") String fileName2,
                         @RequestParam(value = "uId", defaultValue = "0") String uid,
                         @RequestParam(value = "pId", defaultValue = "0") String pId) {
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Origin", "*");
//        String result = "";
//        String saveUrl=request.getScheme() + "://"+request.getServerName()+":" +
//                request.getServerPort();
//        //查询此用户是否购买了此视频
//        result = saveUrl+"/ssm/front/player2?fileName2="+fileName2+"&uId="+uid;
//        Map map=new HashMap();
//        map.put("result",result);
//        return JsonUtils.objectToJson(WxResult.ok(map));
        String result = "";
        HttpSession session = request.getSession();
        Map map = new HashMap();
        int sessionuid = 0;
        try {
            //根据pId查询是否为免费课程
            ShopProduct product = productService.selProductBypid(Integer.valueOf(pId));
//            System.out.println(pr);


            if (product.getpIsfee().equals(0)) {
                String saveUrl = request.getScheme() + "://" + request.getServerName() + ":" +
                        request.getServerPort();
                //查询此用户是否购买了此视频
                result = saveUrl + "/ssm/front/player2?fileName2=" + fileName2 + "&uId=" + uid + "&pId=" + pId;
                map.put("result", result);
                return JsonUtils.objectToJson(WxResult.ok(map));
            }
            System.out.println(session.getAttribute("uid"));
            sessionuid = (int) session.getAttribute("uid");

        } catch (Exception e) {
            e.printStackTrace();
            return JsonUtils.objectToJson(WxResult.build(204, "请先登陆"));
        }

        if (sessionuid == 0) {
            result = "请先登录";
            return JsonUtils.objectToJson(WxResult.build(204, result));
        } else {
            //如果session中的用户id和传过来的用户id一致
            if (sessionuid == Integer.parseInt(uid)) {
                ShopRecharge recharge = rechargeService.selectByUid(Integer.parseInt(uid), fileName2, pId);
                if (recharge == null) {
                    return JsonUtils.objectToJson(WxResult.build(206, "请先购买"));
                }
                try {
                    String saveUrl = request.getScheme() + "://" + request.getServerName() + ":" +
                            request.getServerPort();
                    //查询此用户是否购买了此视频
                    result = saveUrl + "/ssm/front/player2?fileName2=" + fileName2 + "&uId=" + uid + "&pId=" + pId;

                    map.put("result", result);
                    //player2(request,response,fileName2,uid);
                } catch (MyException e) {
                    result = (String) e.getExceptionData();
                }
                return JsonUtils.objectToJson(WxResult.ok(map));
            } else {
                //如果不一致去登录
                return JsonUtils.objectToJson(
                        WxResult.build(204, result));
            }
        }
    }

    /**
     * 视频分段播放
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/player2", produces = "text/plain;charset=utf-8", method = RequestMethod.GET)
    public void player2(HttpServletRequest request, HttpServletResponse response, String fileName2,
                        @RequestParam(value = "uId", defaultValue = "0") String uid,
                        @RequestParam(value = "pId", defaultValue = "0") String pId) {
        response.addHeader("Access-Control-Allow-Origin", "*");

        HttpSession session = request.getSession();
        int sessionuid = 0;
        try {
            sessionuid = (int) session.getAttribute("uid");
            //sessionuid=195;
            System.out.println(sessionuid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //ShopRecharge s=rechargeService.selectByUid(Integer.parseInt(uid),fileName2,pId);
        ShopProduct product = productService.selProductBypid(Integer.valueOf(pId));

        if (product.getpIsfee().equals(0) || sessionuid == Integer.valueOf(uid)) {
            if (product.getpIsfee().equals(1)) {
                ShopRecharge recharge = rechargeService.selectByUid(Integer.parseInt(uid), fileName2, pId);

                if (recharge == null) {
                    MyException myException = new MyException();
                    myException.setData("请先购买");
                    throw myException;
                }
            }
            //根据传过来的文件名获取到文件路径
            String path = "C:/upload/" + fileName2;
            BufferedInputStream bis = null;
            OutputStream out = null;
            try {
                File file = new File(path);
                if (file.exists()) {
                    long p = 0L;
                    long toLength = 0L;
                    long contentLength = 0L;
                    int rangeSwitch = 0; // 0,从头开始的全文下载；1,从某字节开始的下载（bytes=27000-）；2,从某字节开始到某字节结束的下载（bytes=27000-39000）
                    long fileLength;
                    String rangBytes = "";
                    fileLength = file.length();
                    // get file content
                    InputStream ins = new FileInputStream(file);
                    bis = new BufferedInputStream(ins);
                    // tell the client to allow accept-ranges
                    response.reset();
                    response.setHeader("Accept-Ranges", "bytes");
                    // client requests a file block download start byte
                    String range = request.getHeader("Range");
                    if (range != null && range.trim().length() > 0 && !"null".equals(range)) {
                        response.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);
                        rangBytes = range.replaceAll("bytes=", "");
                        if (rangBytes.endsWith("-")) { // bytes=270000-
                            rangeSwitch = 1;
                            p = Long.parseLong(rangBytes.substring(0, rangBytes.indexOf("-")));
                            contentLength = fileLength - p; // 客户端请求的是270000之后的字节（包括bytes下标索引为270000的字节）
                        } else { // bytes=270000-320000
                            rangeSwitch = 2;
                            String temp1 = rangBytes.substring(0, rangBytes.indexOf("-"));
                            String temp2 = rangBytes.substring(rangBytes.indexOf("-") + 1, rangBytes.length());
                            p = Long.parseLong(temp1);
                            toLength = Long.parseLong(temp2);
                            contentLength = toLength - p + 1; // 客户端请求的是 270000-320000 之间的字节
                        }
                    } else {
                        contentLength = fileLength;
                    }
                    // 如果设设置了Content-Length，则客户端会自动进行多线程下载。如果不希望支持多线程，则不要设置这个参数。
                    // Content-Length: [文件的总大小] - [客户端请求的下载的文件块的开始字节]
                    response.setHeader("Content-Length", new Long(contentLength).toString());
                    // 断点开始
                    // 响应的格式是:
                    // Content-Range: bytes [文件块的开始字节]-[文件的总大小 - 1]/[文件的总大小]
                    if (rangeSwitch == 1) {
                        String contentRange = new StringBuffer("bytes ").append(new Long(p).toString()).append("-")
                                .append(new Long(fileLength - 1).toString()).append("/")
                                .append(new Long(fileLength).toString()).toString();
                        response.setHeader("Content-Range", contentRange);
                        bis.skip(p);
                    } else if (rangeSwitch == 2) {
                        String contentRange = range.replace("=", " ") + "/" + new Long(fileLength).toString();
                        response.setHeader("Content-Range", contentRange);
                        bis.skip(p);
                    } else {
                        String contentRange = new StringBuffer("bytes ").append("0-").append(fileLength - 1).append("/")
                                .append(fileLength).toString();
                        response.setHeader("Content-Range", contentRange);
                    }
                    String fileName = file.getName();
                    response.setContentType("application/octet-stream");
                    response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
                    out = response.getOutputStream();
                    int n = 0;
                    long readLength = 0;
                    int bsize = 1024;
                    byte[] bytes = new byte[bsize];
                    if (rangeSwitch == 2) {
                        // 针对 bytes=27000-39000 的请求，从27000开始写数据
                        while (readLength <= contentLength - bsize) {
                            n = bis.read(bytes);
                            readLength += n;
                            out.write(bytes, 0, n);
                        }
                        if (readLength <= contentLength) {
                            n = bis.read(bytes, 0, (int) (contentLength - readLength));
                            out.write(bytes, 0, n);
                        }
                    } else {
                        while ((n = bis.read(bytes)) != -1) {
                            out.write(bytes, 0, n);
                        }
                    }
                    out.flush();
                } else {
                    MyException myException = new MyException();
                    myException.setData("没有此视频");
                    throw myException;
                }
            } catch (MyException e) {
                throw e;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                IOUtils.closeQuietly(out);
                IOUtils.closeQuietly(bis);
            }
        } else {
            MyException myException = new MyException();
            myException.setData("请先登陆");
            throw myException;
        }
    }


    /**
     * 播放视频前 判断是否都登录
     *
     * @param //fileName
     * @param //uId
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/playerpc", produces = "text/plain;charset=utf-8")
    public String playerpc(HttpServletRequest request, HttpServletResponse response,
                           @RequestParam(value = "fileName", defaultValue = "0") String fileName2,
                           @RequestParam(value = "uId", defaultValue = "0") String uid,
                           @RequestParam(value = "pId", defaultValue = "0") String pId,
                           @RequestParam(value = "token") String token
    ) {
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Origin", "*");
//        String result = "";
//        String saveUrl=request.getScheme() + "://"+request.getServerName()+":" +
//                request.getServerPort();
//        //查询此用户是否购买了此视频
//        result = saveUrl+"/ssm/front/player2?fileName2="+fileName2+"&uId="+uid;
//        Map map=new HashMap();
//        map.put("result",result);
//        return JsonUtils.objectToJson(WxResult.ok(map));
        Users users = usersService.selectByUid(Integer.parseInt(uid));
        Map map = new HashMap();
        String result = "";
        String s = users.getuWxcode();
        try {
            //根据pId查询是否为免费课程
            ShopProduct product = productService.selProductBypid(Integer.valueOf(pId));
//            System.out.println(pr);


            if (product.getpIsfee().equals(0) || users.getuWxcode().equals(token)) {
                String saveUrl = request.getScheme() + "://" + request.getServerName() + ":" +
                        request.getServerPort();
                //查询此用户是否购买了此视频
                result = saveUrl + "/ssm/front/player2pc?fileName2=" + fileName2 + "&uId=" + uid + "&pId=" + pId + "&token=" + token;
                map.put("result", result);
                return JsonUtils.objectToJson(WxResult.ok(map));
            }


        } catch (Exception e) {
            e.printStackTrace();
            return JsonUtils.objectToJson(WxResult.build(204, "请先登陆"));
        }

        if (users.getuWxcode().equals(token)) {
            result = "请先登录";
            return JsonUtils.objectToJson(WxResult.build(204, result));
        } else {
            //如果session中的用户id和传过来的用户id一致
            if (users.getuWxcode().equals(token)) {
                ShopRecharge recharge = rechargeService.selectByUid(Integer.parseInt(uid), fileName2, pId);
                if (recharge == null) {
                    return JsonUtils.objectToJson(WxResult.build(206, "请先购买"));
                }
                try {
                    String saveUrl = request.getScheme() + "://" + request.getServerName() + ":" +
                            request.getServerPort();
                    //查询此用户是否购买了此视频
                    result = saveUrl + "/ssm/front/player2pc?fileName2=" + fileName2 + "&uId=" + uid + "&pId=" + pId + "&token=" + token;

                    map.put("result", result);
                    //player2(request,response,fileName2,uid);
                } catch (MyException e) {
                    result = (String) e.getExceptionData();
                }
                return JsonUtils.objectToJson(WxResult.ok(map));
            } else {
                //如果不一致去登录
                return JsonUtils.objectToJson(WxResult.build(204, result));
            }
        }
    }

    /**
     * 播放视频前 判断是否都登录
     * @param //fileName
     * @param //uId
     * @param response
     * @return
     */
//    @ResponseBody
//    @RequestMapping(value="/playerpc",produces = "text/plain;charset=utf-8")
//    public String playerpc(HttpServletRequest request, HttpServletResponse response,
//                         @RequestParam(value="fileName",defaultValue="0")String fileName2,
//                         @RequestParam(value="uId",defaultValue="0")String uid,
//                         @RequestParam(value="pId",defaultValue="0")String pId){
//        response.setHeader("Access-Control-Allow-Credentials","true");
//        response.setHeader("Access-Control-Allow-Origin", "*");
////        String result = "";
////        String saveUrl=request.getScheme() + "://"+request.getServerName()+":" +
////                request.getServerPort();
////        //查询此用户是否购买了此视频
////        result = saveUrl+"/ssm/front/player2?fileName2="+fileName2+"&uId="+uid;
////        Map map=new HashMap();
////        map.put("result",result);
////        return JsonUtils.objectToJson(WxResult.ok(map));
//        String result = "";
//        HttpSession session = request.getSession();
//        Map map=new HashMap();
//        int sessionuid = 0;
//        try {
//            //根据pId查询是否为免费课程
//            ShopProduct product=productService.selProductBypid(Integer.valueOf(pId));
////            System.out.println(pr);
//
//
//
//            if (product.getpIsfee().equals(0)){
//                String saveUrl=request.getScheme() + "://"+request.getServerName()+":" +
//                        request.getServerPort();
//                //查询此用户是否购买了此视频
//                result = saveUrl+"/ssm/front/player2?fileName2="+fileName2+"&uId="+uid+"&pId="+pId;
//                map.put("result",result);
//                return JsonUtils.objectToJson(WxResult.ok(map));
//            }
//            System.out.println(session.getAttribute("uid"));
//            sessionuid=(int) session.getAttribute("uid");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return JsonUtils.objectToJson(WxResult.build(204,"请先登陆"));
//        }
//
//        if (sessionuid == 0) {
//            result = "请先登录";
//            return JsonUtils.objectToJson(WxResult.build(204,result));
//        } else {
//            //如果session中的用户id和传过来的用户id一致
//            if (sessionuid == Integer.parseInt(uid)) {
//                ShopRecharge recharge=rechargeService.selectByUid(Integer.parseInt(uid),fileName2,pId);
//                if (recharge==null){
//                    return JsonUtils.objectToJson(WxResult.build(206,"请先购买"));
//                }
//                try {
//                    String saveUrl=request.getScheme() + "://"+request.getServerName()+":" +
//                            request.getServerPort();
//                    //查询此用户是否购买了此视频
//                    result = saveUrl+"/ssm/front/player2?fileName2="+fileName2+"&uId="+uid+"&pId="+pId;
//
//                    map.put("result",result);
//                    //player2(request,response,fileName2,uid);
//                }catch (MyException e){
//                    result = (String) e.getExceptionData();
//                }
//                return JsonUtils.objectToJson(WxResult.ok(map));
//            } else {
//                //如果不一致去登录
//                return JsonUtils.objectToJson(WxResult.build(204,result));
//            }
//        }
//    }

    /**
     * 视频分段播放
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/player2pc", produces = "text/plain;charset=utf-8", method = RequestMethod.GET)
    public void player2pc(HttpServletRequest request, HttpServletResponse response, String fileName2,
                          @RequestParam(value = "uId", defaultValue = "0") String uid,
                          @RequestParam(value = "pId", defaultValue = "0") String pId,
                          @RequestParam(value = "token") String token) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        /* response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Headers", "*");
        response.addHeader("Access-Control-Max-Age", "*");
        response.addHeader("Access-Control-Allow-Methods ","*");*/
        /*HttpSession session = request.getSession();
        int sessionuid = 0;
*/
        Users users = usersService.selectByUid(Integer.parseInt(uid));
        Map map = new HashMap();
        String result = "";
        String s = users.getuWxcode();
        /*try {
            sessionuid=(int) session.getAttribute("uid");
            //sessionuid=195;
            System.out.println(sessionuid);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        //ShopProduct product=productService.selProductBypid(Integer.valueOf(pId));
//            System.out.println(pr);

        //ShopRecharge s=rechargeService.selectByUid(Integer.parseInt(uid),fileName2,pId);
        ShopProduct product = productService.selProductBypid(Integer.valueOf(pId));
        if (product.getpIsfee().equals(0) || users.getuWxcode().equals(token)) {
            if (product.getpIsfee().equals(1)) {
                ShopRecharge recharge = rechargeService.selectByUid(Integer.parseInt(uid), fileName2, pId);

                if (recharge == null) {
                    MyException myException = new MyException();
                    myException.setData("请先购买");
                    throw myException;
                }
            }
            //根据传过来的文件名获取到文件路径
            String path = "C:/upload/" + fileName2;
            // String path = "F:/u2/"+fileName2;

            BufferedInputStream bis = null;
            OutputStream out = null;
            try {

                /*File file = new File(path);
                if (file.exists()) {
//获取文件名称
                    String fileName = file.getName();
//导出文件
                    String agent = getRequest().getHeader("User-Agent").toUpperCase();
                    InputStream fis = null;
                    OutputStream os = null;
                    try {
                        fis = new BufferedInputStream(new FileInputStream(file.getPath()));
                        byte[] buffer;
                        buffer = new byte[fis.available()];
                        fis.read(buffer);
                        response.reset();
                        //由于火狐和其他浏览器显示名称的方式不相同，需要进行不同的编码处理
                        if(agent.indexOf("FIREFOX") != -1){//火狐浏览器
                            response.addHeader("Content-Disposition", "attachment;filename="+ new String(fileName.getBytes("GB2312"),"ISO-8859-1"));
                        }else{//其他浏览器
                            response.addHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(fileName, "UTF-8"));
                            response.addHeader("Access-Control-Allow-Origin", "*");
                        }
                        //设置response编码
                        response.setCharacterEncoding("UTF-8");
                        response.addHeader("Content-Length", "" + file.length());
                        //设置输出文件类型
                        //response.setContentType("video/mpeg4");
                        response.setContentType("video/mp4");
                        //获取response输出流
                        os = response.getOutputStream();
                        // 输出文件
                        os.write(buffer);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    } finally{
                        //关闭流
                        try {
                            if(fis != null){
                                fis.close();
                            }
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        } finally{
                            try {
                                if(os != null){
                                    os.flush();
                                }
                            } catch (IOException e) {
                                System.out.println(e.getMessage());
                            } finally{
                                try {
                                    if(os != null){
                                        os.close();
                                    }
                                } catch (IOException e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                        }
                    }

                } else {
                    MyException myException = new MyException();
                    myException.setData("没有此视频");
                    throw myException;
                }
*/

                File file = new File(path);
                if (file.exists()) {
                    long p = 0L;
                    long toLength = 0L;
                    long contentLength = 0L;
                    int rangeSwitch = 0; // 0,从头开始的全文下载；1,从某字节开始的下载（bytes=27000-）；2,从某字节开始到某字节结束的下载（bytes=27000-39000）
                    long fileLength;
                    String rangBytes = "";
                    fileLength = file.length();
                    // get file content
                    InputStream ins = new FileInputStream(file);
                    bis = new BufferedInputStream(ins);
                    // tell the client to allow accept-ranges
                    response.reset();
                    response.setHeader("Accept-Ranges", "bytes");
                    response.setHeader("Access-Control-Allow-Origin", "*");
                    // client requests a file block download start byte
                    String range = request.getHeader("Range");
                    if (range != null && range.trim().length() > 0 && !"null".equals(range)) {
                        response.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);
                        rangBytes = range.replaceAll("bytes=", "");
                        if (rangBytes.endsWith("-")) { // bytes=270000-
                            rangeSwitch = 1;
                            p = Long.parseLong(rangBytes.substring(0, rangBytes.indexOf("-")));
                            contentLength = fileLength - p; // 客户端请求的是270000之后的字节（包括bytes下标索引为270000的字节）
                        } else { // bytes=270000-320000
                            rangeSwitch = 2;
                            String temp1 = rangBytes.substring(0, rangBytes.indexOf("-"));
                            String temp2 = rangBytes.substring(rangBytes.indexOf("-") + 1, rangBytes.length());
                            p = Long.parseLong(temp1);
                            toLength = Long.parseLong(temp2);
                            contentLength = toLength - p + 1; // 客户端请求的是 270000-320000 之间的字节
                        }
                    } else {
                        contentLength = fileLength;
                    }
                    // 如果设设置了Content-Length，则客户端会自动进行多线程下载。如果不希望支持多线程，则不要设置这个参数。
                    // Content-Length: [文件的总大小] - [客户端请求的下载的文件块的开始字节]
                    response.setHeader("Content-Length", new Long(contentLength).toString());
                    //response.addHeader("Access-Control-Allow-Origin", "*");
                    // 断点开始
                    // 响应的格式是:
                    // Content-Range: bytes [文件块的开始字节]-[文件的总大小 - 1]/[文件的总大小]
                    if (rangeSwitch == 1) {
                        String contentRange = new StringBuffer("bytes ").append(new Long(p).toString()).append("-")
                                .append(new Long(fileLength - 1).toString()).append("/")
                                .append(new Long(fileLength).toString()).toString();
                        response.setHeader("Content-Range", contentRange);
                        bis.skip(p);
                    } else if (rangeSwitch == 2) {
                        String contentRange = range.replace("=", " ") + "/" + new Long(fileLength).toString();
                        response.setHeader("Content-Range", contentRange);
                        bis.skip(p);
                    } else {
                        String contentRange = new StringBuffer("bytes ").append("0-").append(fileLength - 1).append("/")
                                .append(fileLength).toString();
                        response.setHeader("Content-Range", contentRange);
                    }
                    String fileName = file.getName();
                    response.setContentType("application/octet-stream");
                    response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
                    //  response.addHeader("Access-Control-Allow-Origin", "*");
                    out = response.getOutputStream();
                    int n = 0;
                    long readLength = 0;
                    int bsize = 1024;
                    byte[] bytes = new byte[bsize];
                    if (rangeSwitch == 2) {
                        // 针对 bytes=27000-39000 的请求，从27000开始写数据
                        while (readLength <= contentLength - bsize) {
                            n = bis.read(bytes);
                            readLength += n;
                            out.write(bytes, 0, n);
                        }
                        if (readLength <= contentLength) {
                            n = bis.read(bytes, 0, (int) (contentLength - readLength));
                            out.write(bytes, 0, n);
                        }
                    } else {
                        while ((n = bis.read(bytes)) != -1) {
                            out.write(bytes, 0, n);
                        }
                    }
                    out.flush();

                } else {
                    MyException myException = new MyException();
                    myException.setData("没有此视频");
                    throw myException;
                }
            } catch (MyException e) {
                throw e;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                IOUtils.closeQuietly(out);
                IOUtils.closeQuietly(bis);
            }
        } else {
            MyException myException = new MyException();
            myException.setData("请先登陆");
            throw myException;
        }
    }

    @ResponseBody
    @RequestMapping("/getVideoSrc")
    public OutputStream getVideoSrc(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse, String fileName2) {
        httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
        String source = "C:/ty/" + fileName2;
        //1.创建文件对象
        File f = new File(source);
        //2.获取文件名称
        String fileName = f.getName();
        //3.导出文件
        String agent = httpServletRequest.getHeader("User-Agent").toUpperCase();
        InputStream fis = null;
        OutputStream os = null;
        try {
            //4.获取输入流
            fis = new BufferedInputStream(new FileInputStream(f.getPath()));
            byte[] buffer;
            buffer = new byte[fis.available()];
            fis.read(buffer);
            httpServletResponse.reset();
            //5.由于火狐和其他浏览器显示名称的方式不相同，需要进行不同的编码处理
            if (agent.indexOf("FIREFOX") != -1) {//火狐浏览器
                httpServletResponse.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("GB2312"), "ISO-8859-1"));
            } else {//其他浏览器
                httpServletResponse.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            }
            //6.设置response编码
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.addHeader("Content-Length", "" + f.length());
            //设置输出文件类型
            httpServletResponse.setContentType("video/mpeg4");
            //7.获取response输出流
            os = httpServletResponse.getOutputStream();
            os.flush();
            //8.输出文件
            os.write(buffer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //关闭流
            try {
                if (fis != null) {
                    fis.close();
                }

                if (os != null) {
                    os.flush();
                }

                if (os != null) {
                    os.close();
                }

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        return os;
    }

    /**
     * 更新订单状态
     *
     * @param callback
     * @param orders
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateOrderStatus", produces = "text/plain;charset=utf-8", method = RequestMethod.POST)
    public String updateOrderStatus(String callback, ShopOrders orders,
                                    HttpServletResponse response) {
        System.out.println(orders.getoOrdernum());
        response.addHeader("Access-Control-Allow-Origin", "*");
        WxResult result = ordersService.updateOrderStatus(orders);
        return JsonUtils.objectToJson(result);
    }

    @ResponseBody
    @RequestMapping(value = "/delOrder", produces = "text/plain;charset=utf-8", method = RequestMethod.POST)
    public String delOrder(String callback, @RequestParam(value = "oId", defaultValue = "0") int oId,
                           HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        WxResult result = ordersService.delOrder(oId);
        return JsonUtils.objectToJson(result);
    }

    /**
     * APP登陆
     *
     * @param callback
     * @param account
     * @param loginpwd
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login", produces = "text/plain;charset=utf-8", method = RequestMethod.POST)
    public String login(String callback, @RequestParam(value = "account") String account, @RequestParam(value = "loginpwd") String loginpwd, HttpServletResponse response, HttpServletRequest request) {
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Origin", "*");
        WxResult result = usersService.login(account, loginpwd, request);
        return JsonUtils.objectToJson(result);
    }

    /**
     * app注册
     *
     * @param callback
     * @param user
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/register", produces = "text/plain;charset=utf-8", method = RequestMethod.POST)
    public String register(String callback, Users user, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        WxResult result = new WxResult();
        try {
            result = usersService.register(user);
        } catch (MyException e) {
            result = (WxResult) e.getExceptionData();
        }
        return JsonUtils.objectToJson(result);
    }

    /**
     * 所有商品
     *
     * @param callback
     * @param start
     * @param length
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getAllProduct", produces = "text/plain;charset=utf-8")
    public String getAllProduct(String callback, Integer start, Integer length, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");

        WxResult result = productService.getAllProduct(start, length);
        return JsonUtils.objectToJson(result);
    }

    @ResponseBody
    @RequestMapping(value = "/UploadPic", produces = "text/plain;charset=utf-8", method = RequestMethod.POST)
    public String pictureUpload(String callback, String uploadFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.addHeader("Access-Control-Allow-Origin", "*");
        MultipartFile file = BASE64DecodedMultipartFile.base64ToMultipart(uploadFile);
        //转型为MultipartHttpRequest(重点的所在)
        //  MultipartHttpServletRequest multipartRequest  =  (MultipartHttpServletRequest) request;
        //获得第1张图片（根据前台的name名称得到上传的文件）
        // MultipartFile file  =  multipartRequest.getFile("file");
        WxResult result = pictureService.uploadPicture(request, file);
        return JsonUtils.objectToJson(result);
    }

    /**
     * 获取拼图轮播图
     *
     * @param callback
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getGroupPic", produces = "text/plain;charset=utf-8")
    public String getGroupPic(String callback, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        WxResult result = carouselService.getGroupPic(request);
        return JsonUtils.objectToJson(result);
    }

    /**
     * 获取拼团商品
     */
    @ResponseBody
    @RequestMapping(value = "/getGroupProductList", produces = "text/plain;charset=utf-8")
    public String getGroupProductList(String callback, HttpServletResponse response, int page, int limit) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        WxResult result = groupsProductService.getGroupProductList(request, page, limit);
        return JsonUtils.objectToJson(result);
    }

    /**
     * 获取拼团商品详情
     */
    @ResponseBody
    @RequestMapping(value = "/getGroupProductByPId", produces = "text/plain;charset=utf-8")
    public String getGroupProductByPId(String callback, HttpServletResponse response, GroupsProduct product) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        WxResult result = groupsProductService.getGroupProductByPId(request, product);
        return JsonUtils.objectToJson(result);
    }
    /**
     * 获取所有商品
     *
     * @param categoryName
     * @param uId
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getScanInfoByShopid", produces = "text/plain;charset=utf-8", method = RequestMethod.POST)
    public String getScanInfoByShopid(@RequestParam(value = "categoryName", defaultValue = "0") String categoryName,
                                      @RequestParam(value = "uId", defaultValue = "0") Integer uId, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        try {
            Map map = new HashMap();
            List meaulist = new ArrayList();
            List<ShopCategory> list = categoryService.getAllCategorys(categoryName);
            for (ShopCategory c : list) {
                Map meauMap = new HashMap();
                List<ShopProduct> prolist = productService.getProductByCate(c.getcId(), uId, request);
                meauMap.put("cateName", c.getcName());
                meauMap.put("detailList", prolist);
                meaulist.add(meauMap);
            }
            map.put("menuList", meaulist);
            return JsonUtils.objectToJson(WxResult.ok(map));
        } catch (Exception e) {
            return JsonUtils.objectToJson(WxResult.fail("操作异常！"));
        }
    }

    /**
     * 用户开团接口
     */
    @ResponseBody
    @RequestMapping(value = "/addBill", produces = "text/plain;charset=utf-8")
    public String addBill(String callback, HttpServletResponse response, GroupsBill bill) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        WxResult result = billService.addBill(bill);
        return JsonUtils.objectToJson(result);
    }

    /**
     * 用户参团接口
     */
    @ResponseBody
    @RequestMapping(value = "/joinBill", produces = "text/plain;charset=utf-8")
    public String joinBill(String callback, HttpServletResponse response, GroupsBill bill) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        WxResult result = billService.joinBill(bill);
        return JsonUtils.objectToJson(result);
    }
    @RequestMapping(value = "**")
    public String error() {
        return "404";
    }

    //***********************************************秒杀操作******************************************************//
    /*
     *获取秒杀素材 接口
     */
    @ResponseBody
    @RequestMapping(value = "/getspike", produces = "text/plain;charset=utf-8", method = RequestMethod.POST)
    public String getspike(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        WxResult result = spikeService.getspikes();
        return JsonUtils.objectToJson(result);
    }

    //***********************************************评论操作******************************************************//
    /*
     *通过素材id获取评论 接口
     */
    @ResponseBody
    @RequestMapping(value = "/getcommentbypid", produces = "text/plain;charset=utf-8", method = RequestMethod.POST)
    public String getspikebypid(HttpServletResponse response, HttpServletRequest request, @RequestParam(value = "pId", defaultValue = "") String pid) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        if (pid == null || "".equals(pid)) {
            return JsonUtils.objectToJson(WxResult.build(204, "素材id不能为空"));
        } else {
            WxResult result = commentService.getcommentbypid(pid, request);
            return JsonUtils.objectToJson(result);
        }
    }

    /**
     * 用户添加素材评论 接口
     *
     * @param //用户id uid
     * @param //素材id pid
     * @param //评论内容 context
     * @return json
     */
    @ResponseBody
    @RequestMapping(value = "/addcomment", produces = "text/plain;charset=utf-8", method = RequestMethod.POST)
    public String addcomment(HttpServletResponse response, @RequestParam(value = "uId", defaultValue = "") String uid,
                             @RequestParam(value = "context", defaultValue = "") String context,
                             @RequestParam(value = "pId", defaultValue = "") String pid) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        if (null == uid || "".equals(uid) || null == context || "".equals(context)) {
            return JsonUtils.objectToJson(WxResult.build(204, "评论不能为空"));
        } else {
            WxResult result = commentService.addcomment(uid, context, pid);
            return JsonUtils.objectToJson(result);
        }
    }

    //***********************************************收藏夹操作******************************************************//

    /**
     * 收藏商品
     *
     * @param callback
     * @param //collection
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/careProduct", produces = "text/plain;charset=utf-8", method = RequestMethod.POST)
    public String careProduct(String callback,
                              @RequestParam(value = "uId", defaultValue = "") String uid,
                              @RequestParam(value = "pId", defaultValue = "") String pid,
                              HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        if (null == uid || "".equals(uid) || null == pid || "".equals(pid)) {
            return JsonUtils.objectToJson(WxResult.build(204, "用户或素材不能为空"));
        } else {
            WxResult result = productCollectionService.careProduct(uid, pid);
            return JsonUtils.objectToJson(result);
        }
    }

    /**
     * 收藏夹
     *
     * @param callback
     * @param //uId
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getCollectionList", produces = "text/plain;charset=utf-8", method = RequestMethod.POST)
    public String getproduct(String callback,
                             @RequestParam(value = "uId", defaultValue = "0") String uid,
                             @RequestParam(value = "start", defaultValue = "0") String start,
                             @RequestParam(value = "length", defaultValue = "0") String length,
                             HttpServletResponse response, HttpServletRequest request) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        if (null == uid || "".equals(uid)) {
            return JsonUtils.objectToJson(WxResult.build(204, "用户不能为空"));
        } else {
            WxResult result = productCollectionService.getproduct(uid, start, length, request);
            return JsonUtils.objectToJson(result);
        }
    }

    //***********************************************微信授权登录操作******************************************************//
    @ResponseBody
    @RequestMapping(value = "/wxlogin", produces = "text/plain;charset=utf-8", method = RequestMethod.POST)
    public String wxlogin(String callback,
                          @RequestParam(value = "redirect_uri", defaultValue = "0") String rediurl,
                          HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        System.out.println("上级地址：" + rediurl);
        String APPID = "wx7500e60816b113c8";
        return "";
    }

    /*
     *请求首页的素材排行
     */
    @RequestMapping("/propaihang")
    @ResponseBody
    public ResultUtil propaihang(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        List<Teacher> saleVos = integralUseService.getTeacher(request);
        return ResultUtil.ok(saleVos);
    }

    /*
     * 积分明细
     *
     */
    @RequestMapping("integralsbyuid")
    @ResponseBody
    public String integralsbyuid(@RequestParam(value = "uId", defaultValue = "0") String uId,
                                 HttpServletResponse response) {
        if (null == uId || "0".equals(uId)) {
            return JsonUtils.objectToJson(WxResult.build(204, "用户不能为空"));
        } else {
            WxResult result = integralUseService.integralsbyuid(uId);
            return JsonUtils.objectToJson(result);
        }
    }

    /**
     * 用户退款接口
     */
    @RequestMapping("addRefund")
    @ResponseBody
    public String addRefund(Refund refund,
                            HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        WxResult result = refundService.addRefund(refund);
        return JsonUtils.objectToJson(result);
    }

    /**
     * 退款人添加物流单号以及退货人姓名和地址
     *
     * @param refund
     * @param response
     * @return
     */
    @RequestMapping("updateRefund")
    @ResponseBody
    public String updateRefund(Refund refund,
                               HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        WxResult result = refundService.updateRefund(refund);
        return JsonUtils.objectToJson(result);
    }

    /**
     * 开团成功后的页面
     * 团单id
     */
    @RequestMapping(value = "groupIndex", produces = "text/plain;charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public String groupIndex(Integer id,
                             HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        WxResult result = groupsProductService.groupIndex(id, request);
        return JsonUtils.objectToJson(result);
    }

    @ResponseBody
    @RequestMapping(value = "/getAllPicPC", produces = "text/plain;charset=utf-8")
    public String getAllPicPC(String callback, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        WxResult result = carouselService.getAllPicPC(request);
        return JsonUtils.objectToJson(result);
    }

    @ResponseBody
    @RequestMapping(value = "/refund", produces = "text/plain;charset=utf-8")
    public void refund(HttpServletResponse response, String out_trade_no, String out_refund_no, String total_fee, String refund_fee) throws Exception {
        response.addHeader("Access-Control-Allow-Origin", "*");
        String appid = "wx7500e60816b113c8"; // appid
        String mch_id = "1516361731"; // 商业号
        String key = "henandezhantianxiaxinxikeji12345"; // key

        String nonce_str = PayCommonUtil.getRandomStringByLength(32);//currTime + strRandom; // 随机字符串
        //String out_trade_no = "20190328133817071530";//申请退款的商户订单号

        // String out_refund_no = out_trade_no + "1314";
        // String total_fee = "0.01";
        //  String refund_fee = total_fee;
        String op_user_id = mch_id; // 操作员默认为商户号

        Map<String, String> m = new LinkedHashMap<>();
        m.put("appid", appid);
        m.put("mch_id", mch_id);
        m.put("nonce_str", nonce_str);
        m.put("out_refund_no", out_refund_no);
        m.put("out_trade_no", out_trade_no);
        m.put("refund_fee", refund_fee);
        m.put("total_fee", total_fee);
        //  m.put("op_user_id", op_user_id);
        //签名算法
        String sign = PayCommonUtil.createSign2("UTF-8", m, key);
        m.put("sign", sign);
        //将集合转换成xml
        String requestXML = XMLUtil.mapToXml(m);
        //带证书的postHttpUtil.postData(unifiedorder_url, xml, "utf-8");
        String resXml = CertHttpUtil.postData("https://api.mch.weixin.qq.com/secapi/pay/refund", requestXML);
        //解析xml为集合，请打断点查看resXml详细信息
        Map map = null;
        try {
            map = XMLUtil.doXMLParse(resXml);
            //查看申请退款状态
            PrintWriter out = response.getWriter();
            out.print(map.get("return_code"));
            out.print(map.get("return_msg"));
            System.out.println(map.get("return_code"));
            System.out.println(map.get("return_msg"));
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ResponseBody
    @RequestMapping(value = "/restart", produces = "text/plain;charset=utf-8")
    public void restart() {
        WarTest.restart();
    }

    @ResponseBody
    @RequestMapping(value = "/WxShare", produces = "text/plain;charset=utf-8")
    public String WxShare(String url) {
        String appid = "wx7500e60816b113c8";
        String secret = "53efc09bf87b646b883cb6569f73417c";
        WxAccessToken wxAccessToken = new WxAccessToken(appid, secret);
        JSAPITicketTool jsapiTicketTool = new JSAPITicketTool(appid, wxAccessToken.accessToken);
        /*String currentUrl="http://"+request.getServerName()+request.getContextPath
                ()+request.getServletPath();*/
        Map signMap = JSAPITicketTool.sign(url, jsapiTicketTool.jsApiTicket);
        WxResult result = WxResult.ok(signMap);
        return JsonUtils.objectToJson(result);
    }

    @ResponseBody
    @RequestMapping(value = "/companyList", produces = "text/plain;charset=utf-8", method = RequestMethod.POST)
    public String companyList(String callback, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.addHeader("Access-Control-Allow-Origin", "*");
        WxResult result = companyService.companyList(request);
        return JsonUtils.objectToJson(result);
    }

    /**
     * 播放幻灯片
     */
    @ResponseBody
    @RequestMapping(value = "/pptPlay", produces = "text/plain;charset=utf-8")
    public String pptPlay(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "fileName", defaultValue = "0") String fileName2,
                          @RequestParam(value = "uId", defaultValue = "0") String uid,
                          @RequestParam(value = "pId", defaultValue = "0") String pId) {
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Origin", "*");
        String result = "";
        HttpSession session = request.getSession();
        Map map = new HashMap();
        int sessionuid = 0;
        try {
            //根据pId查询是否为免费课程
            ShopProduct product = productService.selProductBypid(Integer.valueOf(pId));
            // productService.selProductBypid2();
//            System.out.println(pr);
            if (product.getpIsfee().equals(0)) {
                //根据pId查询幻灯片
                List<ShopPicture> list = pictureService.selectByPid(Integer.valueOf(pId));
                map.put("result", list);
                return JsonUtils.objectToJson(WxResult.ok(map));
            }
            System.out.println(session.getAttribute("uid"));
            sessionuid = (int) session.getAttribute("uid");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonUtils.objectToJson(WxResult.build(204, "请先登陆"));
        }
        if (sessionuid == 0) {
            result = "请先登录";
            return JsonUtils.objectToJson(WxResult.build(204, result));
        } else {
            //如果session中的用户id和传过来的用户id一致
            if (sessionuid == Integer.parseInt(uid)) {
                ShopRecharge recharge = rechargeService.selectByUid(Integer.parseInt(uid), fileName2, pId);
                if (recharge == null) {
                    return JsonUtils.objectToJson(WxResult.build(206, "请先购买"));
                }
                try {
                    List<ShopPicture> list = pictureService.selectByPid(Integer.valueOf(pId));
                    map.put("result", list);
                    //player2(request,response,fileName2,uid);
                } catch (MyException e) {
                    result = (String) e.getExceptionData();
                }
                return JsonUtils.objectToJson(WxResult.ok(map));
            } else {
                //如果不一致去登录
                return JsonUtils.objectToJson(WxResult.build(204, result));
            }
        }
    }

    /**
     * 播放幻灯片
     */
    @ResponseBody
    @RequestMapping(value = "/pptPlay2", produces = "text/plain;charset=utf-8")
    public String pptPlay2(HttpServletRequest request, HttpServletResponse response,
                           @RequestParam(value = "fileName", defaultValue = "0") String fileName2,
                           @RequestParam(value = "uId", defaultValue = "0") String uid,
                           @RequestParam(value = "pId", defaultValue = "0") String pId,
                           @RequestParam(value = "token") String token) {
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Origin", "*");
        Users users = usersService.selectByUid(Integer.parseInt(uid));
        Map map = new HashMap();
        String result = "";
        String s = users.getuWxcode();
        //根据pId查询是否为免费课程
        ShopProduct product = productService.selProductBypid(Integer.valueOf(pId));
//            System.out.println(pr);
        if (product.getpIsfee().equals(0)) {
            //根据pId查询幻灯片
            List<ShopPicture> list = pictureService.selectByPid(Integer.valueOf(pId));
            //List<ShopPicture> list= pictureService.selectByPid2(Integer.valueOf(pId));
           /*String  fileName3=pictureService.selectByPid2(Integer.valueOf(pId));
            String saveUrl=request.getScheme() + "://"+request.getServerName()+":" +
                    request.getServerPort();
            result = saveUrl+"/ssm/front/onLineReadFile?fileName="+fileName2;*/
            map.put("result", list);
            return JsonUtils.objectToJson(WxResult.ok(map));
        }
        if (users.getuWxcode().equals(token)) {
            ShopRecharge recharge = rechargeService.selectByUid(Integer.parseInt(uid), fileName2, pId);
            if (recharge == null) {
                return JsonUtils.objectToJson(WxResult.build(206, "请先购买"));
            }
            try {
                List<ShopPicture> list = pictureService.selectByPid(Integer.valueOf(pId));
                map.put("result", list);
                //player2(request,response,fileName2,uid);
            } catch (MyException e) {
                result = (String) e.getExceptionData();
            }
            return JsonUtils.objectToJson(WxResult.ok(map));
        } else {
            //如果不一致去登录
            return JsonUtils.objectToJson(WxResult.build(204, result));
        }
    }

    /**
     * 播放幻灯片
     */
    @ResponseBody
    @RequestMapping(value = "/imgPlay", produces = "text/plain;charset=utf-8")
    public String imgPlay(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "fileName", defaultValue = "0") String fileName2,
                          @RequestParam(value = "uId", defaultValue = "0") String uid,
                          @RequestParam(value = "pId", defaultValue = "0") String pId) {
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Origin", "*");
        String result = "";
        HttpSession session = request.getSession();
        Map map = new HashMap();
        int sessionuid = 0;
        try {
            //根据pId查询是否为免费课程
            ShopProduct product = productService.selProductBypid(Integer.valueOf(pId));
            // productService.selProductBypid2();
//            System.out.println(pr);
            if (product.getpIsfee().equals(0)) {
                //根据pId查询幻灯片
                // List<ShopPicture> list=pictureService.selectByPid(Integer.valueOf(pId));
                List<ShopPicture> list = pictureService.selShopPictureImg(Integer.valueOf(pId));
                map.put("result", list);
                return JsonUtils.objectToJson(WxResult.ok(map));
            }
            System.out.println(session.getAttribute("uid"));
            sessionuid = (int) session.getAttribute("uid");

        } catch (Exception e) {
            e.printStackTrace();
            return JsonUtils.objectToJson(WxResult.build(204, "请先登陆"));
        }
        if (sessionuid == 0) {
            result = "请先登录";
            return JsonUtils.objectToJson(WxResult.build(204, result));
        } else {
            //如果session中的用户id和传过来的用户id一致
            if (sessionuid == Integer.parseInt(uid)) {
                ShopRecharge recharge = rechargeService.selectByUid(Integer.parseInt(uid), fileName2, pId);
                if (recharge == null) {
                    return JsonUtils.objectToJson(WxResult.build(206, "请先购买"));
                }
                try {
                    List<ShopPicture> list = pictureService.selectByPid(Integer.valueOf(pId));
                    map.put("result", list);
                    //player2(request,response,fileName2,uid);
                } catch (MyException e) {
                    result = (String) e.getExceptionData();
                }
                return JsonUtils.objectToJson(WxResult.ok(map));
            } else {
                //如果不一致去登录
                return JsonUtils.objectToJson(WxResult.build(204, result));
            }
        }
    }

    /**
     * 播放幻灯片
     */
    @ResponseBody
    @RequestMapping(value = "/img2Play2", produces = "text/plain;charset=utf-8")
    public String img2Play2(HttpServletRequest request, HttpServletResponse response,
                            @RequestParam(value = "fileName", defaultValue = "0") String fileName2,
                            @RequestParam(value = "uId", defaultValue = "0") String uid,
                            @RequestParam(value = "pId", defaultValue = "0") String pId,
                            @RequestParam(value = "token") String token) {
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Origin", "*");
        Users users = usersService.selectByUid(Integer.parseInt(uid));
        Map map = new HashMap();
        String result = "";
        String s = users.getuWxcode();
        //根据pId查询是否为免费课程
        ShopProduct product = productService.selProductBypid(Integer.valueOf(pId));
//            System.out.println(pr);
        if (product.getpIsfee().equals(0)) {
            //根据pId查询幻灯片
            List<ShopPicture> list = pictureService.selectByPid(Integer.valueOf(pId));
            //List<ShopPicture> list= pictureService.selectByPid2(Integer.valueOf(pId));
           /*String  fileName3=pictureService.selectByPid2(Integer.valueOf(pId));
            String saveUrl=request.getScheme() + "://"+request.getServerName()+":" +
                    request.getServerPort();
            result = saveUrl+"/ssm/front/onLineReadFile?fileName="+fileName2;*/
            map.put("result", list);
            return JsonUtils.objectToJson(WxResult.ok(map));
        }
        if (users.getuWxcode().equals(token)) {
            ShopRecharge recharge = rechargeService.selectByUid(Integer.parseInt(uid), fileName2, pId);
            if (recharge == null) {
                return JsonUtils.objectToJson(WxResult.build(206, "请先购买"));
            }
            try {
                List<ShopPicture> list = pictureService.selectByPid(Integer.valueOf(pId));
                map.put("result", list);
                //player2(request,response,fileName2,uid);
            } catch (MyException e) {
                result = (String) e.getExceptionData();
            }
            return JsonUtils.objectToJson(WxResult.ok(map));
        } else {
            //如果不一致去登录
            return JsonUtils.objectToJson(WxResult.build(204, result));
        }
    }

    @ResponseBody
    @RequestMapping(value = "onLineReadFile", produces = "text/plain;charset=utf-8", method = RequestMethod.GET)
    public void onLineReadFile(@RequestParam(value = "fileName") String fileName, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        try {
            //文件夹路径
            String mkPath = GlobalUtil.getValue("upfile.path");
            String originSourcePath = mkPath + "/" + fileName;
            //获取预览文件的路径
            String outputSourcePath = DocConverterController.getOutputFilePath(originSourcePath);
            File pdfFile = new File(outputSourcePath);
            while (!pdfFile.exists()) {
                Thread.sleep(1000);
            }
            //输出pdf到浏览器
            BufferedInputStream br = new BufferedInputStream(new FileInputStream(pdfFile));
            byte[] buf = new byte[1024];
            int len = 0;
            response.reset(); // 非常重要
            response.setContentType("application/pdf;charset=utf-8");
            response.setHeader("Content-Disposition",
                    "inline; filename=" + java.net.URLEncoder.encode(pdfFile.getName(), "UTF-8"));
            OutputStream out = response.getOutputStream();
            while ((len = br.read(buf)) != -1)
                out.write(buf, 0, len);
            br.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getCustomer", produces = "text/plain;charset=utf-8", method = RequestMethod.POST)
    public String getCustomer(String callback, HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "type", defaultValue = "0") Integer type) throws Exception {
        response.addHeader("Access-Control-Allow-Origin", "*");
        WxResult result = customerService.getCustomer(type);
        return JsonUtils.objectToJson(result);
    }

    //deleteCart
    @ResponseBody
    @RequestMapping(value = "/deleteCart", produces = "text/plain;charset=utf-8", method = RequestMethod.POST)
    public String deleteCart(String callback, HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "cId", defaultValue = "0") String cId) throws Exception {
        response.addHeader("Access-Control-Allow-Origin", "*");
        WxResult result = cartService.deleteCart(cId);
        return JsonUtils.objectToJson(result);
    }

    /**
     * @param callback
     * @param //cart
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addPassward", produces = "text/plain;charset=utf-8")
    public String addPassward(String callback, @RequestParam(value = "uId") int uId,
                              @RequestParam(value = "uRealname", required = false) String uRealname,
                              @RequestParam(value = "uPassword", required = false) String uPassword,
                              HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        WxResult wxResult = cartService.addPassward(uId, uRealname, uPassword);
        return JsonUtils.objectToJson(wxResult);
    }

    @ResponseBody
    @RequestMapping(value = "/get")
    public String get(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        Map map = new HashMap();
        List<ShopPicture> list = pictureService.selShopPictureImg(464);
        //根据pId查询幻灯片getProductByuid
        /*@RequestParam("prices")String prices,@RequestParam("ordernum")String ordernum*/

        //List<ShopPicture> list=pictureService.selectByPid(Integer.valueOf(pId));

        // map.put("result",list);
        // return JsonUtils.objectToJson(WxResult.ok(map));
        /*String  prices2= ordersService.selMoneyByOrdernum(prices,ordernum);
        BigDecimal b4 = new BigDecimal(prices2);
        BigDecimal b5 = new BigDecimal(100);
        double b6= b4.multiply(b5).doubleValue();
        String prices3 = new DecimalFormat("0").format(b6);*/
        // WxResult result=ordersService.addOrderAddress(oId, aId);
//      String ordernum="20191023165210223001";
//              String prices="509";
//       int status=0;
//        String prices4=null;
//        if(status==0){
//            prices4= ordersService.selMoneyByOrdernum(prices,ordernum);
//
//        }else{
//            prices4=ordersService.selMoneyByOrdernum2(ordernum);
//        }
//        System.out.println(prices4);
//        BigDecimal b4 = new BigDecimal(prices4);
//        BigDecimal b5 = new BigDecimal(100);
//        double b6= b4.multiply(b5).doubleValue();
//        String prices3 = new DecimalFormat("0").format(b6);
//        System.out.println("=======================================1到9折=0prices3="+prices3);
        /* List<ShopPicture> list=pictureService.selectByPid(1216);*/
        return JsonUtils.objectToJson(list);
    }

    @RequestMapping(value = "/player18", produces = "text/plain;charset=utf-8")
    public void player9(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Origin", "*");
        String path = "C:/ty/123.mp4";
        BufferedInputStream bis = null;
        OutputStream out = null;
        try {
            File file = new File(path);
            long p = 0L;
            long toLength = 0L;
            long contentLength = 0L;
            int rangeSwitch = 0; // 0,从头开始的全文下载；1,从某字节开始的下载（bytes=27000-）；2,从某字节开始到某字节结束的下载（bytes=27000-39000）
            long fileLength;
            String rangBytes = "";
            fileLength = file.length();
            // get file content
            InputStream ins = new FileInputStream(file);
            bis = new BufferedInputStream(ins);
            // tell the client to allow accept-ranges
            response.reset();
            response.setHeader("Accept-Ranges", "bytes");
            // client requests a file block download start byte
            String range = request.getHeader("Range");
            if (range != null && range.trim().length() > 0 && !"null".equals(range)) {
                response.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);
                rangBytes = range.replaceAll("bytes=", "");
                if (rangBytes.endsWith("-")) { // bytes=270000-
                    rangeSwitch = 1;
                    p = Long.parseLong(rangBytes.substring(0, rangBytes.indexOf("-")));
                    contentLength = fileLength - p; // 客户端请求的是270000之后的字节（包括bytes下标索引为270000的字节）
                } else { // bytes=270000-320000
                    rangeSwitch = 2;
                    String temp1 = rangBytes.substring(0, rangBytes.indexOf("-"));
                    String temp2 = rangBytes.substring(rangBytes.indexOf("-") + 1, rangBytes.length());
                    p = Long.parseLong(temp1);
                    toLength = Long.parseLong(temp2);
                    contentLength = toLength - p + 1; // 客户端请求的是 270000-320000 之间的字节
                }
            } else {
                contentLength = fileLength;
            }
            // 如果设设置了Content-Length，则客户端会自动进行多线程下载。如果不希望支持多线程，则不要设置这个参数。
            // Content-Length: [文件的总大小] - [客户端请求的下载的文件块的开始字节]
            response.setHeader("Content-Length", new Long(contentLength).toString());
            // 断点开始
            // 响应的格式是:
            // Content-Range: bytes [文件块的开始字节]-[文件的总大小 - 1]/[文件的总大小]
            if (rangeSwitch == 1) {
                String contentRange = new StringBuffer("bytes ").append(new Long(p).toString()).append("-")
                        .append(new Long(fileLength - 1).toString()).append("/")
                        .append(new Long(fileLength).toString()).toString();
                response.setHeader("Content-Range", contentRange);
                bis.skip(p);
            } else if (rangeSwitch == 2) {
                String contentRange = range.replace("=", " ") + "/" + new Long(fileLength).toString();
                response.setHeader("Content-Range", contentRange);
                bis.skip(p);
            } else {
                String contentRange = new StringBuffer("bytes ").append("0-").append(fileLength - 1).append("/")
                        .append(fileLength).toString();
                response.setHeader("Content-Range", contentRange);
            }
            String fileName = file.getName();
            response.setContentType("application/octet-stream");
            response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
            out = response.getOutputStream();
            int n = 0;
            long readLength = 0;
            int bsize = 1024;
            byte[] bytes = new byte[bsize];
            if (rangeSwitch == 2) {
                // 针对 bytes=27000-39000 的请求，从27000开始写数据
                while (readLength <= contentLength - bsize) {
                    n = bis.read(bytes);
                    readLength += n;
                    out.write(bytes, 0, n);
                }
                if (readLength <= contentLength) {
                    n = bis.read(bytes, 0, (int) (contentLength - readLength));
                    out.write(bytes, 0, n);
                }
            } else {
                while ((n = bis.read(bytes)) != -1) {
                    out.write(bytes, 0, n);
                }
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/getSubareaPro", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getSubareaPro(HttpServletRequest request,
                                HttpServletResponse response,
                                @RequestParam("page") Integer page,
                                @RequestParam("limit") Integer limit,
                                @RequestParam("sbId") String sbId,
                                @RequestParam(value = "pValidity", defaultValue = "4") int pValidity) {
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Origin", "*");
        WxResult subareaPro = subareaService.getSubareaPro(request, page, limit, sbId, pValidity);
        return JsonUtils.objectToJson(subareaPro);
    }

    @RequestMapping(value = "/getSubarea", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getSubarea(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Origin", "*");
        WxResult subareaPro = subareaService.getSubarea(request);
        return JsonUtils.objectToJson(subareaPro);
    }

    @RequestMapping(value = "/getShopType", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getShopType(HttpServletRequest request, HttpServletResponse response,
                              @RequestParam(value = "pValidity", defaultValue = "4") int pValidity,
                              @RequestParam(value = "sbId") int sbId) {
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Origin", "*");
        WxResult subareaPro = subareaService.getShopType(request, pValidity);
        return JsonUtils.objectToJson(subareaPro);
    }
}

