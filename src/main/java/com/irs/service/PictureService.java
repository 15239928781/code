package com.irs.service;

import com.irs.pojo.ShopPicture;
import com.irs.util.WxResult;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface PictureService {
    WxResult uploadPicture(HttpServletRequest request, MultipartFile file);

    List<ShopPicture> selectByPid(Integer valueOf);

    String  selectByPid2(Integer integer);

    List<ShopPicture> selShopPictureImg(Integer valueOf);
}
