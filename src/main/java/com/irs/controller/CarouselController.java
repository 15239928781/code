package com.irs.controller;

import com.irs.pojo.ShopProduct;
import com.irs.service.ProductService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.irs.annotation.SysLog;
import com.irs.pojo.TbCarousel;
import com.irs.service.CarouselService;
import com.irs.util.ResultUtil;

import java.util.List;

@Controller
@RequestMapping("carousel/")
public class CarouselController {
	@Autowired
	private CarouselService carouselServiceImpl;

	@Autowired
	private ProductService productService;


	@RequestMapping("/carouselList")
	public String carouselList() {
		return "page/carousel/carouselList";
	}
	
	@RequiresPermissions("carousel:carousel:save")
	@RequestMapping("/addCarousel")
	public String addCarousel(Model model) {
		List<ShopProduct> productList=productService.getProdtct();
		model.addAttribute("productList",productList);
		return "page/carousel/addCarousel";
	}
	
	@RequiresPermissions("carousel:carousel:save")
	@RequestMapping("/editCarousel")
	public String editCarousel(Integer id,Model model) {
		TbCarousel carousel=carouselServiceImpl.selCarouselById(id);
		model.addAttribute("carousel",carousel);
		List<ShopProduct> productList=productService.getProdtct();
		model.addAttribute("productList",productList);
		return "page/carousel/editCarousel";
	}
	
	@RequestMapping("/list")
	@RequiresPermissions("carousel:carousel:list")
	@ResponseBody
	public ResultUtil getCarouseList(Integer page,Integer limit) {
		ResultUtil carousels = carouselServiceImpl.selCarousels(page, limit);
		return carousels;
	}

	/**
	 * 添加轮播信息
	 * @param carousel
	 * @return
	 */
	@SysLog(value="添加轮播信息")
	@RequestMapping("/save")
	@RequiresPermissions("carousel:carousel:save")
	@ResponseBody
	public ResultUtil insCarousel(TbCarousel carousel) {
		try {
			carouselServiceImpl.insCarouselService(carousel);
			return ResultUtil.ok();
		} catch (Exception e) {
			return ResultUtil.error("添加出错,稍后再试！");
		}
	}
	
	/**
	 * 更新轮播信息
	 * @return
	 */
	@SysLog(value="更新轮播图状态")
	@RequestMapping("/update/{id}/{status}")
	@RequiresPermissions("carousel:carousel:update")
	@ResponseBody
	public ResultUtil updCarouselStatusById(@PathVariable("id") Integer id,@PathVariable("status") Integer status) {
		try {
			carouselServiceImpl.updCarouselStatusById(id,status);
			return ResultUtil.ok();
		} catch (Exception e) {
			return ResultUtil.error("修改出错,稍后再试！");
		}
	}
	
	/**
	 * 删除指定的轮播图
	 * @param id
	 * @return
	 */
	@SysLog(value="删除指定的轮播图")
	@RequestMapping("/delete")
	@RequiresPermissions("carousel:carousel:delete")
	@ResponseBody
	public ResultUtil delCarouselById(Integer id) {
		try {
			carouselServiceImpl.delCarouselById(id);
			return ResultUtil.ok();
		} catch (Exception e) {
			return ResultUtil.error("修改出错,稍后再试！");
		}
	}
	
	/**
	 * 批量删除轮播图
	 * @param carouselStr
	 * @return
	 */
	@SysLog(value="批量删除轮播图")
	@RequestMapping("/deletes")
	@RequiresPermissions("carousel:carousel:delete")
	@ResponseBody
	public ResultUtil delCarousels(String carouselStr) {
		try {
			carouselServiceImpl.delCarouselByIds(carouselStr);
			return ResultUtil.ok();
		} catch (Exception e) {
			return ResultUtil.error("删除出错,稍后再试！");
		}
	}
	
	/**
	 * 更新轮播图
	 * @param carousel
	 * @return
	 */
	@SysLog(value="更新轮播图")
	@RequestMapping("/update")
	@RequiresPermissions("carousel:carousel:update")
	@ResponseBody
	public ResultUtil updCarousel(TbCarousel carousel) {
		try {
			carouselServiceImpl.updCarouselService(carousel);
			return ResultUtil.ok();
		} catch (Exception e) {
			return ResultUtil.error("删除出错,稍后再试！");
		}
	}
}
