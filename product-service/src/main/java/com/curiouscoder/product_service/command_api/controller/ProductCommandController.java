package com.curiouscoder.product_service.command_api.controller;


import com.curiouscoder.product_service.command_api.commands.CreateProductCommand;
import com.curiouscoder.product_service.command_api.entity.ProductModel;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductCommandController {

    private final CommandGateway commandGateway;

    @PostMapping("/create")
    public String create(@RequestBody ProductModel productModel) {

        CreateProductCommand command = CreateProductCommand
                .builder()
                .id(UUID.randomUUID().toString())
                .name(productModel.getName())
                .price(productModel.getPrice())
                .quantity(productModel.getQuantity())
                .build();

        return commandGateway.sendAndWait(command);

    }


}
