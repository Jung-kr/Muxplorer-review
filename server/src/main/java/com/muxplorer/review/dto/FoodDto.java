package com.muxplorer.review.dto;

import com.muxplorer.review.domain.FoodEntity;
import lombok.Getter;
import lombok.Setter;

import static org.springframework.beans.BeanUtils.copyProperties;

@Getter
@Setter
public class FoodDto {
    private Long id;
    private String name;
    private String restaurant;
    private String food_url;

    public FoodDto(FoodEntity foodEntity) {
        copyProperties(foodEntity, this);
    }
}
