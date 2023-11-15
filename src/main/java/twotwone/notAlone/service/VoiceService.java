package twotwone.notAlone.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import twotwone.notAlone.domain.Voice;
import twotwone.notAlone.repository.VoiceRepository;

@Service
@RequiredArgsConstructor
public class VoiceService {
    private final VoiceRepository voiceRepository;
    public void save(String prompt){
        voiceRepository.save(Voice.builder().name(prompt).build());
    }
    public void updateCount(String prompt){
        Voice voice = voiceRepository.findByName(prompt).get();
        voice.updateCount();
    }
    public void saveOrUpdate(String prompt){
        if(voiceRepository.findByName(prompt).isEmpty()){
            save(prompt);
        }
        updateCount(prompt);
    }
}
