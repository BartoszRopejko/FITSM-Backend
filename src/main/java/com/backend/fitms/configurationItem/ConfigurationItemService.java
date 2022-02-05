package com.backend.fitms.configurationItem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class ConfigurationItemService {

    Logger logger = LoggerFactory.getLogger(ConfigurationItemService.class);

    @Autowired
    ConfigurationItemRepository configurationItemRepository;

    public ConfigurationItemService(ConfigurationItemRepository configurationItemRepository){
        this.configurationItemRepository = configurationItemRepository;
    }

    public ResponseEntity saveConfigurationItem(ConfigurationItem configurationItem){
        boolean typeExists = false;
        for (ConfigurationItemType configurationItemType : ConfigurationItemType.values()) {
            if (configurationItem.getType() == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Configuration item type - empty value.");
            else if (configurationItem.getType().equals(configurationItemType.name()))
                typeExists = true;
        }

        if(!typeExists){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Configuration item type - not existing configuration type.");
        }

        try{
            logger.info("Added new configuration item: " + configurationItem.toString());
            return ResponseEntity.ok(configurationItemRepository.save(configurationItem));
        }catch (Exception e){
            logger.error("Exception occured during creating new configuration item: ");
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }
    }

    public ResponseEntity getConfigurationItemDetails(String uuid){
        try{
            if(configurationItemRepository.findById(uuid).isPresent()){
                logger.info("Displaying configuration item:  " + uuid);
                return ResponseEntity.ok(configurationItemRepository.findById(uuid).get());
            }else{
                logger.warn("Configuration item: " + uuid + " not found.");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Configuration item: " + uuid + " not found.");
            }
        }catch (Exception e){
            logger.error("Exception occured during creating new configuration item: ");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }
    }

    public ResponseEntity removeConfigurationItem(String uuid){
        if(configurationItemRepository.findById(uuid).isPresent()){
            configurationItemRepository.delete(configurationItemRepository.findById(uuid).get());
            return ResponseEntity.ok(uuid);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Configuration item: " + uuid + " not found.");
        }
    }

    public ResponseEntity getAllConfigurationItems(){

        return ResponseEntity.ok(configurationItemRepository.findAll());
    }
}
