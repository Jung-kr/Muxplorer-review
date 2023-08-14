package com.muxplorer.review.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
public class ReviewRequest {

    private Long userId;
    private String content;
    private Float rating;
    private String reviewPicture;

}
