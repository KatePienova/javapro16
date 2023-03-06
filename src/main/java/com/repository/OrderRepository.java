package com.repository;

import com.domain.Order;
import com.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class OrderRepository {
    private final Map<Long, Order> baseOrder = new HashMap<>();
    private final Random randomId = new Random();

    public Optional<Order> getOrderById(Long orderId) {
        return Optional.ofNullable(baseOrder.get(orderId));
    }

    public List<Order> getOrders() {
        return baseOrder.values()
                .stream()
                .toList();
    }

    public Order addOrder(Order order) {
        if (order != null) {
            order.setId(randomId.nextLong());
            long sum = order.getProducts().stream().mapToLong(Product::getCost).sum();
            order.setCost(sum);
            baseOrder.put(order.getId(), order);
            return order;
        }
        return null;
    }
}
