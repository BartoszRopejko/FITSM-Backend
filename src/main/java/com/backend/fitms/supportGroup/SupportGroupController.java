package com.backend.fitms.supportGroup;

import com.backend.fitms.configurationItem.ConfigurationItem;
import com.backend.fitms.configurationItem.ConfigurationItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/SupportGroup")

public class SupportGroupController {

    @Autowired
    SupportGroupService supportGroupService;

    @GetMapping
    public ResponseEntity getAllSupportGroups(){

        return supportGroupService.getAllSupportGroups();
    }

    @GetMapping("/details")
    public ResponseEntity getSupportGroupDetails(@RequestParam String uuid){
        return supportGroupService.getSupportGroupDetails(uuid);
    }

    @PostMapping
    public ResponseEntity createConfigurationItem(@RequestBody SupportGroup supportGroup){
        UUID uuid = UUID.randomUUID();
        supportGroup.setUuid(uuid.toString());
        return supportGroupService.saveSupportGroup(supportGroup);
    }
}
