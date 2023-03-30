package edu.iu2.demo.controller;
import edu.iu2.demo.model.Order;
import org.springframework.web.bind.annotation.*;
import edu.iu2.demo.repository.OrderRepository;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    //reference to our repository
    private OrderRepository repository;

    //Spring knows to create object of this class because @RestController added
    public OrderController(OrderRepository repository)
    {
        this.repository = repository;
    }

    @GetMapping
    public List<Order> findAll(){
        return repository.getAllOrders();
    }

    //find by ID added
    //map url to ID added to GetMapping argument
    @GetMapping("/{id}")
    public Order findByID(@PathVariable int id){return repository.getOrderByID(id);}

    @PostMapping
    public int create(@RequestBody Order order)
    {
        return repository.create(order);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Order order, @PathVariable int id)
    {
        repository.update(order, id);
    }
}
