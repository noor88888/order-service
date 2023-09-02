package com.food_order_api.Order_API.Entity;

import com.food_order_api.Order_API.Dto.FoodItemsDTO;
import com.food_order_api.Order_API.Dto.Restaurant;
import com.food_order_api.Order_API.Dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("order")
public class Orders {

    private Integer orderId;
    private List<FoodItemsDTO> foodItemsList;
    private Restaurant restaurant;
    private UserDTO userDTO;

}