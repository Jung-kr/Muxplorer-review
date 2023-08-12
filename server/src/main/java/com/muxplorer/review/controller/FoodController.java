package com.muxplorer.review.controller;

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

    @PostMapping("/create")
    public FoodDto foodADD(@RequestBody FoodRequest foodRequest) {
        return new FoodDto(foodReceiveService.addFood(foodRequest));
    }

    @GetMapping("/read/all")
    public List<FoodDto> foodAllList() {
        return foodStatusService.findAllFood().stream().map(foodEntity -> new FoodDto(foodEntity)).collect((toList()));
    }
}
