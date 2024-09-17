package org.project.dalantbook.repository;

import org.project.dalantbook.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<UserEntity, Long> {
    UserEntity findByUserName(String username);

}
