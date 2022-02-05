package com.backend.fitms.configurationItem;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class ConfigurationItem {
    @Id
    private String uid;
    private String name;
    @NotNull
    private String type;
    @JoinColumn(name="uid", nullable=false)
    private String supportGroup;
}
