package com.anys34.swap.service.challenge;

import com.anys34.swap.controller.challenge.dto.ListChallengeResponse;
import com.anys34.swap.entity.challenge.ChallengeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ChallengeService {
    private final ChallengeRepository challengeRepository;

    public List<ListChallengeResponse> list() {
        return challengeRepository.findAll().stream()
                .map(ListChallengeResponse::new)
                .toList();
    }
}
