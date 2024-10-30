package com.anys34.swap.controller.challenge.dto;

import com.anys34.swap.entity.challenge.Challenge;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ListChallengeResponse {
    private String title;
    private Integer percentage;
    private Boolean isClear;
    private Integer point;
    private Integer totalPoints;

    public ListChallengeResponse(Challenge challenge) {
        this.title = challenge.getTitle();
        this.percentage = challenge.getPercentage();
        this.isClear = challenge.getIsClear();
        this.point = challenge.getPoint();
        this.totalPoints = challenge.getTotalPoints();
    }
}
