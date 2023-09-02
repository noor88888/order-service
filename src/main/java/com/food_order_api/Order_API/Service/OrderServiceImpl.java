package com.food_order_api.Order_API.Service;

import com.food_order_api.Order_API.Dto.OrderDTO;
import com.food_order_api.Order_API.Dto.OrderDTOFromFE;
import com.food_order_api.Order_API.Dto.UserDTO;
import com.food_order_api.Order_API.Entity.Orders;
import com.food_order_api.Order_API.Entity.Sequence;
import com.food_order_api.Order_API.Mapper.OrderMapper;
import com.food_order_api.Order_API.Repository.OrderRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    SequenceGenerator sequence;

    @Override
    public OrderDTO saveOrderInDb(OrderDTOFromFE orderdetails) {

        Integer newOrderId=sequence.generateNextOrderId();
        UserDTO userDTO =fetchUserDetailsFromUSerId(orderdetails.getUserId());
        Orders orders=new Orders(newOrderId,orderdetails.getFoodItemsList(),orderdetails.getRestaurant(),userDTO);
        orderRepository.save(orders);
        return OrderMapper.INSTANCE.mapOrderToOrderDTO(orders);
    }

    private UserDTO fetchUserDetailsFromUSerId(Integer userId) {

    UserDTO userDTO= restTemplate.getForObject("http://USER-SERVICE/user/fetchUserById/"+userId,UserDTO.class);
    return userDTO;
    }
}
