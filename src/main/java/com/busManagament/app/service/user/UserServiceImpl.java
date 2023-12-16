package com.busManagament.app.service.user;

import com.busManagament.app.model.User;
import com.busManagament.app.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userDao;  // Assuming you have a UserRepository interface


    public void createUser(User user) {
        userDao.save(user);
    }

    @Override
    public User getUserById(int userId) {
        return userDao.findById(String.valueOf(userId)).orElse(null);
    }

    @Override
    public void updateUser(User user) {
        userDao.save(user);
    }

    @Override
    public void deleteUser(int userId) {
        userDao.deleteById(String.valueOf(userId));
    }

    @Override
    public User validateUser(String userName, String password) throws Exception {
        User user = userDao.findByUsername(userName);
        if (user == null) throw new Exception("User not found");

        if (!password.equals(user.getPassword())) throw new Exception("Incorrect password");

        return user;

    }

    @Override
    public User findByUserName(String username){
        return userDao.findByUsername(username);
    }

}
