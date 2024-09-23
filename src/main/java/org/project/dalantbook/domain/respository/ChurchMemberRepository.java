package org.project.dalantbook.domain.respository;

import org.project.dalantbook.domain.ChurchMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChurchMemberRepository extends JpaRepository<ChurchMemberEntity, String>
{

}
