package lt.ca.javau11;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {

    private List<Pizza> pizzas = new ArrayList<>();

    // Pavyzdinės picos
    public PizzaService() {
        pizzas.add(new Pizza(1L, "Margarita", "Classic pizza with cheese and tomato", 6.99));
        pizzas.add(new Pizza(2L, "Pepperoni", "Pizza with pepperoni and cheese", 7.99));
        pizzas.add(new Pizza(3L, "Vegetariana", "Pizza with vegetables and cheese", 7.49));
    }

    // Gauti visas picas
    public List<Pizza> getAllPizzas() {
        return pizzas;
    }

    // Pridėti picą
    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    // Gauti picą pagal ID
    public Optional<Pizza> getPizzaById(Long id) {
        return pizzas.stream().filter(pizza -> pizza.getId().equals(id)).findFirst();
    }

    // Gauti picas pagal ID sąrašą
    public List<Pizza> getPizzasByIds(List<Long> pizzaIds) {
        List<Pizza> selectedPizzas = new ArrayList<>();
        for (Long id : pizzaIds) {
            getPizzaById(id).ifPresent(selectedPizzas::add);
        }
        return selectedPizzas;
    }
}
