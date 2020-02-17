package org.framework.edo.spike.dao;

import org.framework.edo.spike.model.User;

public interface UserDao {
    int deleteByPrimaryKey(Long id);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

}