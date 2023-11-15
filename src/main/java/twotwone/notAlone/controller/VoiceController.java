package twotwone.notAlone.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import twotwone.notAlone.Voice;
import twotwone.notAlone.service.VoiceService;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class VoiceController {
    VoiceService voiceService;
    //prompt 받아오기
    @GetMapping("/voice/requests")
    public ResponseEntity<?> getPrompt(@RequestParam String prompt){
        voiceService.saveOrUpdate(prompt);
        return ResponseEntity.ok("완료되었습니다.");
    }
}
