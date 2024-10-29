package com.anys34.swap.service.buy;

import com.anys34.swap.controller.buy.dto.SaveBuyRequest;
import com.anys34.swap.entity.buy.Buy;
import com.anys34.swap.entity.buy.BuyRepository;
import com.anys34.swap.entity.sub.Color;
import com.anys34.swap.entity.sub.ColorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BuyService {
    private final ColorRepository colorRepository;
    private final BuyRepository buyRepository;

    @Transactional
    public Long save(SaveBuyRequest request) {
        Color color = colorRepository.findById(request.getColorId())
                .orElseThrow(() -> new IllegalArgumentException("Color를 찾을 수 없습니다."));
        return buyRepository.save(new Buy(color)).getId();
    }
}
