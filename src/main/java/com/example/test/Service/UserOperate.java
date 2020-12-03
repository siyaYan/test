package com.example.test.Service;

import com.example.test.Bean.User;
import com.example.test.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserOperate {

    @Autowired
    private UserRepository userRepository;
    public void add(User userInfo){
        User user=new User();
        user.setUserName(userInfo.getUserName());
        //user=userInfo;
        userRepository.save(user);
    }
    public void delete(int id){
        userRepository.deleteById(id);
    }
    public void update(User user){
        userRepository.save(user);
    }
    public List<User> findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }
}
