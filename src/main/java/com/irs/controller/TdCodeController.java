package com.irs.controller;
import com.irs.annotation.SysLog;
import com.irs.pojo.TdCode;
import com.irs.service.TdCodeService;
import com.irs.util.ResultUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("tdCodes/")
public class TdCodeController {

    @Autowired
    private TdCodeService tdCodeService;
    @RequestMapping("tdCodeLists")
    public  String  tdCodeLists(){
    return "page/vcode/voceList";
}

    @RequestMapping("/getVcodeList")
    @ResponseBody
    public ResultUtil getVcodeList(Integer page, Integer limit){

  try {
            ResultUtil resultUtil=tdCodeService.getVcodeList(page,limit);
            return resultUtil;
        } catch (Exception e) {
            return ResultUtil.error("添加出错,稍后再试！");
        }

    }
    /**
     * 批量移除分区商品
     * @param //carouselStr
     * @return
     */
    @SysLog(value="批量移除图片")
    @RequestMapping("/deletes")
    //@RequiresPermissions("subarea:subarea:delete")
    @ResponseBody
    public ResultUtil deletes( String carouselStr) {
        try {
            tdCodeService.deletes( carouselStr);
            System.out.println("sdfasfasfsa");
            // subareaService.delSubarea(carouselStr);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("删除出错,稍后再试！");
        }
    }
    @RequestMapping("addtdCodes")
    public  String  addtdCodes(){

        return "page/vcode/addtdCodes";
    }
    //etfzesdghjkl,,.

    @SysLog(value="批量添加图片")
    @RequestMapping("/save")

    @ResponseBody
    public ResultUtil save(TdCode tdCode) {
        try {
           tdCodeService.save(tdCode);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("添加出错,稍后再试！");
        }
    }
    @RequestMapping("/editCode")
public String editCode(Integer tdId, Model model){
        TdCode tdCode= tdCodeService.selectBytdId(tdId);
        model.addAttribute("tdCode",tdCode);
        return  "page/vcode/editCode" ;
}

    /**
     * 更新轮播信息
     * @return
     */
    @SysLog(value="更新图片")
    @RequestMapping("/update")
   // @RequiresPermissions("carousel:carousel:update")
    @ResponseBody
    public ResultUtil update(TdCode tdCode) {
        try {
            tdCodeService.update(tdCode);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("修改出错,稍后再试！");
        }
    }


}
