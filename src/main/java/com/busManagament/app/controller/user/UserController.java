package com.busManagament.app.controller.user;

import com.busManagament.app.model.User;
import com.busManagament.app.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {


    @Autowired
    private UserService userService;

    // create a new user
    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        // Implement logic to create a new user
        userService.createUser(user);
        return ResponseEntity.ok("User created successfully");
    }

    // get user details
    @GetMapping("/getUser/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable int userId) {
        // Implement logic to retrieve user details
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    // Update user
    @PutMapping("/updateUser")
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        // Implement logic to update user details
        userService.updateUser(user);
        return ResponseEntity.ok("User updated successfully");
    }

    // Delete user
    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable int userId) {
        // Implement logic to delete user
        userService.deleteUser(userId);
        return ResponseEntity.ok("User deleted successfully");
    }
}
