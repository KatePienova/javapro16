package com.services;


import com.domain.dto.OrderReqDTO;
import com.domain.dto.OrderRespDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderService {
    Optional<OrderRespDTO> getOrderById(Long orderId);

    List<OrderRespDTO> getOrders();

    Optional<OrderRespDTO> addOrder(OrderReqDTO orderReqDTO);
}
