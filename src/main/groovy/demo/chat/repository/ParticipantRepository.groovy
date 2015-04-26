package demo.chat.repository

import org.springframework.stereotype.Service

import java.util.concurrent.ConcurrentHashMap

@Service
class ParticipantRepository {
    ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>()

    public void addParticipant(String sessionId, String email){
        map.put(sessionId, email)
    }

    public void removeParticipant(String sessionId){
        map.remove(sessionId)
    }

    public String getParticipant(String sessionId){
        return map.get(sessionId)
    }
}
