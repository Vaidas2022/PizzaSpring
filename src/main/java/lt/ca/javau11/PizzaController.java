package lt.ca.javau11;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {

    private PizzaService pizzaService;
    
    //Constructor injection
    public PizzaController(PizzaService pizzaService) {
    	this.pizzaService = pizzaService;
    }

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
