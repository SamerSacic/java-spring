package com.sascode.userservice.service;

import com.sascode.userservice.domain.Role;
import com.sascode.userservice.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void saveRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
