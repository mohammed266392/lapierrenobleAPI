package com.version1.lapierrenoble.message;

import com.version1.lapierrenoble.prospect.Prospect;
import com.version1.lapierrenoble.prospect.ProspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private ProspectService prospectService;


    @GetMapping("messages")
    public List<Message> retriveAllMessage(){
        return messageService.retrieveAllMessages();
    }

    @GetMapping("messages/{idProspect}")
    public List<Message> retriveProspectMessage(@PathVariable Integer idProspect){
        Optional<Prospect> prospect = prospectService.findById(idProspect);

        if(prospect.isPresent()) {
            return  prospect.get().getMessage();
        }
        return Collections.emptyList();
    }

    @PostMapping("messages/{idProspect}")
    public boolean createMessage(@PathVariable Integer idProspect, @RequestBody Message message){
        Optional<Prospect> prospect = prospectService.findById(idProspect);

        if(prospect.isPresent()) {
            message.setProspect(prospect.get());
            message.setLocalDateTime(LocalDateTime.now());
            messageService.createMessage(message);
            return true;
        }
        return false;
    }
}
