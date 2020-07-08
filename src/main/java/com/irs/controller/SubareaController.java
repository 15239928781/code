package com.irs.controller;

import com.irs.annotation.SysLog;

import com.irs.pojo.*;
import com.irs.service.CategoryService;
import com.irs.service.ProductService;
import com.irs.service.SubareaService;
import com.irs.service.TeacherService;
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
@RequestMapping("/subarea")
public class SubareaController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SubareaService subareaService;
   // id='+data.leId+"&sbId="+sbId,

    @SysLog(value="添加特定商品")
    @RequestMapping("/inszhidingProduct")
    //@RequiresPermissions("subarea:subarea:delete")
    @ResponseBody
    public ResultUtil inszhidingProduct(ShopProduct shopProduct,HttpServletRequest request) {
        try {
            subareaService.inszhidingProduct(shopProduct,request);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("添加出错,稍后再试！");
        }
    }

    @RequestMapping("/addProduct")
    public String addProduct(Model model,  String userStr) {
        List<ShopCategory> list=categoryService.getAll();
        model.addAttribute("list", list);
        List<Teacher> teacherList=teacherService.getAll();
        model.addAttribute("teacherList",teacherList);

        List<Subarea> all = subareaService.getAll();
        model.addAttribute("all",all);
        model.addAttribute("userStr",userStr);
        return "page/subarea/addProduct";
    }
    @RequestMapping("/getViplist/{sbId}")
    @ResponseBody
    public ResultUtil getViplist(Integer page, Integer limit,@PathVariable("sbId") String sbId) {
        ResultUtil level = subareaService.setLevel(page, limit,sbId);
        return level;
    }


    @RequestMapping("/quxiaoVIP")
    @ResponseBody
    public ResultUtil quxiaoVIP(Integer leId,  String sbId){


        try {
            subareaService.quxiaoVIP(leId,sbId);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("添加出错,稍后再试！");
        }

    }
    @RequestMapping("/guanlianVIP")
    @ResponseBody
    public ResultUtil guanlianVIP(Integer leId,  String sbId){


        try {
            subareaService.guanlianVIP(leId,sbId);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("添加出错,稍后再试！");
        }

    }

    @RequestMapping("/getVip")
    public String getVip(Model model,  String userStr) {

        model.addAttribute("vip",userStr);
        return "page/subarea/vipList";
    }

    @RequestMapping("/getProductListFirst/{sbId}")
    // @RequiresPermissions("sys:product:list")
    @ResponseBody
    public ResultUtil getProductListFirst(Integer page, Integer limit, @PathVariable("sbId") Long sbId){
        return subareaService.getProductListFirst(page,limit,sbId);
    }

    /**
     * 批量移除分区商品
     * @param //carouselStr
     * @return
     */
    @SysLog(value="批量移除分区商品")
    @RequestMapping("/delSubareaProducts")
    //@RequiresPermissions("subarea:subarea:delete")
    @ResponseBody
    public ResultUtil delSubareaProducts( String userStr,Long sbId) {
        try {
            subareaService.delSubareaProducts( userStr,sbId);
            System.out.println("sdfasfasfsa");
           // subareaService.delSubarea(carouselStr);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("删除出错,稍后再试！");
        }
    }
    /**
     * 更新分区信息
     * @param //level
     * @return
     */
    @SysLog(value="设置价格分区价格")
    @RequestMapping("/updateProduct")
   // @RequiresPermissions("subarea:subarea:update")
    @ResponseBody
    public ResultUtil updateProduct(Psb psb) {
        try {
            Psb updateProduct = subareaService.updateProduct(psb);

            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("设置价格出错出错,稍后再试！");
        }
    }
    @RequestMapping("/editSubareaProduct")
    public String editSubareaProduct(Integer pId,Long sbId, Model model) {
        /*Subarea subarea=subareaService.selSubareaById(sbId);
        model.addAttribute("subarea",subarea);*/

       Psb psb= subareaService.selSubareaProduct(pId,sbId);
        model.addAttribute("psb",psb);
       return "page/subarea/editSubareaProduct";
    }



    @RequestMapping("/getProductList/{sbId}")
   // @RequiresPermissions("sys:product:list")
    @ResponseBody
    public ResultUtil getProductList(Integer page, Integer limit, @PathVariable("sbId") Long sbId){
        return subareaService.getProductList(page,limit,sbId);
    }


    @SysLog(value="批量添加商品")
    @RequestMapping("/instPSbProduct/{carouselStr}/{sbId}")
    //@RequiresPermissions("subarea:subarea:delete")
    @ResponseBody
    public ResultUtil instPSbProduct(@PathVariable("carouselStr") String carouselStr,@PathVariable("sbId")Long sbId) {
        try {
            subareaService.instPSbProduct(carouselStr,sbId);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("添加出错,稍后再试！");
        }
    }


    @RequestMapping("/lookProduct")
    public String lookProduct(Model model,  String userStr) {

       model.addAttribute("psd",userStr);
        return "page/subarea/lookProduct";
    }
    @SysLog(value="获取分区商品")
    @RequestMapping("/getLookProduct/{sbId}")
    //@RequiresPermissions("subarea:subarea:delete")
    @ResponseBody
    public ResultUtil getLookProduct(Model model,Integer page, Integer limit,@PathVariable("sbId") String sbId) {
        /* Psb psbsb= subareaService.lookProduct(userStr,sbId);*/
        ResultUtil subarea = subareaService.lookProduct(page, limit,sbId);
        //model.addAttribute("psd",userStr);
        return subarea;
    }
    @RequestMapping("/addPsdProduct")
    public String addPsdProduct(Long sbId, Model model) {
        Subarea subarea=subareaService.selSubareaById(sbId);
        model.addAttribute("subarea",subarea);

        return "page/subarea/productList";
    }

    @RequestMapping("/subareaList")
    public String subareaList() {
        return "page/subarea/subareaList";
    }

    @RequiresPermissions("subarea:subarea:save")
    @RequestMapping("/addSubarea")
    public String addSubarea() {
        return "page/subarea/addSubarea";
    }

    @RequiresPermissions("subarea:subarea:save")
    @RequestMapping("/editSubarea")
    public String editSubarea(Long sbId, Model model) {
        Subarea subarea=subareaService.selSubareaById(sbId);
        model.addAttribute("subarea",subarea);
        return "page/subarea/editSubarea";
    }

    @RequestMapping("/list")
    @RequiresPermissions("subarea:subarea:list")
    @ResponseBody
    public ResultUtil getSubareaList(Integer page, Integer limit) {
        ResultUtil subarea = subareaService.setSubarea(page, limit);
        return subarea;
    }

    /**
     * 添加分区信息
     * @param //level
     * @return
     */
    @SysLog(value="添加分区信息")
    @RequestMapping("/save")
    @RequiresPermissions("subarea:subarea:save")
    @ResponseBody
    public ResultUtil insSubarea(Subarea subarea) {
        try {
            subareaService.insSubarea(subarea);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("添加出错,稍后再试！");
        }
    }
    /**
     * 更新分区信息
     * @param //level
     * @return
     */
    @SysLog(value="更新分区信息")
    @RequestMapping("/update")
    @RequiresPermissions("subarea:subarea:update")
    @ResponseBody
    public ResultUtil updSubarea(Subarea subarea) {
        try {
            subareaService.updSubarea(subarea);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("删除出错,稍后再试！");
        }
    }

    /**
     * 删除指定的分区
     * @param //id
     * @return
     */
    @SysLog(value="删除指定的分区")
    @RequestMapping("/delete")
    @RequiresPermissions("subarea:subarea:delete")
    @ResponseBody
    public ResultUtil delLevelById(Long sbId) {
        try {
            subareaService.delSubareaById(sbId);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("修改出错,稍后再试！");
        }
    }

    /**
     * 批量删除分区
     * @param carouselStr
     * @return
     */
    @SysLog(value="批量删除分区")
    @RequestMapping("/deletes")
    @RequiresPermissions("subarea:subarea:delete")
    @ResponseBody
    public ResultUtil delLevel(String carouselStr) {
        try {
            subareaService.delSubarea(carouselStr);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("删除出错,稍后再试！");
        }
    }

    //校验等级名是否存在
    @RequestMapping("checkSubareaByleName")
    @ResponseBody
    public ResultUtil checkSubareaByleName(String sbName){
        Subarea level = subareaService.checkSubareaByleName(sbName);
        if(level!=null){
            return new ResultUtil(500,"分区名称已存在，请重新填写！");
        }
        return new ResultUtil(0);
    }

    /**
     * 更新分区展示状态
     * @return
     */
    @SysLog(value="更新分区展示状态")
    @RequestMapping("/update/{sbId}/{sbIsshow}")
    @RequiresPermissions("subarea:subarea:update")
    @ResponseBody
    public ResultUtil updCarouselStatusById(@PathVariable("sbId") Long sbId, @PathVariable("sbIsshow") Integer sbIsshow) {
        try {
            subareaService.updsubareaStatusById(sbId,sbIsshow);



            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("修改出错,稍后再试！");
        }
    }


}
