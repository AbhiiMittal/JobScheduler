package com.project.JobScheduler.User.service;

import com.project.JobScheduler.User.entity.User;

import java.util.List;

public interface UserService {
    List<User> getUserList();
    User getUserDetails(Long id);
    String createNewUser(User user);
    String deleteUser(Long id);
}
