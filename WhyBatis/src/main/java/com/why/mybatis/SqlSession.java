package com.why.mybatis;

/**
 * @author 王皓宇
 * @version V1.0
 * @title : SqlSession
 * @Package : com.why.mybatis
 * @Description:
 * @date 2022/3/17 15:00
 **/
public class SqlSession {
    private WConfiguration configuration;
    private Executor executor;

    public <T> T selectOne(String statementId, Object parameter) {
        String sql = WConfiguration.sqlMappings.getString(statementId);
        return executor.query(sql, parameter);
    }

    public <T> T getMapper(Class clazz) {
        return (T) configuration.getMapper(clazz, this);
    }

}
