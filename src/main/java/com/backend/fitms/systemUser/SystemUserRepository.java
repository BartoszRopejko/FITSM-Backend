package com.backend.fitms.systemUser;

import com.backend.fitms.supportGroup.SupportGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SystemUserRepository extends JpaRepository<SystemUser, String> {
    List<SystemUser> findAll();
}
