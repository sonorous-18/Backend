package com.anys34.swap.controller.sub.dto;

import com.anys34.swap.entity.sub.Review;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReviewResponse {
    private String username;
    private String comment;

    public ReviewResponse(Review review) {
        this.username = review.getUsername();
        this.comment = review.getComment();
    }
}
