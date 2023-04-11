package edu.iu2.demo.controller;
import edu.iu2.demo.model.Order;
import edu.iu2.demo.model.OrderItem;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import edu.iu2.demo.repository.OrderRepository;

import java.util.List;
import java.util.Optional;
//NOTE: JSON dictionary keys should match get and set in Order exactly (except for first capital letter)-
//-retrieving is done automatically

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderRepository repository;

    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public int create(@RequestBody Order order){

        for(int i = 0; i < order.getItems().size(); i++){
            OrderItem item = order.getItems().get(i);
            item.setOrder(order);
        }
        Order addedOrder = repository.save(order);
        return addedOrder.getId();
    }

    @GetMapping("/{customerId}")
    public List<Order> findByCustomer(@PathVariable int customerId){
        return repository.findByCustomerId(customerId);
    }

    @GetMapping("/order/{orderId}")
    public Optional<Order> findByOrderId(@PathVariable int orderId){
        return repository.findById(orderId);
    }

}
