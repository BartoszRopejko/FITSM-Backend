package com.backend.fitms.systemUser;

import com.backend.fitms.supportGroup.SupportGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/SystemUser")

public class SystemUserController {

    @Autowired
    SystemUserService systemUserService;

    @GetMapping
    public ResponseEntity getAllSystemUsers(){
        return systemUserService.getAllSystemUsers();
    }

    @GetMapping("/details")
    public ResponseEntity getSupportGroupDetails(@RequestParam String uuid){
        return systemUserService.getSystemUserDetails(uuid);
    }

    @PostMapping
    public ResponseEntity createConfigurationItem(@RequestBody SystemUser systemUser){
        UUID uuid = UUID.randomUUID();
        systemUser.setUuid(uuid.toString());
        return systemUserService.saveSystemUser(systemUser);
    }
}
