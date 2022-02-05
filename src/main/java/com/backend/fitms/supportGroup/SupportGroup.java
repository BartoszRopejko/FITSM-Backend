package com.backend.fitms.supportGroup;

import com.backend.fitms.configurationItem.ConfigurationItem;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Data
public class SupportGroup {
        @Id
        private String uid;
        private String name;
        @OneToMany(mappedBy="supportGroup")
        private Set<ConfigurationItem> managedCis;
}
