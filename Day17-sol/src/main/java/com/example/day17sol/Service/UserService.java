package com.example.day17sol.Service;

import com.example.day17sol.ApiException.ApiException;
import com.example.day17sol.Model.User;
import com.example.day17sol.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void addAllUsers(User user){
        userRepository.save(user);
    }

    public boolean updateUser(User user,Integer id){
        User oldUser=userRepository.getById(id);

        if(oldUser==null){
            return false;
        }
        oldUser.setName(user.getName());
        oldUser.setUsername(user.getUsername());
        oldUser.setPassword(user.getPassword());
        oldUser.setEmail(user.getEmail());
        oldUser.setRole(user.getRole());
        oldUser.setAge(user.getAge());

        userRepository.save(oldUser);
        return true;
    }

    public boolean deleteUser(Integer id){
        User oldUser=userRepository.getById(id);

        if(oldUser==null){
            return false;
        }
        userRepository.delete(oldUser);
        return true;
    }









    public User findUserByEmail(String email){
        User user=userRepository.findUserByEmail(email);
        if(user==null){
            throw new ApiException("email not found");
        }
        return user;

    }

    public List<User> findAllByRole(String role){
        List<User> userList=userRepository.findAllByRole(role);
        if(userList==null){
            throw new ApiException("role not found");
        }
        return userList;
    }

    public List<User> findAllByAgeGreaterThanEqual(int age){
        List<User> userList=userRepository.findAllByAgeGreaterThanEqual(age);
        if(userList==null){
            throw new ApiException("age not found");
        }
        return userList;
    }


    public User check(String username,String password){
        User user=userRepository.check(username,password);
        if(user==null){
            throw new ApiException("username or password don't match");
        }
        return user;
    }





}
