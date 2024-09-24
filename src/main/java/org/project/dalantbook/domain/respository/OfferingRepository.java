package org.project.dalantbook.domain.respository;

import org.project.dalantbook.domain.ChurchMemberEntity;
import org.project.dalantbook.domain.OfferingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface OfferingRepository extends JpaRepository<OfferingEntity, String> {


}
