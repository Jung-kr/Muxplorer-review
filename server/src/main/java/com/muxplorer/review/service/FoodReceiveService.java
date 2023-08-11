package com.muxplorer.review.service;

import com.muxplorer.review.domain.FoodEntity;
import com.muxplorer.review.dto.FoodRequest;
import com.muxplorer.review.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FoodReceiveService {

    private final FoodRepository foodRepository;

    public FoodEntity addFood(FoodRequest foodRequest) {
        FoodEntity foodEntity = FoodEntity.builder()
                .name(foodRequest.getName())
                .restaurant(foodRequest.getRestaurant())
                .food_url(foodRequest.getFood_url())
                .build();

        return foodRepository.save(foodEntity);
    }


}
