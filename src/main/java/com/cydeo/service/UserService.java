package com.cydeo.service;

import com.cydeo.dto.UserDTO;
import com.cydeo.entity.User;

import java.util.List;

public interface UserService {
    List<UserDTO> listAllUsers();
    UserDTO findByUserName(String username);// to support update and delete - knowing what user to update/delete
    void save(UserDTO user);
    UserDTO update (UserDTO user);
    void deleteById (Long id);//delete based on unique, this case is username

    List<UserDTO> listAllByRole(String description);// for course create page

    boolean isPasswordMatched(String password, String confirmPassword);

    boolean isEligibleToUpdate(Long userId, Long roleId);

    String isEligibleToDelete(Long id);

    UserDTO findById(Long userId);






}
