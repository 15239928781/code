package com.irs.service.impl;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.irs.mapper.ShopCategoryMapper;
import com.irs.pojo.ShopCategory;
import com.irs.pojo.ShopCategoryExample;
import com.irs.util.WxResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.irs.mapper.TbCarouselMapper;
import com.irs.pojo.TbCarousel;
import com.irs.pojo.TbCarouselExample;
import com.irs.pojo.TbCarouselExample.Criteria;
import com.irs.service.CarouselService;
import com.irs.util.ResultUtil;

import javax.servlet.http.HttpServletRequest;

@Service
public class CarouselServiceImpl implements CarouselService {
	@Autowired
	private TbCarouselMapper tbCarouselMapper;

	@Autowired
    private ShopCategoryMapper categoryMapper;

	@Override
	public ResultUtil selCarousels(Integer page, Integer limit) {
		PageHelper.startPage(page, limit);
		TbCarouselExample example=new TbCarouselExample();
		//排序
		example.setOrderByClause("sorting DESC");
		Criteria criteria = example.createCriteria();
		List<TbCarousel> list = tbCarouselMapper.selectByExample(example);
		PageInfo<TbCarousel> pageInfo = new PageInfo<TbCarousel>(list);
		ResultUtil resultUtil = new ResultUtil();
		resultUtil.setCode(0);
		resultUtil.setCount(pageInfo.getTotal());
		resultUtil.setData(pageInfo.getList());
		return resultUtil;
	}

	@Override
	public void insCarouselService(TbCarousel carousel) {
		Date date=new Date();
		carousel.setCreateTime(date);
		carousel.setImglink("1");
		tbCarouselMapper.insert(carousel);
	}

	@Override
	public void updCarouselStatusById(Integer id, Integer status) {
		TbCarousel carousel = tbCarouselMapper.selectByPrimaryKey(id);
		carousel.setStatus(status);
		carousel.setUpdateTime(new Date());
		tbCarouselMapper.updateByPrimaryKey(carousel);
	}

	@Override
	public void delCarouselById(Integer id) {
		tbCarouselMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void delCarouselByIds(String carouselStr) {
		if(!StringUtils.isBlank(carouselStr)){
			String[] ids=carouselStr.split(",");
			for (String id : ids) {
				tbCarouselMapper.deleteByPrimaryKey(Integer.parseInt(id));
			}
		}
	}

	@Override
	public TbCarousel selCarouselById(Integer id) {
		return tbCarouselMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updCarouselService(TbCarousel carousel) {
		TbCarousel c = tbCarouselMapper.selectByPrimaryKey(carousel.getId());
		carousel.setCreateTime(c.getCreateTime());
		carousel.setUpdateTime(new Date());
		tbCarouselMapper.updateByPrimaryKey(carousel);
	}

	@Override
	public WxResult getAllPic(HttpServletRequest request) {
		String saveUrl=request.getScheme() + "://"+request.getServerName()+":" +
				request.getServerPort()+"/ssm";
		TbCarouselExample example=new TbCarouselExample();
		example.setOrderByClause("sorting");
		Criteria criteria=example.createCriteria();
		criteria.andImglinkEqualTo("1");
		criteria.andStatusEqualTo(1);
		List<TbCarousel> list=tbCarouselMapper.selectByExample(example);
		String strDirPath = request.getScheme() + "://"+request.getServerName()+":" +
				request.getServerPort();
		for (TbCarousel tbCarousel : list) {
			tbCarousel.setImgurl(strDirPath+"/ssm/file/showPic?fileName="+tbCarousel.getImgurl());
		}
		return WxResult.build(200, "ok", list);
	}

	@Override
	public WxResult getGroupPic(HttpServletRequest request) {
        Map map=new HashMap();
		TbCarouselExample example=new TbCarouselExample();
		example.setOrderByClause("sorting");
		Criteria criteria=example.createCriteria();
		criteria.andStatusEqualTo(1);
		List<TbCarousel> list=tbCarouselMapper.selectByExample(example);
		String strDirPath = request.getScheme() + "://"+request.getServerName()+":" +
				request.getServerPort();
		for (TbCarousel tbCarousel : list) {
			tbCarousel.setImgurl(strDirPath+"/ssm/file/showPic?fileName="+tbCarousel.getImgurl());
		}
		map.put("rollpicList",list);
        ShopCategoryExample example1=new ShopCategoryExample();
        List<ShopCategory> categoryList=categoryMapper.selectByExample(example1);
        map.put("categoryList",categoryList);
		return WxResult.build(200, "ok", map);
	}

	@Override
	public WxResult getAllPicPC(HttpServletRequest request) {
		String saveUrl=request.getScheme() + "://"+request.getServerName()+":" +
				request.getServerPort()+"/ssm";
		TbCarouselExample example=new TbCarouselExample();
		example.setOrderByClause("sorting");
		Criteria criteria=example.createCriteria();
		criteria.andImglinkEqualTo("1");
		criteria.andStatusEqualTo(1);
		/*criteria.andRemarkEqualTo("0");*/
		List<TbCarousel> list=tbCarouselMapper.selectByExample(example);
		String strDirPath = request.getScheme() + "://"+request.getServerName()+":" +
				request.getServerPort();
		for (TbCarousel tbCarousel : list) {
			tbCarousel.setImgurl(strDirPath+"/ssm/file/showPic?fileName="+tbCarousel.getImgurl());
		}
		return WxResult.build(200, "ok", list);
	}
}
