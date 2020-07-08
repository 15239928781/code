package com.irs.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.irs.mapper.ShopProductCollectionMapper;
import com.irs.mapper.ShopProductMapper;
import com.irs.pojo.ShopProduct;
import com.irs.pojo.ShopProductCollection;
import com.irs.pojo.ShopProductCollectionExample;
import com.irs.pojo.ShopProductExample;
import com.irs.service.ShopProductCollectionService;
import com.irs.util.WxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShopProductCollectionServiceImpl implements ShopProductCollectionService {

	@Autowired
	private ShopProductCollectionMapper productCollectionMapper;

	@Autowired
	private ShopProductMapper shopProductMapper;

	/*
	 * 添加收藏
	 */
	@Override
	public WxResult careProduct(String uid,String pid) {
		//查询用户是否收藏了这个素材
		ShopProductCollectionExample example = new ShopProductCollectionExample();
		ShopProductCollectionExample.Criteria criteria = example.createCriteria();
		criteria.andUIdEqualTo(Integer.parseInt(uid));
		criteria.andPIdEqualTo(Integer.parseInt(pid));
		List<ShopProductCollection> lists = productCollectionMapper.selectByExample(example);
		if (lists.size() == 0) {
			//如果没有收藏   收藏
			ShopProductCollection productCollection = new ShopProductCollection();
			productCollection.setuId(Integer.parseInt(uid));
			productCollection.setpId(Integer.parseInt(pid));
			int colloction = productCollectionMapper.insert(productCollection);
			JSONObject jsonObject = new JSONObject();
			if (colloction == 1) {
				jsonObject.put("colloction",colloction);
				return WxResult.build(200,"收藏成功",jsonObject);
			} else {
				jsonObject.put("colloction",0);
				return WxResult.build(200,"收藏失败",jsonObject);
			}
		} else {
			//如果收藏   就取消收藏
			ShopProductCollectionExample example1 = new ShopProductCollectionExample();
			ShopProductCollectionExample.Criteria criteria1 = example1.createCriteria();
			criteria1.andUIdEqualTo(Integer.parseInt(uid));
			criteria1.andPIdEqualTo(Integer.parseInt(pid));
			int colloction = productCollectionMapper.deleteByExample(example1);
			JSONObject jsonObject = new JSONObject();
			if (colloction == 1) {
				jsonObject.put("colloction",0);
				return WxResult.build(200,"取消收藏成功",jsonObject);
			} else {
				jsonObject.put("colloction",colloction);
				return WxResult.build(200,"取消收藏失败",jsonObject);
			}
		}
	}

	/*
	 * 删除收藏
	 */
	@Override
	public WxResult cancleCare(String uid,String pid) {
		try {
			ShopProductCollectionExample example = new ShopProductCollectionExample();
			ShopProductCollectionExample.Criteria criteria = example.createCriteria();
			criteria.andUIdEqualTo(Integer.parseInt(uid));
			criteria.andPIdEqualTo(Integer.parseInt(pid));
			productCollectionMapper.deleteByExample(example);
		} catch (Exception e) {
			return WxResult.build(400, "操作失败！");
		}
		return WxResult.build(200, "删除成功！");
	}


	/*
	 * 通过用户id获取商品的收藏状态
	 */
	@Override
	public WxResult getStatus(String uId, String pId) {
		ShopProductCollectionExample example = new ShopProductCollectionExample();
		ShopProductCollectionExample.Criteria criteria = example.createCriteria();
		criteria.andUIdEqualTo(Integer.parseInt(uId));
		criteria.andPIdEqualTo(Integer.parseInt(pId));
		List<ShopProductCollection> lists = productCollectionMapper.selectByExample(example);
		if (null == lists || lists.size() <= 0) {
			return WxResult.build(202,"未收藏该素材");
		} else {
			return WxResult.build(200,"已收藏该素材");
		}
	}

	/*
	 * 通过用户id获取收藏夹
	 */
	@Override
	public WxResult getproduct(String uid, String starts, String length, HttpServletRequest request) {
		List<Integer> pcids = new ArrayList<>();
		String saveUrl=request.getScheme() + "://"+request.getServerName()+":" +
				request.getServerPort()+"/ssm/file/showPic?fileName=";
		try {
			PageHelper.startPage(Integer.parseInt(starts), Integer.parseInt(length));
			ShopProductCollectionExample example = new ShopProductCollectionExample();
			ShopProductCollectionExample.Criteria criteria = example.createCriteria();
			criteria.andUIdEqualTo(Integer.parseInt(uid));
			List<ShopProductCollection> productCollections = productCollectionMapper.selectByExample(example);
			for (ShopProductCollection pcid : productCollections){
				pcids.add(pcid.getpId());
			}
			ShopProductExample shopProductExample = new ShopProductExample();
			ShopProductExample.Criteria criteria1 = shopProductExample.createCriteria();
			criteria1.andPIdIn(pcids);
			List<ShopProduct> products = shopProductMapper.selectByExample(shopProductExample);
			for (ShopProduct shopProduct : products){
				shopProduct.setpImage(saveUrl+shopProduct.getpImage());
			}
			return WxResult.build(200, "收藏夹获取成功", products);
		} catch (Exception e) {
			return WxResult.build(200, "收藏夹没有素材哦，赶紧收藏吧！");
		}
	}
}
