package com.irs.service;

import com.irs.pojo.Level;
import com.irs.util.ResultUtil;

public interface LevelService {
    public Level selLevelById(Integer id);

    public ResultUtil setLevel(Integer page, Integer limit);


    public   void insLevel(Level level);

    public void updLevel(Level level);

    public void delLevelById(Integer id);

    public void delLevel(String carouselStr);

    public Level checkLevelByleName(String leName);
}