package com.muxplorer.review.dto;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
public class ReviewRequest {

    private String content;
    private String pictureUrl;
}
