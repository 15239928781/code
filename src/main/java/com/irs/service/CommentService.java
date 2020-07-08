package com.irs.service;

import com.irs.pojo.Comment;
import com.irs.util.ResultUtil;
import com.irs.util.WxResult;

import javax.servlet.http.HttpServletRequest;

public interface CommentService {
    ResultUtil getCommentList(Integer page, Integer limit, Comment search);

    void delComment(String userStr);

    void delCommentByUid(String cId);

    //通过素材id获取该素材评论
    WxResult getcommentbypid(String pid, HttpServletRequest request);
    //用户添加评论
    WxResult addcomment(String uid, String context, String pid);

    long commentNum(int pId, int i);


}
