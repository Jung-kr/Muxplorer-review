package com.muxplorer.review.controller;

import com.muxplorer.review.dto.FoodDto;
import com.muxplorer.review.dto.FoodRequest;
import com.muxplorer.review.service.FoodReceiveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/food")
@RequiredArgsConstructor
public class FoodController {

    private final FoodReceiveService foodReceiveService;

    @PostMapping("/create")
    public FoodDto foodADD(@RequestBody FoodRequest foodRequest) {
        return new FoodDto(foodReceiveService.addFood(foodRequest));
    }
}
