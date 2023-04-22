package edu.iu2.demo.controller;
import edu.iu2.demo.model.Order;
import edu.iu2.demo.model.OrderItem;
import edu.iu2.demo.model.Return;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import edu.iu2.demo.repository.OrderRepository;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.Style;
import javax.swing.text.html.Option;
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
    @CrossOrigin(origins = "http://localhost:3000")
    public int create(@RequestBody @Valid Order order){

        //order.Id is referenced as order ID -> this created automatically by system and is not in JSON
//        System.out.println(order.getId());
//        System.out.println(order.getCustomerId());
        for(int i = 0; i < order.getItems().size(); i++){
            OrderItem item = order.getItems().get(i);
//            System.out.println(item.getName());
//            System.out.println(item.getId());
//            System.out.println(item.getPrice());
//            System.out.println(item.getQuantity());
            item.setOrder(order);
        }

        Order addedOrder = repository.save(order);
        return addedOrder.getId();
    }

    @GetMapping("/order/{orderId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public Order findByOrderId(@PathVariable int orderId){
        System.out.println("Find by order ID");
        return repository.findById(
                orderId).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Order not found"));
    }

    @GetMapping("/{customerId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Order> findByCustomer(@PathVariable int customerId){
        System.out.println("Find by customer ID");
        return repository.findByCustomerId(customerId);
    }

    //Note: setters automatically called or Return class matching return API
    //{
    //    "orderId": 1,
    //    "itemId": 2,
    //    "reason" : "no longer needed"
    //}
    //Note: itemIds are generated automatically -
    //-- see @Id\n@GeneratedValue(strategy = GenerationType.AUTO) in OrderItem class
    @PutMapping("/return")
    @CrossOrigin(origins = "http://localhost:3000")
    public void update(@RequestBody Return r)
    {
        //we must find orderId -> find itemId within that order and add a reason
        Order myReturn = findByOrderId(r.getOrderId());

        if(myReturn != null)
        {
//            System.out.println(myReturn);
//            for(OrderItem i: myReturn.getItems()) {
//                System.out.println(i.getName());
//                System.out.println(i.getId());
//                System.out.println(r.getItemId());
//            }
            try
            {
                OrderItem i = myReturn.getItems().get(r.getItemId()-1);
                i.setReason(r.getReason());
//                System.out.println(i.getReason());
                //save update in database
                repository.save(myReturn);
            }
            catch (Exception e)
            {
                // handle any exceptions that might occur while updating the OrderItem
                e.printStackTrace();
                // optionally, throw a custom exception to be handled by the controller advice
                throw new RuntimeException("Failed to update OrderItem: " + e.getMessage());
            }
        }
    }

    @DeleteMapping("/{customerId}")
    public void delete(@PathVariable int customerId)
    {
        repository.deleteAll(repository.findByCustomerId(customerId));
    }



}
