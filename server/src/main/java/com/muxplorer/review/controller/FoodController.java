package com.muxplorer.review.controller;

import com.muxplorer.review.domain.FoodEntity;
import com.muxplorer.review.dto.ApiResult;
import com.muxplorer.review.dto.FoodDto;
import com.muxplorer.review.dto.FoodRequest;
import com.muxplorer.review.service.FoodReceiveService;
import com.muxplorer.review.service.FoodStatusService;
import com.sun.tools.jconsole.JConsoleContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Controller
@ResponseBody
@RequestMapping("/food")
@RequiredArgsConstructor
public class FoodController {

    private final FoodReceiveService foodReceiveService;
    private final FoodStatusService foodStatusService;

    // 음식 리스트 받아오기(크롤링)
    @PostMapping("/register")
    public ApiResult<List<FoodEntity>> foodRegister(@RequestBody List<FoodRequest> foodRequest) {
        List<FoodEntity> foods = foodReceiveService.addFood(foodRequest);
        return ApiResult.OK(foods);
    }

    // 음식 리스트
    @GetMapping("/list")
    public ApiResult<List<FoodDto>> foodListAll() {
        return ApiResult.OK(foodStatusService.findAllFood().stream().map(foodEntity -> new FoodDto(foodEntity)).collect((toList())));
    }

    // 음식점별 음식 리스트
    @GetMapping("/list/{restaurant}")
    public ApiResult<List<FoodDto>> foodListRestaurant(@PathVariable("restaurant") String restaurant) {
        String restaurantName = null;
        if(restaurant.equals("eunhasu")) {
            restaurantName = "은하수식당";
        } else if(restaurant.equals("byeolbich")) {
            restaurantName = "별빛식당";
        } else if(restaurant.equals("hanbich")) {
            restaurantName = "한빛식당";
        }

        return ApiResult.OK(foodStatusService.findByRestaurantFood(restaurantName).stream().map(foodEntity -> new FoodDto(foodEntity)).collect(toList()));
    }
}
