package com.anys34.swap.controller.bike;

import com.anys34.swap.controller.bike.dto.ListBikeResponse;
import com.anys34.swap.controller.bike.dto.SaveBikeRequest;
import com.anys34.swap.service.bike.BikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/bike")
@RestController
public class BikeController {
    private final BikeService bikeService;

    @GetMapping("/list")
    public List<ListBikeResponse> list() {
        return bikeService.list();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Long save(@RequestBody SaveBikeRequest request) {
        return bikeService.save(request);
    }
}
