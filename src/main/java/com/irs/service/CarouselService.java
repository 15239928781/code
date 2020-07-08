package com.irs.service;

import com.irs.pojo.TbCarousel;
import com.irs.util.ResultUtil;
import com.irs.util.WxResult;

import javax.servlet.http.HttpServletRequest;

public interface CarouselService {
	//获取轮播图
	public ResultUtil selCarousels(Integer page,Integer limit);

	//添加轮播信息
	public void insCarouselService(TbCarousel carousel);

	public void updCarouselStatusById(Integer id, Integer status);

	public void delCarouselById(Integer id);

	public void delCarouselByIds(String carouselStr);

	public TbCarousel selCarouselById(Integer id);

	public void updCarouselService(TbCarousel carousel);

    WxResult getAllPic(HttpServletRequest request);

    WxResult getGroupPic(HttpServletRequest request);

    WxResult getAllPicPC(HttpServletRequest request);
}
