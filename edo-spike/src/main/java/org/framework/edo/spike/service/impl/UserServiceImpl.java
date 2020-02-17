package org.framework.edo.spike.service.impl;

import org.framework.edo.spike.dao.UserDao;
import org.framework.edo.spike.model.User;
import org.framework.edo.spike.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User selectByPrimaryKey(String id) {
        Long lo = Long.valueOf(id);
        return userDao.selectByPrimaryKey(lo);
    }
}
