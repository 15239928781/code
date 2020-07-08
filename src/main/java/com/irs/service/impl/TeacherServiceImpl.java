package com.irs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.irs.mapper.TeacherMapper;
import com.irs.pojo.Teacher;
import com.irs.pojo.TeacherExample;
import com.irs.service.TeacherService;
import com.irs.util.ResultUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<Teacher> getAll() {
        TeacherExample example=new TeacherExample();
        return teacherMapper.selectByExample(example);
    }

    @Override
    public Teacher selTeacherById(Integer id) {
        return teacherMapper.selectByPrimaryKey(id);
    }

    @Override
    public ResultUtil getTeacherList(Integer page, Integer limit,Teacher teacher) {
        PageHelper.startPage(page, limit);
        TeacherExample example=new TeacherExample();
        example.setOrderByClause("t_id desc");
        TeacherExample.Criteria criteria=example.createCriteria();
        if (teacher.gettName()!=null && !"".equals(teacher.gettName())){
            criteria.andTNameLike("%"+teacher.gettName()+"%");
        }
        List<Teacher> list=teacherMapper.selectByExample(example);
        PageInfo<Teacher> pageInfo=new PageInfo<>(list);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public void insTeacher(Teacher teacher) {
        teacherMapper.insertSelective(teacher);
    }

    @Override
    public void delTeacherById(Integer id) {
        teacherMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void delTeacher(String carouselStr) {
        if(!StringUtils.isBlank(carouselStr)){
            String[] ids=carouselStr.split(",");
            for (String id : ids) {
                teacherMapper.deleteByPrimaryKey(Integer.parseInt(id));
            }
        }
    }

    @Override
    public void updTeacher(Teacher teacher) {
        teacherMapper.updateByPrimaryKeySelective(teacher);
    }
}
