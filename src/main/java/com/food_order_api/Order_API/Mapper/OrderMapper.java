package com.food_order_api.Order_API.Mapper;

import com.food_order_api.Order_API.Dto.OrderDTO;
import com.food_order_api.Order_API.Entity.Orders;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Orders mapOrderDTOToOrder(OrderDTO orderDTO);
    OrderDTO mapOrderToOrderDTO(Orders order);

}