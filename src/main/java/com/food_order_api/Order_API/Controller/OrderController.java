package com.food_order_api.Order_API.Controller;

import com.food_order_api.Order_API.Dto.OrderDTO;
import com.food_order_api.Order_API.Dto.OrderDTOFromFE;
import com.food_order_api.Order_API.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping()
    ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTOFromFE orderdetails)
    {
        OrderDTO orderDTO=orderService.saveOrderInDb(orderdetails);
        return new ResponseEntity<>(orderDTO, HttpStatus.CREATED);
    }

}
