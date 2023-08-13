package com.muxplorer.review.controller;

import com.muxplorer.review.domain.FoodEntity;
import com.muxplorer.review.domain.ReviewEntity;
import com.muxplorer.review.dto.ReviewDto;
import com.muxplorer.review.dto.ReviewRequest;
import com.muxplorer.review.service.FoodStatusService;
import com.muxplorer.review.service.ReviewRegisterService;
import com.muxplorer.review.service.ReviewStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Controller
@ResponseBody
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewRegisterService reviewRegisterService;
    private final FoodStatusService foodStatusService;
    private final ReviewStatusService reviewStatusService;

    // 리뷰 등록
    @PostMapping("register/{id}")
    public ReviewDto registerReview(@PathVariable("id") Long foodId, @RequestBody ReviewRequest reviewRequest) {
        FoodEntity foodEntity = foodStatusService.findByIdFood(foodId);
        return new ReviewDto(reviewRegisterService.addReview(foodEntity, reviewRequest));
    }

    // 특정 음식에 해당하는 리뷰 리스트
    @GetMapping("list/{id}")
    public List<ReviewDto> reviewList(@PathVariable("id") Long foodId) {
        FoodEntity foodEntity = foodStatusService.findByIdFood(foodId);
        return reviewStatusService.findReviewByFood(foodEntity).stream().map(reviewEntity -> new ReviewDto(reviewEntity)).collect(toList());
    }


}
