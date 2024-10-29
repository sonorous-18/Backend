package com.anys34.swap.service.bike;

import com.anys34.swap.controller.bike.dto.ListBikeResponse;
import com.anys34.swap.controller.bike.dto.SaveBikeRequest;
import com.anys34.swap.entity.bike.BikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BikeService {
    private final BikeRepository bikeRepository;

    @Transactional
    public Long save(SaveBikeRequest request) {
        return bikeRepository.save(request.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<ListBikeResponse> list() {
        return bikeRepository.findAll().stream()
                .map(ListBikeResponse::new)
                .toList();
    }
}
