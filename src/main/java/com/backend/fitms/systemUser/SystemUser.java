package com.backend.fitms.systemUser;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class SystemUser {
    @Id
    private String uuid;
    private String firstName;
    private String lastName;
}
