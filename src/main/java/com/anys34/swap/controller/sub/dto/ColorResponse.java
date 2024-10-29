package com.anys34.swap.controller.sub.dto;

import com.anys34.swap.entity.sub.Color;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ColorResponse {
    private Long id;
    private String thumbnail;
    private String color;

    public ColorResponse(Color color) {
        this.id = color.getId();
        this.thumbnail = color.getThumbnail();
        this.color = color.getColor();
    }
}
