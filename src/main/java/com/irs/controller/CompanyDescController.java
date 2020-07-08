package com.irs.controller;

import com.irs.annotation.SysLog;
import com.irs.pojo.*;
import com.irs.service.CompanyService;
import com.irs.util.ResultUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/sys")
public class CompanyDescController {

    @Autowired
    private CompanyService companyListService;

    @RequestMapping("/companyList")
    @RequiresPermissions("sys:company:list")
    public String companyList() {
        return "page/company/companyList";
    }


    @RequestMapping("/upload_json_company")
    @RequiresPermissions("sys:company:save")
    public String upload_json(){
        return "page/company/upload_json";
    }
    @RequestMapping("editCompany/{id}")
    @RequiresPermissions("sys:company:update")
    public String editCompany(@PathVariable("id")String id, Model model){
        Company company=companyListService.selectById(Integer.parseInt(id));
        model.addAttribute("company",company);
        return "page/company/editCompany";
    }
    @RequestMapping("/file_manager_json_company")
    @RequiresPermissions("sys:company:save")
    public String file_manager_json(){
        return "page/company/file_manager_json";
    }



    @RequestMapping("/getCompanyList")
    @RequiresPermissions("sys:company:list")
    @ResponseBody
    public ResultUtil getCompanyList(Integer page, Integer limit){
        return companyListService.getCompanyList(page,limit);
    }




    @RequestMapping("/addCompany")
    @RequiresPermissions("sys:company:save")
    public String addProduct(){

        return "page/company/addCompany";
    }






    @SysLog(value="添加公司简介")
    @RequestMapping("/insCompany")
    @RequiresPermissions("sys:company:save")
    @ResponseBody
    public ResultUtil insCompany(Company company){
        try {
            companyListService.insCompany(company);
            return ResultUtil.ok();
        } catch (Exception e) {
            //e.printStackTrace();
            return new ResultUtil(502,"添加公司简介失败");
        }
    }



    /**
     * 根据ID删除公司简介
     * @param pId
     * @return
     */
    @SysLog(value="根据ID删除公司简介")
    @RequestMapping("/delCompanyById/{id}")
    @RequiresPermissions("sys:company:delete")
    @ResponseBody
    public ResultUtil delCompanyByPid(@PathVariable("id")Integer id){
        try {
            companyListService.delCompanyByPid(id);
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
    @SysLog(value="更新公司简介")
    @RequestMapping("/updCompany")
    @RequiresPermissions("sys:company:update")
    @ResponseBody
    public ResultUtil updProduct(Company company){
        try {
            companyListService.updCompany(company);
            return ResultUtil.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error();
        }
    }
}
