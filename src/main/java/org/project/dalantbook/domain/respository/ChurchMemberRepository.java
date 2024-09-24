package org.project.dalantbook.domain.respository;

import org.project.dalantbook.domain.ChurchMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ChurchMemberRepository extends JpaRepository<ChurchMemberEntity, String> {

    @Query(value = "select cm " +
            "from ChurchMemberEntity as cm " +
            "left join OfferingEntity as o " +
            "    on o.churchMember.id = cm.id " +
            "        and o.type = :type " +
            "        and DATE_FORMAT(o.date, '%Y-%m-%d') = :date " +
            "where cm.deletedAt is null " +
            "    and o.churchMember.id is null")
    List<ChurchMemberEntity> getPrepareOfferings(
            @Param("type") String type,
            @Param("date") LocalDate date);

}
