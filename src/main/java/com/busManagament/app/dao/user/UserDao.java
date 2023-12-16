package com.busManagament.app.dao.user;

import com.busManagament.app.model.User;

public interface UserDao {
    User findByUserId(String userId);

    User findByUserName(String username);

}
