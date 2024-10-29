package com.anys34.swap.controller.bike.dto;

import com.anys34.swap.entity.bike.Bike;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class ListBikeResponse {
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

    public ListBikeResponse(Bike bike) {
        pictures = bike.getPictures();
        title = bike.getTitle();
        year = bike.getYear();
        mo = bike.getMo();
        tu = bike.getTu();
        we = bike.getWe();
        th = bike.getTh();
        fr = bike.getFr();
        sa = bike.getSa();
        su = bike.getSu();
        startTime = bike.getStartTime();
        endTime = bike.getEndTime();
    }
}
