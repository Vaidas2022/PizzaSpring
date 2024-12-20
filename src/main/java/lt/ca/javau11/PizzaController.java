package lt.ca.javau11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    // Grąžina visų picų sąrašą
    @GetMapping
    public List<Pizza> getAllPizzas() {
        return pizzaService.getAllPizzas();
    }

    // Prideda picą į meniu
    @PostMapping
    public void addPizza(@RequestBody Pizza pizza) {
        pizzaService.addPizza(pizza);
    }
}
