package twotwone.notAlone.service;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import twotwone.notAlone.domain.Voice;
import twotwone.notAlone.repository.VoiceRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VoiceService {
    private final VoiceRepository voiceRepository;

    private RestTemplate restTemplate;

    public String getVoice(String prompt){
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

        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080/voice?" + prompt, HttpMethod.GET, null, String.class);
        return response.getBody();
    }

    public List<Voice> getHistory() {
        return voiceRepository.findAll();
    }
}
