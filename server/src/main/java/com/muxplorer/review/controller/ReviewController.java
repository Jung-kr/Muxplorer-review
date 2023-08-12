package com.muxplorer.review.controller;

import com.muxplorer.review.domain.FoodEntity;
import com.muxplorer.review.domain.ReviewEntity;
import com.muxplorer.review.dto.ReviewRequest;
import com.muxplorer.review.service.FoodStatusService;
import com.muxplorer.review.service.ReviewRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewRegisterService reviewRegisterService;
    private final FoodStatusService foodStatusService;

    @PostMapping("register/{id}")
    public ReviewEntity registerReview(@PathVariable("id") Long foodId, @RequestBody ReviewRequest reviewRequest) {
        FoodEntity foodEntity = foodStatusService.findByIdFood(foodId);
        return reviewRegisterService.addReview(foodEntity, reviewRequest);
    }



}
