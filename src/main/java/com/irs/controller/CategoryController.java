package com.irs.controller;

import com.irs.annotation.MyException;
import com.irs.annotation.SysLog;
import com.irs.pojo.ShopCategory;
import com.irs.pojo.TbMenus;
import com.irs.service.CategoryService;
import com.irs.util.ResultUtil;
import com.irs.util.WxResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("sys/")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/categoryList")
    public String categoryList() {
        return "page/category/categoryList";
    }

    @RequiresPermissions("sys:category:save")
    @RequestMapping("/addCategory")
    public String addCategory() {
        return "page/category/addCategory";
    }

    @RequiresPermissions("sys:category:update")
    @RequestMapping("/editCategory")
    public String editCategory(Integer id, Model model) {
        ShopCategory category=categoryService.selCategoryById(id);
        System.out.println(category.toString());
        model.addAttribute("category",category);
        return "page/category/editCategory";
    }





    @RequestMapping("/updCategorySortingById2")
    @RequiresPermissions("sys:category:update")
    @ResponseBody
    public ResultUtil updCategorySortingById2(Integer cId, String cSorting) {
        ShopCategory shopCategory = new ShopCategory();
        shopCategory.setcId( cId);
        try {
            Long.parseLong(cSorting);
        } catch (NumberFormatException e) {
            return ResultUtil.error("修改失败，只允许输入整数！");
        }
        shopCategory.setcSorting(Integer.parseInt(cSorting));
        categoryService.updCategorySortingById(shopCategory);
        return ResultUtil.ok();
    }



    @RequestMapping("/updCategorySortingById")
    @RequiresPermissions("sys:category:update")
    @ResponseBody
    public ResultUtil updCategorySortingById(Integer cId, String cSorting) {
        ShopCategory shopCategory = new ShopCategory();
        shopCategory.setcId( cId);
        try {
            Long.parseLong(cSorting);
        } catch (NumberFormatException e) {
            return ResultUtil.error("修改失败，只允许输入整数！");
        }
      shopCategory.setcSorting(Integer.parseInt(cSorting));
        categoryService.updCategorySortingById(shopCategory);
        return ResultUtil.ok();
    }

    //获取一级列表
    @RequestMapping("/getCategoryList")
    @RequiresPermissions("sys:category:list")
    @ResponseBody
    public ResultUtil getCategoryList(Integer page, Integer limit) {
        String type = 0+"";
        ResultUtil catagory = categoryService.getCategoryList(page, limit,type);
        return catagory;
    }

    /**
     * 添加分类信息
     * @param category
     * @return
     */
    @SysLog(value="添加分类信息")
    @RequestMapping("/insCategory")
    @RequiresPermissions("sys:category:save")
    @ResponseBody
    public ResultUtil insCategory(ShopCategory category) {
        try {
//            category.setcIsshow(1);
            if(category.getParentid()==0){
                category.setcGrade(1);
            }
            else {
                category.setcGrade(2);
            }
            categoryService.insCategory(category);
            return ResultUtil.ok();
        } catch (MyException e){
            return (ResultUtil) e.getExceptionData();
        } catch (Exception e) {
            return ResultUtil.error("添加出错,稍后再试！");
        }
    }


    /**
     * 删除指定的分类信息
     * @param id
     * @return
     */
    @SysLog(value="删除指定的分类信息")
    @RequestMapping("/delCategoryById")
    @RequiresPermissions("sys:category:delete")
    @ResponseBody
    public ResultUtil delCategoryById(Integer id) {
        try {
           int a= categoryService.delCategoryById(id);
           if (a==1){
               return ResultUtil.ok();
           }else {
                return ResultUtil.error();
           }

        } catch (Exception e) {
            return ResultUtil.error("修改出错,稍后再试！");
        }
    }

    /**
     * 批量删除分类信息
     * @param carouselStr
     * @return
     */
    @SysLog(value="批量删除分类信息")
    @RequestMapping("/delCategory")
    @RequiresPermissions("sys:category:delete")
    @ResponseBody
    public ResultUtil delCategory(String carouselStr) {
        try {
            int a=categoryService.delCategory(carouselStr);
            if (a==1){
                return ResultUtil.ok();
            }else {
                return ResultUtil.error();
            }
        } catch (Exception e) {
            return ResultUtil.error("删除出错,稍后再试！");
        }
    }

    /**
     * 更新分类信息
     * @paramcarousel
     * @return
     */
    @SysLog(value="更新分类信息")
    @RequestMapping("/updCategory")
    @RequiresPermissions("sys:category:update")
    @ResponseBody
    public ResultUtil updCategory(ShopCategory category) {
        try {
            categoryService.updCategory(category);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("删除出错,稍后再试！");
        }
    }


    //********************************************************************//



    /*
     *跳转视图
     */
    @RequestMapping("/category2List")
    public String category2List() {
        return "page/category2/categoryList";
    }

    @RequiresPermissions("sys:category2:save")
    @RequestMapping("/addCategory2")
    public String addCategory2(Model model) {
        List<ShopCategory> shopCategorys = categoryService.selCategoryBypid();
        model.addAttribute("categorys",shopCategorys);
        return "page/category2/addCategory";
    }

    @RequiresPermissions("sys:category2:update")
    @RequestMapping("/editCategory2")
    public String editCategory2(Integer id, Model model) {
        ShopCategory category=categoryService.selCategoryById(id);
        List<ShopCategory> shopCategorys = categoryService.selCategoryBypid();
        model.addAttribute("category",category);
        model.addAttribute("categorys",shopCategorys);
        return "page/category2/editCategory";
    }

    //获取二级列表
    @RequestMapping("/getCategory2List")
    @RequiresPermissions("sys:category2:list")
    @ResponseBody
    public ResultUtil getCategory2List(Integer page, Integer limit) {
        String type = 1+"";
        ResultUtil catagory = categoryService.getCategoryList(page, limit,type);
        return catagory;
    }
    /**
     * 添加分类信息
     * @param category
     * @return
     */
    @SysLog(value="添加分类信息")
    @RequestMapping("/insCategory2")
    @RequiresPermissions("sys:category2:save")
    @ResponseBody
    public ResultUtil insCategory2(ShopCategory category) {
        try {
            if(category.getParentid()==0){
                category.setcGrade(1);
            }
            else {
                category.setcGrade(2);
            }
            categoryService.insCategory(category);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("添加出错,稍后再试！");
        }
    }


    /**
     * 删除指定的分类信息
     * @param id
     * @return
     */
    @SysLog(value="删除指定的分类信息")
    @RequestMapping("/delCategory2ById")
    @RequiresPermissions("sys:category2:delete")
    @ResponseBody
    public ResultUtil delCategory2ById(Integer id) {
        try {
            categoryService.delCategoryById(id);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("修改出错,稍后再试！");
        }
    }

    /**
     * 批量删除分类信息
     * @param carouselStr
     * @return
     */
    @SysLog(value="批量删除分类信息")
    @RequestMapping("/delCategory2")
    @RequiresPermissions("sys:category2:delete")
    @ResponseBody
    public ResultUtil delCategory2(String carouselStr) {
        try {
            categoryService.delCategory(carouselStr);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("删除出错,稍后再试！");
        }
    }

    /**
     * 更新分类信息
     * @paramcarousel
     * @return
     */
    @SysLog(value="更新分类信息")
    @RequestMapping("/updCategory2")
    @RequiresPermissions("sys:category2:update")
    @ResponseBody
    public ResultUtil updCategory2(ShopCategory category) {
        System.out.println(category.toString());
        try {
            categoryService.updCategory(category);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("删除出错,稍后再试！");
        }
    }

    /**
     */
    @SysLog(value="添加分类信息")
    @RequestMapping("/selectByCId")
    @RequiresPermissions("sys:category2:list")
    @ResponseBody
    public ResultUtil selectByCId(Integer cId) {
        try {
            ResultUtil resultUtil=categoryService.selectByCId(cId);
            return resultUtil;
        } catch (Exception e) {
            return ResultUtil.error("添加出错,稍后再试！");
        }
    }

    /**
     * 更新轮播信息
     * @return
     */
    @SysLog(value="更新二级分类显示状态")
    @RequestMapping("/updateShow/{id}/{status}")
    @RequiresPermissions("sys:category2:update")
    @ResponseBody
    public ResultUtil updateShow(@PathVariable("id") Integer id, @PathVariable("status") Integer status) {
        try {
            categoryService.updateShow(id,status);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("修改出错,稍后再试！");
        }
    }
}
