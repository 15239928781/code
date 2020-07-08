package com.irs.controller;

import com.irs.pojo.Plupload;
import com.irs.service.PluploadService;
import com.irs.util.GlobalUtil;
import com.irs.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("upload")
public class UploadController {

    @Autowired
    private PluploadService pluploadService;

    @RequestMapping(value = "/pluploadUpload")
    @ResponseBody
    public ResultUtil upload(Plupload plupload, HttpServletRequest request, HttpServletResponse response) {
        String FileDir = "pluploadDir";//文件保存的文件夹
        plupload.setRequest(request);//手动传入Plupload对象HttpServletRequest属性
        String realName = plupload.getName().substring(0, plupload.getName().lastIndexOf("."));
        //int userId = ((User)request.getSession().getAttribute("user")).getUserId();
        //文件存储绝对路径,会是一个文件夹，项目相应Servlet容器下的"pluploadDir"文件夹，还会以用户唯一id作划分
        // File dir = new File(request.getSession().getServletContext().getRealPath("/") + FileDir);
        File dir = new File(GlobalUtil.getValue("upfile.path"));
        if (!dir.exists()) {
            dir.mkdirs();//可创建多级目录，而mkdir()只能创建一级目录
        }
        //开始上传文件
        Plupload plupload1 = pluploadService.upload(plupload, dir);
        Map map = new HashMap<>();
        map.put("plupload", plupload1);
        map.put("pRealName", realName);
        return ResultUtil.ok(map);
    }
}

