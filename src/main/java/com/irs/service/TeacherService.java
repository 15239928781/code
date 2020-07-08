package com.irs.service;

import com.irs.pojo.ShopCategory;
import com.irs.pojo.Teacher;
import com.irs.util.ResultUtil;

import java.util.List;

public interface TeacherService {
    List<Teacher> getAll();

    Teacher selTeacherById(Integer id);

    ResultUtil getTeacherList(Integer page, Integer limit,Teacher teacher);

    void insTeacher(Teacher teacher);

    void delTeacherById(Integer id);

    void delTeacher(String carouselStr);

    void updTeacher(Teacher teacher);
}
