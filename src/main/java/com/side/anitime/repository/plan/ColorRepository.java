package com.side.anitime.repository.plan;

import org.springframework.data.jpa.repository.JpaRepository;

import com.side.anitime.domain.category.Color;

public interface ColorRepository extends JpaRepository<Color, Long> {
}
