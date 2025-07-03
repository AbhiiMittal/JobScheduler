package com.project.JobScheduler.User.service;

import com.project.JobScheduler.User.entity.User;
import com.project.JobScheduler.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getUserList() {
        try{
            return userRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User getUserDetails(Long id) {
        try{
            Optional<User> optionalUser = Optional.ofNullable(userRepository.findById(id).orElseThrow(() -> new RuntimeException("user not found")));
            return optionalUser.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String createNewUser(User user) {
        try{
            userRepository.save(user);
            return "user created successfully";
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    public String deleteUser(Long id) {
        try{
            Optional<User> optionalUser = userRepository.findById(id);
            if(optionalUser.isEmpty()){
                throw new RuntimeException("User Does Not Exists");
            }
            User user = optionalUser.get();
            userRepository.delete(user);
            return "user deleted successfully";
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}

