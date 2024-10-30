package com.anys34.swap.controller.sub;

import com.anys34.swap.controller.sub.dto.ListSubResponse;
import com.anys34.swap.controller.sub.dto.ReviewResponse;
import com.anys34.swap.controller.sub.dto.SubResponse;
import com.anys34.swap.service.sub.SubService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/sub")
@RestController
public class SubController {
    private final SubService subService;

    @GetMapping("/list")
    public List<ListSubResponse> list() {
        return subService.list();
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
