package com.lanzan.service.imp;

import com.lanzan.dao.MeunMapper;
import com.lanzan.entity.Meun;
import com.lanzan.service.MeunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "meunService")
public class MeunServiceImp implements MeunService {

    @Autowired
    private MeunMapper meunMapper;

    //根据角色编号获取菜单
    public StringBuffer getMenus(int rid) {
        StringBuffer stringBuffer = new StringBuffer();
        boolean b = false;
        //开始
        stringBuffer.append("[");
        List<Meun> menus = meunMapper.getMenus(rid);
        for (Meun menu : menus) {
            if(menu.getMgrade() == 0){
                //加逗号
                if (b){
                    stringBuffer.append(",");
                }else{
                    //第一次  不加逗号  将count变为1
                    b = true;
                }
                //加节点内容
                //开始
                stringBuffer.append("{");
                //菜单名
                stringBuffer.append("\"title\":\""+menu.getMname()+"\",");
                //菜单图标
                stringBuffer.append("\"icon\":\""+menu.getMicon()+"\",");
                //菜单路径
                stringBuffer.append("\"href\":\""+menu.getMurl()+"\",");
                //菜单路径
                stringBuffer.append("\"spread\":"+menu.getMstate());
                //判断是否有子菜单
                if (getChildren(menu,menus)!=null){
                    stringBuffer.append(",\"children\": [");
                    stringBuffer.append(getChildren(menu,menus));
                    stringBuffer.append("]");
                }
                //结束
                stringBuffer.append("}");
            }
        }
        //结束
        stringBuffer.append("]");
        return stringBuffer;
    }

    //子菜单
    public String getChildren(Meun menu,List<Meun> menus){
        StringBuffer stringBuffer = new StringBuffer();
        boolean b = false;
        for (Meun u_menu : menus) {
            if (menu.getMid() == u_menu.getMparent()){
                //查询到子菜单 判断是否添加逗号
                if(b){
                    stringBuffer.append(",");
                }else{
                    b = true;
                }
                //开始
                stringBuffer.append("{");
                //菜单名
                stringBuffer.append("\"title\": \""+u_menu.getMname()+"\",");
                //菜单图标
                stringBuffer.append("\"icon\": \""+u_menu.getMicon()+"\",");
                //菜单名
                stringBuffer.append("\"href\": \""+u_menu.getMurl()+"\",");
                //菜单名
                stringBuffer.append("\"spread\": "+u_menu.getMparent());
                //结束
                stringBuffer.append("}");
            }
        }
        if (b){
            return stringBuffer.toString();
        }else{
            return null;
        }
    }
}
