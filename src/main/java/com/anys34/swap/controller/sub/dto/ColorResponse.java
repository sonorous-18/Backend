package com.anys34.swap.controller.sub.dto;

import com.anys34.swap.entity.sub.Color;
import com.anys34.swap.entity.sub.ColorSet;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ColorResponse {
    private Long id;
    private String thumbnail;
    private ColorSet color;

    public ColorResponse(Color color) {
        this.id = color.getId();
        this.thumbnail = color.getThumbnail();
        this.color = color.getColor();
    }
}
