package com.muxplorer.review.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "review")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private FoodEntity food;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String pictureUrl;
    private Date createDate;
    private Date modifiedDate;

}