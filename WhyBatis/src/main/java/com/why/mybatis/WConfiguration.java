package com.why.mybatis;

import java.lang.reflect.Proxy;
import java.util.ResourceBundle;

/**
 * @author 王皓宇
 * @version V1.0
 * @title : WConfiguration
 * @Package : com.why.mybatis
 * @Description:
 * @date 2022/3/17 15:02
 **/
public class WConfiguration {
    // 存储属性文件的信息
    public static final ResourceBundle sqlMappings;

    static {
        sqlMappings = ResourceBundle.getBundle("sql");
    }

    public <T> T getMapper(Class clazz, SqlSession sqlSession) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{clazz},
                new MapperProxy(sqlSession));
    }
}
