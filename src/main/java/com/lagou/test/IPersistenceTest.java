package com.lagou.test;

import com.lagou.Dao.IUserDao;
import com.lagou.io.Resources;
import com.lagou.pojo.User;
import com.lagou.sqlSeesion.SqlSeesionFactory;
import com.lagou.sqlSeesion.SqlSeesionFactoryBuilder;
import com.lagou.sqlSeesion.Sqlsession;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class IPersistenceTest {

    @Test
    public void test() throws Exception {

        InputStream resourceAsSteam = Resources.getResourceAsSteam("sqlMapConfig.xml");
        SqlSeesionFactory sqlSeesionFactory = new SqlSeesionFactoryBuilder().build(resourceAsSteam);
        Sqlsession sqlsession = sqlSeesionFactory.openSession();

        // 调用
        User user = new User();
        user.setId(1);
        user.setUsername("张三");
        /*User user2 = sqlsession.selectOne("user.selectOne", user);
        System.out.println(user2);*/

        IUserDao iUserDao = sqlsession.getMapper(IUserDao.class);
        List<User> userList = iUserDao.findAll();
        System.out.println(userList);


    }

}
