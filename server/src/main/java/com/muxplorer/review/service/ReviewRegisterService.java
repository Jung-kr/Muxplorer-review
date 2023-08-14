package com.muxplorer.review.service;

import com.muxplorer.review.domain.FoodEntity;
import com.muxplorer.review.domain.ReviewEntity;
import com.muxplorer.review.dto.FoodRequest;
import com.muxplorer.review.dto.ReviewRequest;
import com.muxplorer.review.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ReviewRegisterService {

    private final ReviewRepository reviewRepository;

    public ReviewEntity addReview(FoodEntity foodEntity, ReviewRequest reviewRequest) {

        /* userId로 닉네임 불러오기 API
            private Long userId = reviewRequest.getUserId();
            private String nickname = ~~~~~

            밑에 코드도 수정 (nickname, userId)
        */

        ReviewEntity reviewEntity = ReviewEntity.builder()
                .food(foodEntity)
                .userId(reviewRequest.getUserId())
                .content(reviewRequest.getContent())
                .rating(reviewRequest.getRating())
                .reviewPicture(reviewRequest.getReviewPicture())
                .createDate(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now())
                .build();

        return reviewRepository.save(reviewEntity);
    }

}
