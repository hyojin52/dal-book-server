package org.project.dalantbook.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.project.dalantbook.converter.YesNoConverter;
import org.project.dalantbook.domain.enums.UserPosition;
import org.project.dalantbook.domain.enums.UserRole;


@Data
@Entity
@Table(name= "USER")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "USER_ID", columnDefinition = "VARCHAR(100)", nullable = false, length = 100)
    private String userId;

    @Column(name = "USER_NAME", columnDefinition = "VARCHAR(50)", nullable = false, length = 50)
    private String userName;

    @Column(name = "PASSWORD", columnDefinition = "VARCHAR(100)", nullable = false, length = 100)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "USER_ROLE", columnDefinition = "VARCHAR(20)", nullable = false, length = 20)
    private UserRole role;

    @Column(name = "MOBILE_NUMBER", columnDefinition = "VARCHAR(20)", length = 20)
    private String mobileNumber;

    @Column(name = "BIRTH_DATE", columnDefinition = "VARCHAR(20)", nullable = false, length = 20)
    private String birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "POSITION", columnDefinition = "VARCHAR(100)", length = 100)
    private UserPosition position;

    @Convert(converter = YesNoConverter.class)
    @Column(name = "USER_ACTIVE_YN", length = 1, nullable = false)
    private boolean userActiveYn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_GROUP_ID")
    private UserGroupEntity group;

}
