package com.curiouscoder.product_service.command_api.entity;


import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;


@Data
@Builder
public class ProductModel {

    @TargetAggregateIdentifier
    private String id;

    private String name;
    private double price;
    private int quantity;

}
