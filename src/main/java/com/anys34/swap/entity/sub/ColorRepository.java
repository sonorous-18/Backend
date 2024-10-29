package com.anys34.swap.entity.sub;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColorRepository extends JpaRepository<Color, Long> {
    List<Color> findAllBySub(Sub sub);
}
