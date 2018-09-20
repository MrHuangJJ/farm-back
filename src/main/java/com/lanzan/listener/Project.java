package com.lanzan.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.File;
import java.io.IOException;

/**
 * 项目启动、关闭的监听
 */
public class Project implements ServletContextListener {


    //项目初始化时进行的操作
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("服务器开启");
        //
        File file = new File("");
        String path = null;
        try {
            path = file.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("项目路径：" + path);
    }

    //项目关闭、停止时进行的操作
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("服务器关闭");
    }

}
