package com.muxplorer.review.dto;

import com.muxplorer.review.domain.ReviewEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static org.springframework.beans.BeanUtils.copyProperties;

@Getter
@Setter
public class ReviewDto {

    private Long id;
    private Long userId;
    private String content;
    private Float rating;
    private String reviewPicture;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;

    public ReviewDto(ReviewEntity reviewEntity) {copyProperties(reviewEntity, this);}
}
