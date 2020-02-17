package org.framework.edo.spike.service;

import org.framework.edo.spike.model.User;

public interface UserService {
    User selectByPrimaryKey(String id);
}
