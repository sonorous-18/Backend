package com.anys34.swap.controller.challenge;

import com.anys34.swap.controller.challenge.dto.ListChallengeResponse;
import com.anys34.swap.service.challenge.ChallengeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/challenge")
@RestController
public class ChallengeController {
    private final ChallengeService challengeService;

    @GetMapping("/list")
    public List<ListChallengeResponse> list() {
        return challengeService.list();
    }
}
