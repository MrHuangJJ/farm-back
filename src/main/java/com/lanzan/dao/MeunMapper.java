package com.lanzan.dao;

import com.lanzan.entity.Meun;

import java.util.List;

public interface MeunMapper {

    //根据角色id 拿取菜单
    public List<Meun> getMenus(int rid);
}
