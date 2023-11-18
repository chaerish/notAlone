package twotwone.notAlone.service;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import twotwone.notAlone.domain.Voice;
import twotwone.notAlone.repository.VoiceRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VoiceService {

    @Autowired
    private final VoiceRepository voiceRepository;

    private final RestTemplate restTemplate;

    private final String SERVER_ADDRESS = "http://localhost:8000";

    public String getVoice(String prompt, String gender){
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

        ResponseEntity<String> response = restTemplate.exchange(
                SERVER_ADDRESS + "/voice/create?prompt=" + prompt + "&gender=" + gender,
                HttpMethod.POST,
                null,
                String.class);

        return response.getBody();
    }

    public List<Voice> getHistory() {
        return voiceRepository.findAll();
    }
}
