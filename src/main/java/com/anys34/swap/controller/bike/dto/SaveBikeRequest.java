package com.anys34.swap.controller.bike.dto;

import com.anys34.swap.entity.bike.Bike;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class SaveBikeRequest {
    private List<String> pictures;
    private String title;
    private Integer year;
    private Boolean mo;
    private Boolean tu;
    private Boolean we;
    private Boolean th;
    private Boolean fr;
    private Boolean sa;
    private Boolean su;
    private LocalTime startTime;
    private LocalTime endTime;

    public Bike toEntity() {
        return Bike.builder()
                .pictures(pictures)
                .title(title)
                .year(year)
                .mo(mo)
                .tu(tu)
                .we(we)
                .th(th)
                .fr(fr)
                .sa(sa)
                .su(su)
                .startTime(startTime)
                .endTime(endTime)
                .build();
    }
}
