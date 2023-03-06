package com.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
public class Order {
    private long id;
    private LocalDate date;
    private long cost;
    private  List<Product> products;
}
