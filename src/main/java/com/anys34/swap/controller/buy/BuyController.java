package com.anys34.swap.controller.buy;

import com.anys34.swap.controller.buy.dto.ListBuyResponse;
import com.anys34.swap.controller.buy.dto.SaveBuyRequest;
import com.anys34.swap.service.buy.BuyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/buy")
@RestController
public class BuyController {
    private final BuyService buyService;

    @PostMapping
    public Long save(@RequestBody SaveBuyRequest request) {
        return buyService.save(request);
    }

    @GetMapping
    public List<ListBuyResponse> list() {
        return buyService.list();
    }
}
