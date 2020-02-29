package com.lagou.test;

import com.lagou.Dao.IUserDao;
import com.lagou.io.Resources;
import com.lagou.pojo.User;
import com.lagou.sqlSeesion.SqlSeesionFactory;
import com.lagou.sqlSeesion.SqlSeesionFactoryBuilder;
import com.lagou.sqlSeesion.Sqlsession;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * 学习作业
 */
public class StudyAssignment {

    private IUserDao userDao;

    @Before
    public void before() throws Exception {
        InputStream resourceAsSteam = Resources.getResourceAsSteam("sqlMapConfig.xml");
        SqlSeesionFactory sqlSeesionFactory = new SqlSeesionFactoryBuilder().build(resourceAsSteam);
        Sqlsession sqlsession = sqlSeesionFactory.openSession();
        userDao = sqlsession.getMapper(IUserDao.class);

    }


    /**
     * 新增用户
     */
    @Test
    public void insertUser(){
        User user = new User();
        user.setId(3);
        user.setUsername("lisi");
        int insert = userDao.insertUser(user);
        System.out.println("新增记录数：{}" + insert);
    }

    /**
     * 更新用户
     */
    @Test
    public void updateUser(){
        User user = new User();
        user.setId(3);
        user.setUsername("zhaoliu");
        int insert = userDao.updateUser(user);
        System.out.println("更新记录数：{}" + insert);
    }

    /**
     * 查询用户
     */
    @Test
    public void selectUser() throws Exception {
        User user = new User();
        user.setId(2);
        user.setUsername("zhangsan");
        User User = userDao.findByCondition(user);
        System.out.println("查询用户信息：{}" + User);
    }

    /**
     * 删除用户
     */
    @Test
    public void deleteUser(){

        int delete = userDao.deleteUser(3);
        System.out.println("删除记录数：{}" + delete);
    }
}
