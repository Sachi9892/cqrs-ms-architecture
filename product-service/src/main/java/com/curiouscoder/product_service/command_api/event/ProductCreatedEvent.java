package com.curiouscoder.product_service.command_api.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ProductCreatedEvent {

    private String id;

    private String name;
    private double price;
    private int quantity;

}
