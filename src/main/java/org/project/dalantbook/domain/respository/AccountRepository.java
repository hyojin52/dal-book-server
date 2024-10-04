package org.project.dalantbook.domain.respository;

import org.project.dalantbook.domain.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountEntity, String> {
     Optional<AccountEntity> findByUserId(String userId);
}
