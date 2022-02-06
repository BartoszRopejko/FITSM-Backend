package com.backend.fitms.configurationItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/ConfigurationItem")
public class ConfigurationItemController {

    @Autowired
    ConfigurationItemService configurationItemService;

    @GetMapping
    public ResponseEntity getAllConfigurationItems(){
        return configurationItemService.getAllConfigurationItems();
    }
    @GetMapping("/details")
    public ResponseEntity getConfigurationItemDetails(@RequestParam String uuid){
        return configurationItemService.getConfigurationItemDetails(uuid);
    }

    @PostMapping
    public ResponseEntity createConfigurationItem(@RequestBody ConfigurationItem configurationItem){
        UUID uuid = UUID.randomUUID();
        configurationItem.setUuid(uuid.toString());
        return configurationItemService.saveConfigurationItem(configurationItem);
    }

    @DeleteMapping
    public ResponseEntity removeConfigurationItem(@RequestParam String uuid){
        return configurationItemService.removeConfigurationItem(uuid);
    }
}
