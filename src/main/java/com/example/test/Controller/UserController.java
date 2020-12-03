package com.example.test.Controller;

import com.example.test.Bean.ApiResult;
import com.example.test.Bean.User;
import com.example.test.Repository.UserRepository;
import com.example.test.Service.UserOperate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserOperate userRepo;
    @RequestMapping("/getUsers")
    public ApiResult getUserList() {
        List<User> data =new ArrayList<>();
        ApiResult apiResult = new ApiResult();
        try {
            data= (List<User>) userRepository.findAll();
            apiResult.setCode(300);
            apiResult.setStatus("success");
            apiResult.setMessage("test");
        }catch (Exception e){
            apiResult.setCode(0);
            apiResult.setStatus(String.valueOf(e));
        }

        apiResult.setData("get"+data.size());//需要返回的信息
        return apiResult;

    }
    @RequestMapping("/getUser/{name}")
    public ApiResult getUser(@PathVariable("name") String name) {
        List<User> data =new ArrayList<>();
        ApiResult apiResult = new ApiResult();
        try {
            data=userRepository.findByUserName(name);
            apiResult.setCode(300);
            apiResult.setStatus("success");
            apiResult.setMessage("test");
        }catch (Exception e){
            apiResult.setCode(0);
            apiResult.setStatus(String.valueOf(e));
        }

        apiResult.setData(data.get(0));//需要返回的信息
        return apiResult;

    }
    @RequestMapping("/getUser/{name}/pass={password}")
    public ApiResult setUser(@PathVariable("password") String pass,@PathVariable("name") String name) {
        ApiResult apiResult = new ApiResult();
        User user=new User();
        try {
            user=userRepo.findByUserName(name).get(0);
            logger.info(user.getUserName()+user.getUserPassword());
            user.setUserPassword(pass);
            userRepo.update(user);
            apiResult.setCode(300);
            apiResult.setStatus("success");
            apiResult.setMessage("test");
        }catch (Exception e){
            apiResult.setCode(0);
            apiResult.setStatus(String.valueOf(e));
        }

        apiResult.setData(user);//需要返回的信息
        return apiResult;

    }
}


