package com.mappers;

import com.domain.Product;
import com.domain.dto.OrderReqDTO;
import com.domain.dto.ProductRespDTO;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Random;

@Component
public class ProductMapper {
    private final Random randomId = new Random();

    public List<Product> orderReqDTOToProduct(OrderReqDTO orderReqDTO)  {
        List<OrderReqDTO.ProductDTO> products = orderReqDTO.getProducts();
        return products.stream()
                .map(p -> Product.builder()
                        .cost(p.getCost())
                        .id(randomId.nextLong())
                        .name(p.getName())
                        .build()
                ).toList();
    }

    public ProductRespDTO productRespDTO(Product product) {
        return ProductRespDTO.builder()
                .id(product.getId())
                .cost(product.getCost())
                .name(product.getName())
                .build();
    }
}
