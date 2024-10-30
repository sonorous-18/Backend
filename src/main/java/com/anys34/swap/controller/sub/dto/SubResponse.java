package com.anys34.swap.controller.sub.dto;

import com.anys34.swap.entity.sub.Color;
import com.anys34.swap.entity.sub.Sub;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class SubResponse {
    private Long id;
    private String title;
    private List<ColorResponse> colors = new ArrayList<>();
    private Integer price;
    private String detailLink;

    public SubResponse(Sub sub, List<Color> colors) {
        this.id = sub.getId();
        this.title = sub.getTitle();
        this.price = sub.getPrice();
        this.detailLink = sub.getDetailLink();
        for (Color color : colors) {
            this.colors.add(new ColorResponse(color));
        }
    }
}
