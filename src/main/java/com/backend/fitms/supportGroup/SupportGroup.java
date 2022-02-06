package com.backend.fitms.supportGroup;

import com.backend.fitms.configurationItem.ConfigurationItem;
import com.backend.fitms.systemUser.SystemUser;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class SupportGroup {
        @Id
        private String uuid;
        private String name;
        @OneToMany(mappedBy="supportGroup")
        private Set<ConfigurationItem> managedCis;
}
