package com.anys34.swap.controller.sub;

import com.anys34.swap.controller.sub.dto.ListSubResponse;
import com.anys34.swap.service.sub.SubService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
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
}
