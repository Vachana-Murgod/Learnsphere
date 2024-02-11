package com.example.demo.Service;

import com.example.demo.entity.Users;

public interface UserService {
    //add new user to database 
	String adduser(Users user);
   //check email is already present or not
   boolean checkEmail(String email);
   //validate user's credentials
   boolean validate(String email,String password);
   //get users role by providing email
   String getUserRole(String email);
}
