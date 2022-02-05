package com.backend.fitms.configurationItem;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class ConfigurationItem {
    @Id
    private String uid;
    private String name;
    @NotNull
    private String type;
    private String supportGroup;
}
