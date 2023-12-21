package com.version1.lapierrenoble.message;

import com.version1.lapierrenoble.prospect.Prospect;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MessageService {

    private MessageRepository messageRepository;

    public List<Message> retrieveAllMessages(){ return messageRepository.findAll();}

    public List<Message> retrieveMessagesByProspect(Prospect prospect){ return messageRepository.findByProspect(prospect);}

    public boolean createMessage(Message message){

        Message messageSaved = messageRepository.save(message);
        return true;
    }

}
