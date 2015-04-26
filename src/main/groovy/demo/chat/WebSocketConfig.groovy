package demo.chat

import demo.chat.event.PresenceEventListener
import demo.chat.repository.ParticipantRepository
import demo.chat.service.MessageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    @Autowired
    MessageService messageService

    @Autowired
    ParticipantRepository participantRepository

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic/")
        config.setApplicationDestinationPrefixes("/app")
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/message").withSockJS()
    }

    @Bean
    public PresenceEventListener presenceEventListener(SimpMessagingTemplate messagingTemplate) {
        return new PresenceEventListener(participantRepository: participantRepository, messageService: messageService)
    }

}
