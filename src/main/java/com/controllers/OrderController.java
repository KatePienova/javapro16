package com.controllers;


import com.domain.dto.OrderReqDTO;
import com.domain.dto.OrderRespDTO;
import com.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/orders/{id}")
    public ResponseEntity<? super OrderRespDTO> getOrderById(@PathVariable("id") Long id) {
        Optional<OrderRespDTO> orderById = orderService.getOrderById(id);
        if (orderById.isPresent()) {
            return ResponseEntity.status(200).body(orderById);
        }
        return new ResponseEntity<>("Заказ не найден", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/orders")
    public ResponseEntity<? super List<OrderRespDTO>> allOrders() {
        List<OrderRespDTO> orders = orderService.getOrders();
        if (orders.isEmpty()) {
            return new ResponseEntity<>("Заказ не найден ", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.status(200).body(orders);
    }

    @PostMapping("/orders")
    public ResponseEntity<? super OrderRespDTO> create(@RequestBody(required = false) OrderReqDTO orderReqDTO) {
        if (orderReqDTO.getProducts() == null) {
            return new ResponseEntity<>("Заказ не создан", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.status(201).body(orderService.addOrder(orderReqDTO));
    }
}
