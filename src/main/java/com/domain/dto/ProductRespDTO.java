package com.malchev.HomeWork16.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ProductRespDTO {
    private long id;
    private String name;
    private long cost;
}
