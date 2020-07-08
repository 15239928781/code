package com.irs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.irs.annotation.MyException;
import com.irs.mapper.*;
import com.irs.pojo.*;
import com.irs.service.UsersService;
import com.irs.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class UsersServiceImpl implements UsersService {



    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private SvlMapper svlMapper;
    @Autowired
    private SubareaMapper subareaMapper;
    @Autowired
    private LevelMapper levelMapper;

    @Autowired
    private IntegralsMapper integralsMapper;

    final int INTEGRAL = 10;

    @Override
    public void setvip(String leId, String uId){
        Users users= usersMapper.selectByPrimaryKey(Integer.parseInt(uId));
        Level level=  levelMapper.selectByPrimaryKey(Integer.parseInt(leId));
        users.setuIntegral(level.getLeMinscore());
        users.setuLevel(level.getLeId());
        usersMapper.updateByPrimaryKey(users);
    }



    @Override
    public ResultUtil selUsers(Integer page, Integer limit, UserSearch search) {
        PageHelper.startPage(page, limit);
        UsersExample example=new UsersExample();
        example.setOrderByClause("u_createtime DESC");
        UsersExample.Criteria criteria=example.createCriteria();
        if(search.getNickname()!=null &&!"".equals(search.getNickname())){
            criteria.andUTelLike("%"+search.getNickname()+"%");
        }
        if(search.getSex()!=null && !"".equals(search.getSex())) criteria.andUSexEqualTo(search.getSex());
        if(search.getCreateTimeStart()!=null&&!"".equals(search.getCreateTimeStart())){
            criteria.andUCreatetimeLessThanOrEqualTo(search.getCreateTimeStart());
        }
        if(search.getCreateTimeEnd()!=null&&!"".equals(search.getCreateTimeEnd())){
            criteria.andUCreatetimeLessThanOrEqualTo(search.getCreateTimeEnd());
        }
        List<Users> list=usersMapper.selectByExample(example);

        List<Level> levels = levelMapper.selectByExample(null);

        for (Users users : list) {
            //Level level=levelMapper.selectByPrimaryKey(users.getuLevel());



            for (Level levelw : levels) {
                if (levelw != null) {
                    if (users.getuIntegral() >= levelw.getLeMinscore() && users.getuIntegral() < levelw.getLeMaxscore()) {
                        users.setuLevel(levelw.getLeId());
                        users.setLevelName(levelw.getLeName());
                        usersMapper.updateByPrimaryKeySelective(users);
                    }
                }
            }
        }
        PageInfo<Users> pageInfo = new PageInfo<>(list);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
        /*List<Level> levels = levelMapper.selectByExample(null);
        for (Level level : levels){
            if (integral > level.getLeMinscore() && integral < level.getLeMaxscore()) {
                users.setuLevel(level.getLeId());
                int b =usersMapper.updateByPrimaryKeySelective(users);
                if (b == 0) {
                    MyException myException=new MyException();
                    myException.setData(WxResult.build(400,"注册失败了，重新注册试试"));
                    throw myException;
                }
            }
        }*/
    }

    @Override
    public void delUsersService(String userStr) {
        String[] users = userStr.split(",");
        List<Integer> uIds=new ArrayList<Integer>();
        if(users!=null&&users.length>0){
            for (String uid : users) {
               uIds.add(Integer.valueOf(uid));
            }
        }
        UsersExample example=new UsersExample();
        UsersExample.Criteria criteria=example.createCriteria();
        criteria.andUIdIn(uIds);
        usersMapper.deleteByExample(example);
    }

    @Override
    public void delUserByUid(String uid) {
        usersMapper.deleteByPrimaryKey(Integer.valueOf(uid));
    }
    @Override
    public WxResult getUserByIdPC(String token) {
        /*try {
            usersMapper.selectByPrimaryKey(uId);

        } catch (Exception e) {
            return WxResult.fail("更新失败！");
        }*/
       // Users users=usersMapper.selectByPrimaryKey(uId);
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andUWxcodeEqualTo(token);
        List<Users> users = usersMapper.selectByExample(usersExample);
        if(0<users.size()&&users.size()<=1){
            return WxResult.ok(users);
        }
        return WxResult.fail("uid不存在");
    }
    @Override
    public WxResult getUserById(int uId) {
        try {
            usersMapper.selectByPrimaryKey(uId);
        } catch (Exception e) {
            return WxResult.fail("更新失败！");
        }
        Users users=usersMapper.selectByPrimaryKey(uId);

        LevelExample levelExample = new LevelExample();
        List<Level> levels = levelMapper.selectByExample(levelExample);
    for(Level level:levels){
    if(users.getuIntegral()>=level.getLeMinscore()&&users.getuIntegral()<level.getLeMaxscore()){
        users.setuLevel(level.getLeId());

    }
}

        Level level = levelMapper.selectByPrimaryKey(users.getuLevel());
        users.setLevelName(level.getLeName());
        users.setLeId(level.getLeId());

        usersMapper.updateByPrimaryKey(users);
        SvlExample svlExample = new SvlExample();
        SvlExample.Criteria criteria = svlExample.createCriteria();
        criteria.andLeIdEqualTo(level.getLeId());

        List<Svl> svls = svlMapper.selectByExample(svlExample);
if(!svls.isEmpty()){
    users.setSbId(svls.get(0).getSbId());
    Subarea subarea = subareaMapper.selectByPrimaryKey(svls.get(0).getSbId());
    users.setSbName(subarea.getSbName());

    // users.setSbName(svls.get(0));
}
        users.setuPassword(null);
        List<Users> usersList=new ArrayList<>();
        if (users!=null){
            usersList.add(users);
        }
        return WxResult.ok(usersList);
    }

    @Override
    public WxResult editUserInfo(Users user) {
        try {
            //Users users = usersMapper.selectByPrimaryKey(user.getuId());
            usersMapper.updateByPrimaryKeySelective(user);
        } catch (Exception e) {
            return WxResult.fail("更新失败！");
        }

        return WxResult.ok();
    }

    @Override
    public WxResult login(String account, String loginpwd, HttpServletRequest request) {
        UsersExample example=new UsersExample();
        //example.or().andUTelEqualTo(account);
        UsersExample.Criteria criteria = example.createCriteria();
        criteria.andURealnameEqualTo(account);
        List<Users> list=usersMapper.selectByExample(example);
        if (list == null || list.size() == 0) {
            return WxResult.build(400, "账号或密码错误！");
        }
        //loginpwd = MD5Utils.md5(loginpwd);
        if (!(list.get(0).getuPassword().equals(loginpwd))) {
            return WxResult.build(400, "账号或密码错误！");
        }
        Map map=new HashMap();
        String token = UUID.randomUUID().toString();
        Users u=list.get(0);
        u.setuId(u.getuId());
        u.setuWxcode(token);
        // u.setToken(token);
        usersMapper.updateByPrimaryKeySelective(u);
        u.setuPassword(null);
        map.put("token", token);
        map.put("uId", u.getuId());
        HttpSession session = request.getSession();
        session.setAttribute("uid",u.getuId());
//        map.put("comId", com)
        return WxResult.ok(map);
    }

    @Transactional
    @Override
    public WxResult register(Users user) {
        Date d = new Date();
        Map map=new HashMap();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            //查询手机号是否注册过
            UsersExample example=new UsersExample();
            UsersExample.Criteria criteria = example.createCriteria();
            criteria.andUTelEqualTo(user.getuTel());
            List<Users> list=usersMapper.selectByExample(example);
            if(list.size()>0&&list!=null){
                return WxResult.build(400, "这个手机号注册过了呢,去登陆吧");
            }
            user.setuPassword(MD5Utils.md5(user.getuPassword()));
            user.setuCreatetime(sf.format(d));
            //判断是否是有邀请人
            if (user.getuInvitecode() == null || "".equals(user.getuInvitecode())) {
                //没有邀请人插入数据
                int a=usersMapper.insertSelective(user);
                if (a == 0) {
                    MyException myException=new MyException();
                    myException.setData(WxResult.build(400,"注册失败了，重新注册试试"));
                    throw myException;
                }
            } else {
                //如果有邀请人
                //插入记录
                int a=usersMapper.insertSelective(user);
                if (a == 0) {
                    MyException myException=new MyException();
                    myException.setData(WxResult.build(400,"注册失败了，重新注册试试"));
                    throw myException;
                }
                //查询是否有这个人
                UsersExample example1 = new UsersExample();
                UsersExample.Criteria criteria1 = example1.createCriteria();
                criteria1.andUMyinvitecodeEqualTo(user.getuInvitecode());
                List<Users> list1 = usersMapper.selectByExample(example1);
                if (list1 == null || list1.size() <= 0) {
                    MyException myException=new MyException();
                    myException.setData(WxResult.build(400,"请正确输入邀请码"));
                    throw myException;
                } else {

                    //更新邀请人的积分
                    Integrals integrals = new Integrals();
                    integrals.setiType(1);
                    integrals.setiNum(INTEGRAL);
                    integrals.setiAddtime(CommonUtils.nowtime());
                    integrals.setuId(list1.get(0).getuId());
                    int insertnum = integralsMapper.insertSelective(integrals);
                    if (insertnum >= 1) {
                        int integral=integralsMapper.sumIntegral(1, list1.get(0).getuId());
                        //更新邀请人的会员等级
                        Users users = new Users();
                        users.setuId(list1.get(0).getuId());
                        users.setuIntegral(integral);
                        //查询会员等级
                        List<Level> levels = levelMapper.selectByExample(null);
                        for (Level level : levels){
                            if (integral > level.getLeMinscore() && integral < level.getLeMaxscore()) {
                                users.setuLevel(level.getLeId());
                                int b =usersMapper.updateByPrimaryKeySelective(users);
                                if (b == 0) {
                                    MyException myException=new MyException();
                                    myException.setData(WxResult.build(400,"注册失败了，重新注册试试"));
                                    throw myException;
                                }
                            }
                        }
                    } else {
                        MyException myException=new MyException();
                        myException.setData(WxResult.build(400,"注册失败了，重新注册试试"));
                        throw myException;
                    }
                }
            }
            //通过手机号查询其id
            UsersExample uexample = new UsersExample();
            UsersExample.Criteria ucirteria = uexample.createCriteria();
            ucirteria.andUTelEqualTo(user.getuTel());
            List<Users> u = usersMapper.selectByExample(uexample);
            int uid = u.get(0).getuId();
            //更新用户的邀请码
            String myinvitecode = ShareCodeUtil.toSerialCode(uid);
            Users users = new Users();
            users.setuId(u.get(0).getuId());
            users.setuMyinvitecode(myinvitecode);
            int c = usersMapper.updateByPrimaryKeySelective(users);
            if (c == 0) {
                MyException myException=new MyException();
                myException.setData(WxResult.build(400,"注册失败了，重新注册试试"));
                throw myException;
            }
            return WxResult.build(200, "注册成功！");
        }catch (MyException e) {
            throw e;
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public int insetUser(Users users) {
        return usersMapper.insertSelective(users);
    }

    @Override
    public Users selebyOpenid(String getuIntroduction) {
        UsersExample example=new UsersExample();
        example.or().andUIntroductionEqualTo(getuIntroduction);
        List<Users> usersList=usersMapper.selectByExample(example);
        if (usersList.size()>0){
            return usersList.get(0);
        }
        return null;
    }

    @Override
    public Users selectByUid(Integer getuId) {
        return usersMapper.selectByPrimaryKey(getuId);
    }

}
