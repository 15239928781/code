package com.irs.controller;

import com.irs.annotation.SysLog;
import com.irs.pojo.ShopCategory;
import com.irs.pojo.Teacher;
import com.irs.service.TeacherService;
import com.irs.util.ResultUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("sys/")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/teacherList")
    public String teacherList() {
        return "page/teacher/teacherList";
    }

    @RequiresPermissions("sys:teacher:save")
    @RequestMapping("/addTeacher")
    public String addTeacher() {
        return "page/teacher/addTeacher";
    }

    @RequiresPermissions("sys:teacher:update")
    @RequestMapping("/editTeacher")
    public String editTeacher(Integer id, Model model) {
        Teacher teacher=teacherService.selTeacherById(id);
        model.addAttribute("teacher",teacher);
        return "page/teacher/editTeacher";
    }

    @RequestMapping("/getTeacherList")
    @RequiresPermissions("sys:teacher:list")
    @ResponseBody
    public ResultUtil getTeacherList(Integer page, Integer limit,Teacher teacher) {
        ResultUtil teacher2 = teacherService.getTeacherList(page, limit,teacher);
        return teacher2;
    }

    /**
     * 添加讲师信息
     * @param teacher
     * @return
     */
    @SysLog(value="添加讲师信息")
    @RequestMapping("/insTeacher")
    @RequiresPermissions("sys:teacher:save")
    @ResponseBody
    public ResultUtil insTeacher(Teacher teacher) {
        try {
            teacherService.insTeacher(teacher);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("添加出错,稍后再试！");
        }
    }


    /**
     * 删除指定的讲师信息
     * @param id
     * @return
     */
    @SysLog(value="删除指定的讲师信息")
    @RequestMapping("/delTeacherById")
    @RequiresPermissions("sys:teacher:delete")
    @ResponseBody
    public ResultUtil delTeacherById(Integer id) {
        try {
            teacherService.delTeacherById(id);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("修改出错,稍后再试！");
        }
    }

    /**
     * 批量删除讲师信息
     * @param carouselStr
     * @return
     */
    @SysLog(value="批量删除讲师信息")
    @RequestMapping("/delTeacher")
    @RequiresPermissions("sys:teacher:delete")
    @ResponseBody
    public ResultUtil delTeacher(String carouselStr) {
        try {
            teacherService.delTeacher(carouselStr);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("删除出错,稍后再试！");
        }
    }

    /**
     * 更新讲师信息
     * @param teacher
     * @return
     */
    @SysLog(value="更新讲师信息")
    @RequestMapping("/updTeacher")
    @RequiresPermissions("sys:teacher:update")
    @ResponseBody
    public ResultUtil updTeacher(Teacher teacher) {
        try {
            teacherService.updTeacher(teacher);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("删除出错,稍后再试！");
        }
    }
}
