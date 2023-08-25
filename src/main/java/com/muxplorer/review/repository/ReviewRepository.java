package com.muxplorer.review.repository;

import com.muxplorer.review.domain.FoodEntity;
import com.muxplorer.review.domain.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
    List<ReviewEntity> findByFood(FoodEntity food);

    Optional<ReviewEntity> findById(Long reviewId);
}
