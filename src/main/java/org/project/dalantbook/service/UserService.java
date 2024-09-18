package org.project.dalantbook.service;

import lombok.RequiredArgsConstructor;
import org.project.dalantbook.controller.dto.request.UserRequest;
import org.project.dalantbook.domain.UserEntity;
import org.project.dalantbook.domain.UserGroupEntity;
import org.project.dalantbook.domain.enums.UserRole;
import org.project.dalantbook.repository.UserGroupRepository;
import org.project.dalantbook.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserGroupRepository userGroupRepository;


    public UserEntity findByUsername(String username) {
        return userRepository.findByUserName(username);
    }

    public void registerUser(UserRequest user){
        UserGroupEntity userGroupEntity = userGroupRepository.findById(user.getGroupId()).get();
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName("sara");
        userEntity.setPassword(user.getPassword());
        userEntity.setUserActiveYn(true);
        userEntity.setBirthDate(user.getBirthdate());
        userEntity.setMobileNumber(user.getMobileNumber());
        userEntity.setRole(UserRole.USER);
        userEntity.setGroup(userGroupEntity);
        userRepository.save(userEntity);
    }
}
