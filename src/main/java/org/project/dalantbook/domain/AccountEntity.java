package org.project.dalantbook.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Entity
@Table(name = "Account")
@SQLDelete(sql = "UPDATE Account SET deleted_at = NOW() where id=?")
@Where(clause = "deleted_at is NULL")
@Getter
@Setter
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "VARCHAR(100)", nullable = false, length = 100)
    private String id;

    @ManyToOne
    @JoinColumn(name="church_id", referencedColumnName = "id")
    private ChurchEntity church;

    @Column(name = "user_id", length = 20, nullable = false)
    private String userId;

    @Column(name = "user_password", length = 100, nullable = false)
    private String userPassword;

    @Column(name = "deleted_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime deletedAt;
}
