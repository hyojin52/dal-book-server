package org.project.dalantbook.domain.respository;

import org.project.dalantbook.domain.ChurchEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChurchRepository extends JpaRepository<ChurchEntity, String> {

}
