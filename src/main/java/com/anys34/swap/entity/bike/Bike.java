package com.anys34.swap.entity.bike;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Bike {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
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

    @Builder
    public Bike(List<String> pictures, String title, Integer year, Boolean mo, Boolean tu, Boolean we, Boolean th, Boolean fr, Boolean sa, Boolean su, LocalTime startTime, LocalTime endTime) {
        this.pictures = pictures;
        this.title = title;
        this.year = year;
        this.mo = mo;
        this.tu = tu;
        this.we = we;
        this.th = th;
        this.fr = fr;
        this.sa = sa;
        this.su = su;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
