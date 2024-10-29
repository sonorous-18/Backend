package com.anys34.swap.service.sub;

import com.anys34.swap.controller.sub.dto.ListSubResponse;
import com.anys34.swap.controller.sub.dto.SubResponse;
import com.anys34.swap.entity.sub.Color;
import com.anys34.swap.entity.sub.ColorRepository;
import com.anys34.swap.entity.sub.Sub;
import com.anys34.swap.entity.sub.SubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SubService {
    private final SubRepository subRepository;
    private final ColorRepository colorRepository;

    @Transactional(readOnly = true)
    public List<ListSubResponse> list() {
        return subRepository.findAll().stream()
                .map(ListSubResponse::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public SubResponse detail(Long id) {
        Sub sub = subRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("찾을 수 없습니다."));
        List<Color> colors = colorRepository.findAllBySub(sub);
        return new SubResponse(sub, colors);
    }
}
