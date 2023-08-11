package com.muxplorer.review.repository;

import com.muxplorer.review.dto.FoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<FoodEntity, Long> {
}
