package com.anys34.swap.controller.buy.dto;

import com.anys34.swap.entity.buy.Buy;
import com.anys34.swap.entity.sub.Color;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@Getter
@NoArgsConstructor
public class ListBuyResponse {
    private String title;
    private Integer price;
    private LocalDate nextBuyDate;
    private Integer useDate;

    public ListBuyResponse(Buy buy) {
        Color color = buy.getColor();
        this.title = color.getSub().getTitle();
        this.price = color.getSub().getPrice();
        this.nextBuyDate = buy.getNextBuyDate();
        Period p = Period.between(LocalDate.now(), buy.getBuyDate());
        this.useDate = p.getDays();
    }
}
