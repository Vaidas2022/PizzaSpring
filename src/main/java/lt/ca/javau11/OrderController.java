package lt.ca.javau11;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PizzaService pizzaService;

    // Pašalinti picą iš užsakymo
    @PostMapping("/{orderId}/removePizza/{pizzaId}")
    public ResponseEntity<Void> removePizzaFromOrder(@PathVariable Long orderId, @PathVariable Long pizzaId) {
        orderService.removePizzaFromOrder(orderId, pizzaId);
        return ResponseEntity.ok().build();  // Sėkmingas atsakymas
    }

    // Sukurti naują užsakymą (API)
    @PostMapping
    public Order createOrder(@RequestBody List<Pizza> pizzas) {
        return orderService.createOrder(pizzas);
    }
    
    @GetMapping
    public List<Order> getAll(){
    	return orderService.getAllOrders();
    }
}
