package com.irs.controller;
import com.irs.annotation.SysLog;
import com.irs.pojo.*;
import com.irs.service.*;
import com.irs.util.ResultUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("sys/")
public class ProductController {
    @Autowired
    private BrowseService browseService;

     @Autowired
     private ProductService productService;

     @Autowired
     private CategoryService categoryService;

     @Autowired
     private TeacherService teacherService;

     @Autowired
     private CommentService commentService;

    @Autowired
    private SubareaService subareaService;
    @RequestMapping("upload_json")
    @RequiresPermissions("sys:product:save")
    public String upload_json(){
        return "page/product/upload_json";
    }

    @RequestMapping("file_manager_json")
    @RequiresPermissions("sys:product:save")
    public String file_manager_json(){
        return "page/product/file_manager_json";
    }
    @RequestMapping("editProduct/{pId}")
    @RequiresPermissions("sys:product:update")
    public String editProduct(@PathVariable("pId")String pId, Model model){
        ShopProduct product=productService.selProductBypid(Integer.parseInt(pId));
        model.addAttribute("product", product);
        List<ShopCategory> list=categoryService.getAll();
        model.addAttribute("list", list);
        List<Teacher> teacherList=teacherService.getAll();
        model.addAttribute("teacherList",teacherList);
        List<ShopCategory> categoryList=categoryService.selectFId(product.getfId());
        System.out.println(categoryList.toString());
        model.addAttribute("categoryList",categoryList);
        return "page/product/editProduct";
    }
    @RequestMapping("addProduct")
    @RequiresPermissions("sys:product:save")
    public String addProduct(Model model){
        List<ShopCategory> list=categoryService.getAll();
        model.addAttribute("list", list);
        List<Teacher> teacherList=teacherService.getAll();
        List<Subarea>subarea=subareaService.getAll();
        model.addAttribute("subarea", subarea);
        model.addAttribute("teacherList",teacherList);
        return "page/product/addProduct";
    }

    @RequestMapping("productList")
    @RequiresPermissions("sys:product:list")
    public String productList(Model model){
        List<ShopCategory> list=categoryService.getAll();
        model.addAttribute("list", list);
        return "page/product/productList";
    }
    /**
     * 添加商品
     * @param product
     * @return
     */
    @SysLog(value="添加商品")
    @RequestMapping("/insProduct")
    @RequiresPermissions("sys:product:save")
    @ResponseBody
    public ResultUtil insProduct(ShopProduct product, HttpServletRequest request){
        try {
            productService.insProduct(product,request);
            return ResultUtil.ok();
        } catch (Exception e) {
            //e.printStackTrace();
            return new ResultUtil(500,"错误");
        }
    }

    @RequestMapping("/getProductList")
    @RequiresPermissions("sys:product:list")
    @ResponseBody
    public ResultUtil getProductList(Integer page, Integer limit, ShopProduct search){
        return productService.getProductList(page,limit,search);
    }

    /**
     * 批量删除商品
     * @param userStr
     * @return
     */
    @SysLog(value="批量删除商品")
    @RequestMapping("/delProducts/{userStr}")
    @RequiresPermissions("sys:product:delete")
    @ResponseBody
    public ResultUtil delProducts(@PathVariable("userStr")String userStr){
        try {
            productService.delProducts(userStr);
            return ResultUtil.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    /**
     * 根据ID删除商品
     * @param pId
     * @return
     */
    @SysLog(value="根据ID删除商品")
    @RequestMapping("/delProductByPid")
    @RequiresPermissions("sys:product:delete")
    @ResponseBody
    public ResultUtil delProductByPid(String pId){
        try {
            productService.delProductByPid(pId);
            return ResultUtil.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    /**
     * 更新用户商品
     * @param product
     * @return
     */
    @SysLog(value="更新用户商品")
    @RequestMapping("/updProduct")
    @RequiresPermissions("sys:product:update")
    @ResponseBody
    public ResultUtil updProduct(ShopProduct product){
        try {
            productService.updProduct(product);
            return ResultUtil.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    @RequestMapping("/getCommentList")
    @RequiresPermissions("sys:product:list")
    @ResponseBody
    public ResultUtil getCommentList(Integer page, Integer limit, Comment search){
        return commentService.getCommentList(page,limit,search);
    }

    /**
     * 批量删除用户
     * @param /./userStr
     * @return
     */
    @SysLog(value="批量删除用户")
    @RequestMapping("delComment/{userStr}")
    @RequiresPermissions("sys:product:delete")
    @ResponseBody
    public ResultUtil delComment(@PathVariable("userStr")String userStr){
        try {
            commentService.delComment(userStr);
            return  ResultUtil.ok("操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return  ResultUtil.error("操作失败");
        }
    }

    /**
     * 根据ID删除用户
     * @param //uid
     * @return
     */
    @SysLog(value="根据ID删除用户")
    @RequestMapping("delCommentByUid/{cId}")
    @RequiresPermissions("sys:product:delete")
    @ResponseBody
    public ResultUtil delCommentByUid(@PathVariable("cId")String cId){
        try {
            commentService.delCommentByUid(cId);
            return  ResultUtil.ok("操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return  ResultUtil.error("操作失败");
        }
    }

    @RequestMapping("commentList")
    @RequiresPermissions("sys:product:list")
    public String commentList(Model model,int pId){
        model.addAttribute("pId", pId);
        //好评数量
        long goodNum=commentService.commentNum(pId,1);
        //中评数量
        long mediumNum=commentService.commentNum(pId,2);
        //差评
        long poorNum=commentService.commentNum(pId,3);
        model.addAttribute("goodNum",goodNum);
        model.addAttribute("mediumNum",mediumNum);
        model.addAttribute("poorNum",poorNum);
        return "page/product/commentList";
    }
}
