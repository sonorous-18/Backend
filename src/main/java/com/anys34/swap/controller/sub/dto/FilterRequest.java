package com.anys34.swap.controller.sub.dto;

import com.anys34.swap.entity.sub.ColorSet;
import com.anys34.swap.entity.sub.Spac;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class FilterRequest {
    private List<ColorSet> colors;
    private Integer startMoney;
    private Integer endMoney;
    private List<Spac> spaces;
}
