package com.food_order_api.Order_API.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    private int restaurantId;
    private String restaurantName;
    private String restaurantAddress;
    private String restaurantCity;
    private String restaurantDescription;

}