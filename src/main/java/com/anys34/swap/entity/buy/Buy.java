package com.anys34.swap.entity.buy;

import com.anys34.swap.entity.sub.Color;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity
public class Buy {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "color_id", nullable = false)
    private Color color;

    private LocalDate buyDate;
    private LocalDate nextBuyDate;

    public Buy(Color color) {
        this.color = color;
        this.buyDate = LocalDate.now();
        this.nextBuyDate = buyDate.plusDays(30);
    }
}
