package com.backend.fitms.systemUser;

import com.backend.fitms.configurationItem.ConfigurationItemService;
import com.backend.fitms.supportGroup.SupportGroup;
import com.backend.fitms.supportGroup.SupportGroupRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SystemUserService {

    Logger logger = LoggerFactory.getLogger(ConfigurationItemService.class);

    @Autowired
    SystemUserRepository systemUserRepository;
    SupportGroupRepository supportGroupRepository;

    public SystemUserService(SystemUserRepository systemUserRepository, SupportGroupRepository supportGroupRepository){
        this.systemUserRepository = systemUserRepository;
        this.supportGroupRepository = supportGroupRepository;
    }

    public ResponseEntity saveSystemUser(SystemUser systemUser){
        try{
            logger.info("Added new system user: " + systemUser.toString());
            return ResponseEntity.ok(systemUserRepository.save(systemUser));
        }catch (Exception e){
            logger.error("Exception occurred during creating new system user: ");
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }
    }

    public ResponseEntity getSystemUserDetails(String uuid){
        try{
            if(systemUserRepository.findById(uuid).isPresent()){
                logger.info("Displaying system user:  " + uuid);
                return ResponseEntity.ok(systemUserRepository.findById(uuid).get());
            }else{
                logger.warn("System user: " + uuid + " not found.");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("System user: " + uuid + " not found.");
            }
        }catch (Exception e){
            logger.error("Exception occurred during displaying system user: ");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }
    }
    public ResponseEntity getAllSystemUsers(){
            return ResponseEntity.ok(systemUserRepository.findAll());
    }
}

