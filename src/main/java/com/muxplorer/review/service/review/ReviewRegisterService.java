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
    private final String FOLDER_PATH = "C:\\test\\";

    public ReviewEntity addReview(FoodEntity foodEntity, ReviewRequest reviewRequest, MultipartFile image) {

        Date date = new Date();
        UUID uuid = UUID.randomUUID();
        String filePath = FOLDER_PATH + uuid + "_" + image.getOriginalFilename() ;

        ReviewEntity reviewEntity = ReviewEntity.builder()
                .food(foodEntity)
                .userId(reviewRequest.getUserId())
                .nickname(reviewRequest.getNickname())
                .reviewPicturePath(filePath)
                .content(reviewRequest.getContent())
                .rating(reviewRequest.getRating())
                .createDate(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now())
                .build();

        try {
            if(!image.isEmpty()) {
                image.transferTo(new File(filePath));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return reviewRepository.save(reviewEntity);
    }

}
