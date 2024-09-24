package org.project.dalantbook.domain.respository;

import lombok.RequiredArgsConstructor;
import org.project.dalantbook.domain.ChurchMemberEntity;
import org.project.dalantbook.domain.OfferingEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;


public interface OfferingRepository extends JpaRepository<OfferingEntity, String> {

    @Query(value = "select o " +
            "from OfferingEntity as o " +
            "where (:date is null or DATE_FORMAT(o.date, '%Y-%m-%d') = :date) " +
            "   and (:type is null or o.type = :type) " +
            "   and (:churchMemberId is null or o.churchMember.id = :churchMemberId)")
    Page<OfferingEntity> getOfferings(
            @Param("date") LocalDate date,
            @Param("type") String type,
            @Param("churchMemberId") String churchMemberId,
            Pageable pageable
    );

}
