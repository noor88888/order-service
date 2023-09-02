package com.food_order_api.Order_API.Repository;

import com.food_order_api.Order_API.Entity.Orders;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Orders,Integer> {
}
