package org.project.dalantbook.domain.respository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.project.dalantbook.domain.OfferingEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class OfferingBulkRepository {
    private final JdbcTemplate jdbcTemplate;

    @Transactional
    public void saveAll(List<OfferingEntity> offeringList) {
        String sql = "INSERT INTO offering (amount, church_member_id, date, memo, type, id) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        jdbcTemplate.batchUpdate(sql,
                offeringList,
                offeringList.size(),
                (PreparedStatement ps, OfferingEntity offering) -> {
                    ps.setInt(1, offering.getAmount());
                    ps.setString(2, offering.getChurchMember().getId());
                    ps.setTimestamp(3, Timestamp.valueOf(offering.getDate()));
                    ps.setString(4, offering.getMemo());
                    ps.setString(5, offering.getType());
                    ps.setString(6, UUID.randomUUID().toString());
                });
    }
}
