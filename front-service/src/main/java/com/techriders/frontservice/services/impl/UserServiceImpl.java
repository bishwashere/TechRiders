package com.techriders.frontservice.services.impl;

import com.techriders.frontservice.domains.User;
import com.techriders.frontservice.repositories.UserRepository;
import com.techriders.frontservice.services.UserRoleService;
import com.techriders.frontservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.transaction.Transactional;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }


    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    @Override
    public User findByUserName(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User FindById(Long id) {
         Optional<User> userOptional = userRepository.findById(id);
         if(userOptional.isPresent()){
             return userOptional.get();
         }
        return null;
    }

    @Override
    public boolean acceptById(Long id) {
        if(userRepository.changeStatus((short) 1,id)>0){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public boolean declinedById(Long id) {
        if(userRepository.changeStatus((short) 2,id)>0){
            return true;
        }else{
            return false;
        }
    }


    @Override
    public User findById(long id) {
         Optional<User> userOptional= userRepository.findById(id);
         try{
             return (User)userOptional.get();
         }catch (NoSuchElementException e){

             return null;
         }
    }

    @Override
    public List<User> findTop10ByFirstName(String firstName) {
        return userRepository.findTop10ByFirstNameContaining(firstName);
    }
}
