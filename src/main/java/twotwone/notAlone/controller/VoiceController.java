package twotwone.notAlone.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import twotwone.notAlone.service.VoiceService;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class VoiceController {
    VoiceService voiceService;

    @GetMapping("/voice/requests")
    public ResponseEntity<?> getPrompt(@RequestParam String prompt, @RequestParam String gender){
        voiceService.getVoice(prompt);
        return ResponseEntity.ok("완료되었습니다.");
    }

    @GetMapping("/voice/")
    public ResponseEntity<?> getHistory() {
        return ResponseEntity.ok(voiceService.getHistory());
    }
}
