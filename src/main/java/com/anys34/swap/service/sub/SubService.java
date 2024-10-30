package com.anys34.swap.service.sub;

import com.anys34.swap.controller.sub.dto.ListSubResponse;
import com.anys34.swap.controller.sub.dto.ReviewResponse;
import com.anys34.swap.controller.sub.dto.SubResponse;
import com.anys34.swap.entity.sub.Color;
import com.anys34.swap.entity.sub.ColorRepository;
import com.anys34.swap.entity.sub.Review;
import com.anys34.swap.entity.sub.ReviewRepository;
import com.anys34.swap.entity.sub.Sub;
import com.anys34.swap.entity.sub.SubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SubService {
    private final SubRepository subRepository;
    private final ColorRepository colorRepository;
    private final ReviewRepository reviewRepository;

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

    public List<ReviewResponse> review(Long id) {
        Sub sub = subRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("찾을 수 없습니다."));
        return reviewRepository.findAllBySub(sub).stream()
                .map(ReviewResponse::new)
                .toList();
    }
}
