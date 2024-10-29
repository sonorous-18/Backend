package com.anys34.swap.controller.sub.dto;

import com.anys34.swap.entity.sub.Sub;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ListSubResponse {
    private Long id;
    private String title;
    private String thumbnail;
    private Integer price;

    public ListSubResponse(Sub sub) {
        this.id = sub.getId();
        this.title = sub.getTitle();
        this.thumbnail = sub.getTitle();
        this.price = sub.getPrice();
    }
}
