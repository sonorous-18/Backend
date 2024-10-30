package com.anys34.swap.controller.sub.dto;

import com.anys34.swap.entity.sub.Color;
import com.anys34.swap.entity.sub.ColorSet;
import com.anys34.swap.entity.sub.Sub;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class ListSubResponse {
    private Long id;
    private String title;
    private String thumbnail;
    private Integer price;
    private List<ColorSet> colors = new ArrayList<>();

    public ListSubResponse(Sub sub, List<Color> colors) {
        this.id = sub.getId();
        this.title = sub.getTitle();
        this.thumbnail = sub.getThumbnail();
        this.price = sub.getPrice();
        for (Color color : colors) {
            this.colors.add(color.getColor());
        }
    }
}
