package com.muxplorer.review.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "food")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FoodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String restaurant;
    private String food_url;

    @OneToMany(mappedBy = "food", cascade = CascadeType.REMOVE)
    private List<ReviewEntity> reviewEntityList;
}
