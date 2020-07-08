package com.irs.controller.AppController;
import com.irs.service.CategoryService;
import com.irs.service.OrdersService;
import com.irs.service.ProductService;
import com.irs.util.JsonUtils;
import com.irs.util.WxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zc
 * @create 2019 - 03 - 15
 * 获取菜单列表
 **/
@RequestMapping("front")
@Controller
public class GetMenuController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private HttpServletRequest request;




    //通过用户id获取我的课程
    @ResponseBody
    @RequestMapping(value = "getProductByuid",produces = "text/plain;charset=utf-8",method = RequestMethod.POST)
    public String getProductByuid(HttpServletRequest request, HttpServletResponse response,
                                  @RequestParam(value="uId",defaultValue="0",required = false) int uid,
                                  @RequestParam(value="start",defaultValue="1",required = false) int start,
                                  @RequestParam(value="length",defaultValue="10",required = false) int length){
        response.addHeader("Access-Control-Allow-Origin", "*");
        WxResult getproductbyuid = ordersService.getproductbyuid(uid, start, length, request);
        return JsonUtils.objectToJson(getproductbyuid);
    }

    //获取菜单列表 当页面首次加载进来的时候
    @ResponseBody
    @RequestMapping(value = "getmenu",produces = "text/plain;charset=utf-8",method = RequestMethod.POST)
    public String getmenu(HttpServletRequest request, HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin", "*");
        return JsonUtils.objectToJson(categoryService.getmenu1(request));
    }

    //通过素材id获取课程列表
    @ResponseBody
    @RequestMapping(value = "getmenubycid",produces = "text/plain;charset=utf-8",method = RequestMethod.POST)
    public String getproductbycid(@RequestParam(value="cId",defaultValue="0") String cid,
                                  @RequestParam(value="start",defaultValue="1") String start,
                                  @RequestParam(value="length",defaultValue="10") String length,
                                  HttpServletResponse response,
                                  HttpServletRequest request){
        response.addHeader("Access-Control-Allow-Origin", "*");
        if (cid == null || "".equals(cid)){
            return JsonUtils.objectToJson(WxResult.build(400,"请输入素材id"));
        }
        return JsonUtils.objectToJson(productService.getmenubycid(cid,start,length,request));
    }
    //获取秒杀素材
    @ResponseBody
    @RequestMapping(value = "getspikeProduct",produces = "text/plain;charset=utf-8",method = RequestMethod.POST)
    public String getspikeProduct(HttpServletResponse response,HttpServletRequest request,
                                  @RequestParam(value="start",defaultValue="1") int start,
                                  @RequestParam(value="length",defaultValue="10") int length){
        response.addHeader("Access-Control-Allow-Origin", "*");
        return JsonUtils.objectToJson(productService.getspikeproduct(request,start,length));
    }
    //获取素材
    //pc端只获取10条素材
    @ResponseBody
    @RequestMapping(value = "getproduct",produces = "text/plain;charset=utf-8",method = RequestMethod.POST)
    public String getproduct(HttpServletResponse response,HttpServletRequest request){
        response.addHeader("Access-Control-Allow-Origin", "*");
        return JsonUtils.objectToJson(productService.getproduct(request,1,10));
    }

    /**
     * 根据父类id查看子类
     */
    @ResponseBody
    @RequestMapping(value="/getcIdBypId",produces = "text/plain;charset=utf-8")
    public String getcIdBypId(@RequestParam(value="pId",defaultValue="")Integer pId, HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin", "*");
        WxResult result=productService.getcIdBypId(pId,request);
        return  JsonUtils.objectToJson(result) ;
    }
}
