package com.muxplorer.review.repository;

import com.muxplorer.review.domain.FoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<FoodEntity, Long> {
}
