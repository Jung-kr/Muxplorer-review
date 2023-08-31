package com.muxplorer.review.service.review;

import com.muxplorer.review.domain.FoodEntity;
import com.muxplorer.review.domain.ReviewEntity;
import com.muxplorer.review.dto.review.ReviewRequest;
import com.muxplorer.review.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ReviewRegisterService {

    private final ReviewRepository reviewRepository;
    private final String FOLDER_PATH = "~/muxplorer/review_picture/";

    public ReviewEntity addReview(FoodEntity foodEntity, ReviewRequest reviewRequest) {

        /*
        String filePath = "";

        try {
            if(!image.isEmpty()) {
                filePath = FOLDER_PATH + UUID.randomUUID() + "_" + image.getOriginalFilename();
                image.transferTo(new File(filePath));
            } else {
                filePath = "null";
                image.transferTo(new File(filePath));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
         */

        ReviewEntity reviewEntity = ReviewEntity.builder()
                .food(foodEntity)
                .userId(reviewRequest.getUserId())
                .nickname(reviewRequest.getNickname())
                .reviewPicturePath(null)
                .content(reviewRequest.getContent())
                .rating(reviewRequest.getRating())
                .createDate(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now())
                .build();



        return reviewRepository.save(reviewEntity);
    }

}
