package com.muxplorer.review.service;

import com.muxplorer.review.domain.FoodEntity;
import com.muxplorer.review.repository.FoodRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodStatusService {

    private final FoodRepository foodRepository;

    public List<FoodEntity> findAllFood() {return foodRepository.findAll();}
}
