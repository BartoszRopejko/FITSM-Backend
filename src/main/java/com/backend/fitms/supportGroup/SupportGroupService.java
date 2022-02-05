package com.backend.fitms.supportGroup;

import com.backend.fitms.configurationItem.ConfigurationItem;
import com.backend.fitms.configurationItem.ConfigurationItemRepository;
import com.backend.fitms.configurationItem.ConfigurationItemService;
import com.backend.fitms.configurationItem.ConfigurationItemType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SupportGroupService {

    Logger logger = LoggerFactory.getLogger(ConfigurationItemService.class);

    @Autowired
    SupportGroupRepository supportGroupRepository;

    public SupportGroupService(SupportGroupRepository supportGroupRepository){
        this.supportGroupRepository = supportGroupRepository;
    }

    public ResponseEntity saveSupportGroup(SupportGroup supportGroup){
        try{
            logger.info("Added new support group: " + supportGroup.toString());
            return ResponseEntity.ok(supportGroupRepository.save(supportGroup));
        }catch (Exception e){
            logger.error("Exception occurred during creating new support group: ");
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }
    }

    public ResponseEntity getSupportGroupDetails(String uuid){
        try{
            if(supportGroupRepository.findById(uuid).isPresent()){
                logger.info("Displaying support group:  " + uuid);
                return ResponseEntity.ok(supportGroupRepository.findById(uuid).get());
            }else{
                logger.warn("Support group: " + uuid + " not found.");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Support group: " + uuid + " not found.");
            }
        }catch (Exception e){
            logger.error("Exception occurred during displaying Support group: ");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }
    }
    public ResponseEntity getAllSupportGroups(){
            return ResponseEntity.ok(supportGroupRepository.findAll());
        }
}

