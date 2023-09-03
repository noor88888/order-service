package com.food_order_api.Order_API.Service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import com.food_order_api.Order_API.Dto.OrderDTO;
import com.food_order_api.Order_API.Dto.OrderDTOFromFE;
import com.food_order_api.Order_API.Dto.UserDTO;
import com.food_order_api.Order_API.Entity.Orders;
import com.food_order_api.Order_API.Mapper.OrderMapper;
import com.food_order_api.Order_API.Repository.OrderRepository;

public class OrderServiceTest {
	 @Mock
	    private OrderRepository orderRepo;

	    @Mock
	    private SequenceGenerator sequenceGenerator;

	    @Mock
	    private RestTemplate restTemplate;

	    @InjectMocks
	    private OrderServiceImpl orderService;

	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.openMocks(this);
	    }

	    @Test
	    void saveOrderInDb_shouldSaveOrderAndReturnOrderDTO() {
	        // Arrange
	        OrderDTOFromFE orderDetails = new OrderDTOFromFE();
	        Integer newOrderId = 1;
	        UserDTO userDTO = new UserDTO();
	        Orders orderToBeSaved = new Orders(newOrderId, orderDetails.getFoodItemsList(), orderDetails.getRestaurant(), userDTO);
	        OrderDTO orderDTOExpected = OrderMapper.INSTANCE.mapOrderToOrderDTO(orderToBeSaved);

	        when(sequenceGenerator.generateNextOrderId()).thenReturn(newOrderId);
	        when(restTemplate.getForObject(anyString(), eq(UserDTO.class))).thenReturn(userDTO);
	        when(orderRepo.save(orderToBeSaved)).thenReturn(orderToBeSaved);

	        // Act
	        OrderDTO orderDTOActual = orderService.saveOrderInDb(orderDetails);

	        // Assert
	        verify(sequenceGenerator, times(1)).generateNextOrderId();
	        assertDoesNotThrow(() -> orderService.saveOrderInDb(orderDetails));
	    }

}
