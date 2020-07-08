package com.irs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.irs.mapper.CommentMapper;
import com.irs.mapper.UsersMapper;
import com.irs.pojo.Comment;
import com.irs.pojo.CommentExample;
import com.irs.pojo.Users;
import com.irs.service.CommentService;
import com.irs.util.MyUtil;
import com.irs.util.ResultUtil;
import com.irs.util.WxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.beans.Encoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public ResultUtil getCommentList(Integer page, Integer limit, Comment search) {
        PageHelper.startPage(page, limit);
        CommentExample example=new CommentExample();
        example.setOrderByClause("c_createtime desc");
        CommentExample.Criteria criteria=example.createCriteria();
        criteria.andPIdEqualTo(search.getpId());
        if(search.getCreateTimeStart()!=null&&!"".equals(search.getCreateTimeStart())){
            criteria.andCCreatetimeGreaterThanOrEqualTo(search.getCreateTimeStart());
        }
        if(search.getCreateTimeEnd()!=null&&!"".equals(search.getCreateTimeEnd())){
            criteria.andCCreatetimeGreaterThanOrEqualTo(search.getCreateTimeEnd());
        }
        List<Comment> list=commentMapper.selectByExample(example);
        for (Comment comment : list) {
            Users users=usersMapper.selectByPrimaryKey(comment.getuId());
            if(users!=null){
                comment.setuName(users.getuName());
            }


        }
        PageInfo<Comment> pageInfo=new PageInfo<>(list);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public void delComment(String userStr) {
        String[] users = userStr.split(",");
        if(users!=null&&users.length>0){
            for (String uid : users) {
                commentMapper.deleteByPrimaryKey(Integer.parseInt(uid));
            }
        }
    }

    @Override
    public void delCommentByUid(String cId) {
        commentMapper.deleteByPrimaryKey(Integer.parseInt(cId));
    }

    //添加评论
    @Override
    public WxResult addcomment(String uid, String context,String pid) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String critime = df.format(new Date());
            Comment comment = new Comment();
            comment.setpId(Integer.parseInt(pid));
            comment.setuId(Integer.parseInt(uid));
            comment.setcContent(context);
            comment.setcCreatetime(critime);
            int result = commentMapper.insert(comment);
            return WxResult.build(200, "评论成功");
        } catch (Exception e) {
            return WxResult.fail("评论失败");
        }
    }

    @Override
    public long commentNum(int pId, int i) {
        CommentExample example=new CommentExample();
        CommentExample.Criteria criteria=example.createCriteria();
        criteria.andR2EqualTo(String.valueOf(i));
        return commentMapper.countByExample(example);
    }

    //通过素材id获取该素材所有评论
    @Override
    public WxResult getcommentbypid(String pId, HttpServletRequest request) {
        String saveUrl=request.getScheme() + "://"+request.getServerName()+":" +
                request.getServerPort()+"/ssm/file/showPic?fileName=";
        CommentExample example = new CommentExample();
        CommentExample.Criteria criteria = example.createCriteria();
        criteria.andPIdEqualTo(Integer.parseInt(pId));
        List<Comment> list=commentMapper.selectByExample(example);
        for (Comment comment:list){
            Users users = usersMapper.selectByPrimaryKey(comment.getuId());
            comment.setuName(users.getuName());
            comment.setUimg(users.getuImg());
        }
        return WxResult.ok(list);
    }
}
