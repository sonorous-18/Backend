package com.anys34.swap.service.sub;

import com.anys34.swap.controller.sub.dto.ListSubResponse;
import com.anys34.swap.entity.sub.SubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SubService {
    private final SubRepository subRepository;

    public List<ListSubResponse> list() {
        return subRepository.findAll().stream()
                .map(ListSubResponse::new)
                .toList();
    }
}
