package com.malchev.HomeWork16.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class OrderReqDTO {
    private long id;
    private List<ProductDTO> products;
    @Setter
    @Getter
    @Builder
    public static class ProductDTO{
        private String name;
        private long cost;
    }
}
