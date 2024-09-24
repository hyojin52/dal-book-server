package org.project.dalantbook.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "Offering")
@Getter
@Setter
public class OfferingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "VARCHAR(100)", nullable = false, length = 100)
    private String id;

    @ManyToOne
    @JoinColumn(name = "church_member_id", referencedColumnName = "id")
    private ChurchMemberEntity churchMember;

    @Column(name = "type", length = 20, nullable = false)
    private String type;

    @Column(name = "amount", columnDefinition = "int unsigned", nullable = false)
    private int amount;

    @Column(name = "date", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime date;

    @Column(name = "memo", length = 30)
    private String memo;


}
