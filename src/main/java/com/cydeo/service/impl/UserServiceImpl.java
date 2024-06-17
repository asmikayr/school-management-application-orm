package com.cydeo.service.impl;

import com.cydeo.dto.UserDTO;
import com.cydeo.entity.User;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.mapper.UserMapper;
import com.cydeo.repository.UserRepository;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Service
public class UserServiceImpl implements UserService {



    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final MapperUtil mapperUtil;

    public UserServiceImpl(MapperUtil mapperUtil, UserRepository userRepository, UserMapper userMapper) {
        this.mapperUtil = mapperUtil;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDTO> listAllUsers() {
        List<User> userList = userRepository.findAllByIsDeletedOrderByFirstNameDesc(false);
        return userList.stream().map(userMapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public UserDTO findByUserName(String username) {
        User user = userRepository.findByUserNameAndIsDeleted(username, false);
        return userMapper.convertToDto(user);
    }

    @Override
    public void save(UserDTO user) {
        userRepository.save(userMapper.convertToEntity(user));
    }

    @Override
    public UserDTO update(UserDTO user) {
        User user1 = userRepository.findByUserNameAndIsDeleted(user.getUserName(), false);
        User convertedUser = userMapper.convertToEntity(user);
        convertedUser.setId(user1.getId());
        userRepository.save(convertedUser);
        return findByUserName(user.getUserName());
    }

    @Override
    public void delete(String username) {

    }

    @Override
    public List<UserDTO> listAllByRole(String description) {
        return userRepository.findByRoleDescriptionIgnoreCase(description)
                .stream()
                .map(userMapper::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isPasswordMatched(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }


}
