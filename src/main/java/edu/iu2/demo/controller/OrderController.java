package edu.iu2.demo.controller;
import edu.iu2.demo.model.Order;
import edu.iu2.demo.model.Return;
import org.springframework.web.bind.annotation.*;
import edu.iu2.demo.repository.OrderRepository;
import jakarta.validation.Valid;

import java.util.List;
//NOTE: JSON dictionary keys should match get and set in Order exactly (except for first capital letter)-
//-retrieving is done automatically
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
    public Order findByID(@PathVariable int id){
        return repository.getOrderByID(id);
    }

    //we have added validation criteria to Order class
    @PostMapping
    public int create(@Valid @RequestBody Order order)
    {
//        System.out.println("\n\n----------------------Create order----------------------");
//        System.out.println(order.getTotal());
//        System.out.println(order.getCustomerId());
        return repository.create(order);
    }

    //Note: setters automatically called or Return class matching return API
    @PutMapping("/return")
    public void update(@RequestBody Return r)
    {
        repository.update(r);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id)
    {
        repository.deleteOrder(id);
    }
}
