package com.cydeo.service;

import com.cydeo.dto.UserDTO;
import com.cydeo.entity.User;

import java.util.List;

public interface UserService {
    List<UserDTO> listAllUsers();
    UserDTO findByUserName(String username);// to support update and delete - knowing what user to update/delete
    void save(UserDTO user);
    UserDTO update (UserDTO user);
    void delete (String username);//delete based on unique, this case is username







}
