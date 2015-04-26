package demo.chat.service

import demo.chat.domain.Event
import demo.chat.domain.Message
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Service

@Service
class MessageService {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate

    public void sendMessage(Message message){
        simpMessagingTemplate.convertAndSend("/topic/chat".toString(), message)
    }

    public void sendEvent(Event event){
        simpMessagingTemplate.convertAndSend("/topic/events".toString(), event)
    }



}
