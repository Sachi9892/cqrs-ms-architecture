package com.curiouscoder.product_service.command_api.aggregate;


import com.curiouscoder.product_service.command_api.commands.CreateProductCommand;
import com.curiouscoder.product_service.command_api.event.ProductCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class ProductAggregate {

    @AggregateIdentifier
    private String id;

    private String name;
    private double price;
    private int quantity;


    @CommandHandler
    public ProductAggregate(CreateProductCommand createProductCommand) {

        ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent();
        BeanUtils.copyProperties(createProductCommand , productCreatedEvent);

        //For each time change in state will affect the aggregate state
        AggregateLifecycle.apply(productCreatedEvent);
    }


    public  ProductAggregate() {

    }

    //Handle the state of the product
    @EventSourcingHandler
    public void on(ProductCreatedEvent productCreatedEvent) {

        this.quantity = productCreatedEvent.getQuantity();
        this.id = productCreatedEvent.getId();
        this.price = productCreatedEvent.getPrice();
        this.name = productCreatedEvent.getName();

    }

}
