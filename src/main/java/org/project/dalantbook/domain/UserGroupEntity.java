package org.project.dalantbook.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "USER_GROUP")
@Getter
@Setter
public class UserGroupEntity extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "USER_GROUP_ID", columnDefinition = "VARCHAR(100)", nullable = false, length = 100)
    private String userGroupId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CHURCH_ID")
    private ChurchEntity church;

    @Column(name = "USER_GROUP_NAME", columnDefinition = "VARCHAR(50)", nullable = false, length = 50)
    private String userGroupName;

}
