package twotwone.notAlone.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import twotwone.notAlone.service.VoiceService;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class VoiceController {

    @Autowired
    private VoiceService voiceService;

    @PostMapping("/voice/create")
    public ResponseEntity<?> getPrompt(@RequestParam String prompt, @RequestParam String gender){
        return ResponseEntity.ok(voiceService.getVoice(prompt, gender));
    }

    @GetMapping("/voice/history")
    public ResponseEntity<?> getHistory() {
        return ResponseEntity.ok(voiceService.getHistory());
    }
}
