package com.irs.service;


import com.irs.util.WxResult;

import javax.servlet.http.HttpServletRequest;

public interface ShopProductCollectionService {

	//添加收藏夹
	WxResult careProduct(String uid,String pid);

	//取消收藏
	WxResult cancleCare(String uid,String pid);

	//获取收藏状态
	WxResult getStatus(String uid,String pid);

	//通过用户id获取收藏夹
	WxResult getproduct(String uid, String starts, String length, HttpServletRequest request);
}
