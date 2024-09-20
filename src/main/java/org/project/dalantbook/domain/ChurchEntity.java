package org.project.dalantbook.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Church")
@Getter
@Setter
public class ChurchEntity extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "VARCHAR(100)", nullable = false, length = 100)
    private String id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "pastor", length = 20, nullable = false)
    private String pastor;

    @Column(name = "denomination", length = 30, nullable = false)
    private String denomination;

    @Column(name = "address", length = 100, nullable = false)
    private String address;

    @Column(name = "phone", length = 20)
    private String phone;

}
