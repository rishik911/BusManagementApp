package com.busManagament.app.service.user;

import com.busManagament.app.model.User;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
    void createUser(User user);

    User getUserById(int userId);

    void updateUser(User user);

    void deleteUser(int userId);

    User validateUser(String userName, String Password) throws Exception;

    User findByUserName(String username);
//    List<User> getAllUsers();
}
