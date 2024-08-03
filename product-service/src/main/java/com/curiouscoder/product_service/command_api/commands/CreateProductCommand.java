package com.curiouscoder.product_service.command_api.commands;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateProductCommand {

    private String id;
    private String name;
    private double price;
    private int quantity;

}
