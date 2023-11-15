package twotwone.notAlone.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import twotwone.notAlone.domain.Voice;
import twotwone.notAlone.repository.VoiceRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VoiceService {
    private final VoiceRepository voiceRepository;

    public void getVoice(String prompt){
        Optional<Voice> voice = voiceRepository.findByName(prompt);
        if (voice.isEmpty()) {
            voiceRepository.save(Voice.builder()
                    .name(prompt)
                    .count(1)
                    .build());
        } else {
            voice.get().increaseCount();
            voiceRepository.save(voice.get());
        }
    }

    public List<Voice> getHistory() {
        return voiceRepository.findAll();
    }
}
