package com.example.test.Repository;

import com.example.test.Bean.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
        public List<User> findByUserName(String userName); //通过UserName查询

     /*   public List<User> findByUserMailbox(String userMailbox);//通过Mailbox查询

        public List<User> findByUserToken(String token);//通过UserToken查询*/
}

