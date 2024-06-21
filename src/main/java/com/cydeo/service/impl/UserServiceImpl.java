package com.cydeo.service.impl;

import com.cydeo.dto.UserDTO;
import com.cydeo.entity.User;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.repository.UserRepository;
import com.cydeo.service.CourseService;
import com.cydeo.service.LessonService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Service
public class UserServiceImpl implements UserService {



    private final UserRepository userRepository;
    private final MapperUtil mapperUtil;
    private final CourseService courseService;
    private final LessonService lessonService;



    public UserServiceImpl(MapperUtil mapperUtil, UserRepository userRepository, CourseService courseService, LessonService lessonService) {
        this.mapperUtil = mapperUtil;
        this.userRepository = userRepository;
        this.courseService = courseService;
        this.lessonService = lessonService;
    }

    @Override
    public List<UserDTO> listAllUsers() {
        List<User> userList = userRepository.findAllByIsDeletedOrderByFirstNameDesc(false);
        return userList.stream().map(user-> mapperUtil.convert(user, UserDTO.class)).collect(Collectors.toList());
    }

    @Override
    public UserDTO findByUserName(String username) {
        User user = userRepository.findByUserNameAndIsDeleted(username, false);
        return mapperUtil.convert(user, UserDTO.class);
    }

    @Override
    public void save(UserDTO user) {
        userRepository.save(mapperUtil.convert(user, User.class));
    }

    @Override
    public UserDTO update(UserDTO user) {
        User user1 = userRepository.findByUserNameAndIsDeleted(user.getUserName(), false);
        User convertedUser = mapperUtil.convert(user, User.class);
        convertedUser.setId(user1.getId());
        userRepository.save(convertedUser);
        return findById(user.getId());
    }

    @Override
    public void deleteById(Long id) {
        User user = userRepository.findByIdAndIsDeleted(id, false);
        user.setIsDeleted(true);
        user.setUserName(user.getUserName() + "-" + user.getId());
        userRepository.save(user);
    }

    @Override
    public List<UserDTO> listAllByRole(String description) {
        return userRepository.findByRoleDescriptionIgnoreCaseAndIsDeleted(description, false)
                .stream()
                .map(user -> mapperUtil.convert(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public boolean isPasswordMatched(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    @Override
    public boolean isEligibleToUpdate(Long userId, Long roleId) {
        UserDTO user = findById(userId);

        boolean result = true;

        if (user.getRole().getId().equals(roleId)) {
            return result;
        }

        String roleName = user.getRole().getDescription();


        switch (roleName) {
            case "Admin":
                if (listAllByRole("Admin").size() == 1)
                    result = false;
                break;
            case "Manager":
                if(!courseService.listAllCourseByCourseManager(user).isEmpty())
                    result = false;
                break;
            case "Instructor":
                if (!lessonService.listAllByInstructor(user).isEmpty())
                    result = false;
                break;
        }

        return result;
    }


    @Override
    public String isEligibleToDelete(Long id) {
        UserDTO user = findById(id);

        String roleName = user.getRole().getDescription();

        String result = "";

        switch (roleName) {
            case "Admin":
                if (listAllByRole("Admin").size() == 1)
                    result = "This admin is unique in the system. Not allowed to delete";
                break;
            case "Manager":
                if(!courseService.listAllCourseByCourseManager(user).isEmpty())
                    result = "This manager is responsible for either one or more than one courses. Not allowed to delete";
                break;
            case "Instructor":
                if (!lessonService.listAllByInstructor(user).isEmpty())
                    result = "This Instructor is responsible for either one or more than one lessons. Not allowed to delete";
                break;
        }

        return result;
    }

    @Override
    public UserDTO findById(Long userId) {
        User user = userRepository.findByIdAndIsDeleted(userId, false);
        return mapperUtil.convert(user, UserDTO.class);
    }


}
