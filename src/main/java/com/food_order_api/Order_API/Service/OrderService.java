package com.food_order_api.Order_API.Service;

import com.food_order_api.Order_API.Dto.OrderDTO;
import com.food_order_api.Order_API.Dto.OrderDTOFromFE;

public interface OrderService {
    OrderDTO saveOrderInDb(OrderDTOFromFE orderdetails);

}
