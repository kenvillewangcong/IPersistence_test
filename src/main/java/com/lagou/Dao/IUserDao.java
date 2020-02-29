package com.lagou.Dao;

import com.lagou.pojo.User;

import java.util.List;

public interface IUserDao {

    // 查询所有用户
    List<User> findAll() throws Exception;

    // 根据条件查询
    User findByCondition(User user) throws Exception;

    /**
     * 新增
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 更新
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 删除
     * @param id
     * @return
     */
    int deleteUser(Integer id);
}
