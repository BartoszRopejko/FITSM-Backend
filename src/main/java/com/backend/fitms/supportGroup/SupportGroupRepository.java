package com.backend.fitms.supportGroup;

import com.backend.fitms.configurationItem.ConfigurationItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupportGroupRepository extends JpaRepository<SupportGroup, String> {
    List<SupportGroup> findAll();
}
