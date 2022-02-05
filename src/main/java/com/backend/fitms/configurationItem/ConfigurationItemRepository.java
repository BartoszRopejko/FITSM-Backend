package com.backend.fitms.configurationItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConfigurationItemRepository extends JpaRepository<ConfigurationItem, String> {
    List<ConfigurationItem> findAll();
}
