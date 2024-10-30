package com.anys34.swap.service.sub;

import com.anys34.swap.controller.sub.dto.ListSubResponse;
import com.anys34.swap.controller.sub.dto.ReviewResponse;
import com.anys34.swap.controller.sub.dto.SubResponse;
import com.anys34.swap.entity.sub.Color;
import com.anys34.swap.entity.sub.ColorRepository;
import com.anys34.swap.entity.sub.ColorSet;
import com.anys34.swap.entity.sub.ReviewRepository;
import com.anys34.swap.entity.sub.Spac;
import com.anys34.swap.entity.sub.Sub;
import com.anys34.swap.entity.sub.SubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SubService {
    private final SubRepository subRepository;
    private final ColorRepository colorRepository;
    private final ReviewRepository reviewRepository;

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

    public List<ListSubResponse> filter(List<ColorSet> colors, Integer startMoney, Integer endMoney, List<Spac> spaces) {
        List<Sub> subs = subRepository.findAll();

        if (colors != null && !colors.isEmpty()) {
            subs = subs.stream()
                    .filter(sub -> subHasColor(sub, colors))
                    .collect(Collectors.toList());
        }

        if (startMoney != null) {
            subs = subs.stream()
                    .filter(sub -> sub.getPrice() != null && sub.getPrice() >= startMoney)
                    .collect(Collectors.toList());
        }

        if (endMoney != null) {
            subs = subs.stream()
                    .filter(sub -> sub.getPrice() != null && sub.getPrice() <= endMoney)
                    .collect(Collectors.toList());
        }

        if (spaces != null && !spaces.isEmpty()) {
            subs = subs.stream()
                    .filter(sub -> spaces.contains(sub.getSpac()))
                    .collect(Collectors.toList());
        }

        return subs.stream()
                .map(it -> {
                    List<Color> color = colorRepository.findAllBySub(it)
                            .stream().limit(4).toList();
                    return new ListSubResponse(it, color);
                })
                .toList();
    }

    private boolean subHasColor(Sub sub, List<ColorSet> colors) {
        List<Color> subColors = colorRepository.findAllBySub(sub);
        return subColors.stream()
                .anyMatch(color -> colors.contains(color.getColor()));
    }
}
