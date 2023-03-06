package com.malchev.HomeWork16.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Setter
@Getter
@Builder
public class OrderRespDTO {
    private long id;
    private LocalDate date;
    private long cost;
    private List<ProductRespDTO> products;
}
