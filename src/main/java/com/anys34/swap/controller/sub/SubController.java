package com.anys34.swap.controller.sub;

import com.anys34.swap.controller.sub.dto.ListSubResponse;
import com.anys34.swap.controller.sub.dto.ReviewResponse;
import com.anys34.swap.controller.sub.dto.SubResponse;
import com.anys34.swap.entity.sub.ColorSet;
import com.anys34.swap.entity.sub.Spac;
import com.anys34.swap.service.sub.SubService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/sub")
@RestController
public class SubController {
    private final SubService subService;

    @GetMapping("/list")
    public List<ListSubResponse> list(
            @RequestParam(required = false) List<ColorSet> colors,
            @RequestParam(required = false) Integer startMoney,
            @RequestParam(required = false) Integer endMoney,
            @RequestParam(required = false) List<Spac> spaces
            ) {
        return subService.filter(colors, startMoney, endMoney, spaces);
    }

    @GetMapping("/detail/{id}")
    public SubResponse detail(@PathVariable Long id) {
        return subService.detail(id);
    }

    @GetMapping("/review/{id}")
    public List<ReviewResponse> review(@PathVariable Long id) {
        return subService.review(id);
    }
}
