package org.project.dalantbook.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CHURCH")
@Getter
@Setter
public class ChurchEntity extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "CHURCH_ID", columnDefinition = "VARCHAR(100)", nullable = false, length = 100)
    private String churchId;

    @Column(name = "CHURCH_NAME", length = 50, nullable = false)
    private String churchName;

}
