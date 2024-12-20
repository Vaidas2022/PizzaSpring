package lt.ca.javau11;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrderViewController {

    @Autowired
    private PizzaService pizzaService;

    @Autowired
    private OrderService orderService;

    // Rodyti picų meniu
    @GetMapping("/menu")
    public String showMenu(Model model) {
        model.addAttribute("pizzas", pizzaService.getAllPizzas());
        return "menu";  // Rodo "menu.html" šabloną
    }

    // Rodyti užsakymą per naršyklę
    @GetMapping("/order/{orderId}")
    public String showOrder(@PathVariable Long orderId, Model model) {
        Order order = orderService.getOrderById(orderId);
        model.addAttribute("order", order);
        return "order";  // Rodo "order.html" šabloną
    }

    // Sukurti užsakymą ir nukreipti į užsakymo peržiūrą
    @PostMapping("/createOrder")
    public String createOrder(@RequestParam List<Long> pizzaIds, Model model) {
        List<Pizza> pizzas = pizzaService.getPizzasByIds(pizzaIds);
        Order order = orderService.createOrder(pizzas);
        return "redirect:/order/" + order.getId();  // Nukreipia į užsakymo peržiūrą
    }
    
    // Rodyti visų užsakymų sąrašą
    @GetMapping("/orders")
    public String showAllOrders(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());  // Pateikiame visus užsakymus
        return "orders";  // Rodo "orders.html" šabloną
    }
}
