package lt.ca.javau11;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private List<Order> orders = new ArrayList<>();
    private long nextOrderId = 1;

    // Sukurti naują užsakymą
    public Order createOrder(List<Pizza> pizzas) {
        Order order = new Order(nextOrderId++, pizzas);
        orders.add(order);
        return order;
    }

    // Gauti užsakymą pagal ID
    public Order getOrderById(Long orderId) {
        return orders.stream().filter(order -> order.getId().equals(orderId)).findFirst().orElse(null);
    }

    // Pridėti picą į užsakymą
    public void addPizzaToOrder(Long orderId, Pizza pizza) {
        Order order = getOrderById(orderId);
        if (order != null) {
            order.getPizzas().add(pizza);
            order.setTotalPrice(order.calculateTotalPrice()); // Atnaujinti bendrą kainą
        }
    }

    // Pašalinti picą iš užsakymo
    public void removePizzaFromOrder(Long orderId, Long pizzaId) {
        Order order = getOrderById(orderId);
        if (order != null) {
            order.getPizzas().removeIf(pizza -> pizza.getId().equals(pizzaId));
            order.setTotalPrice(order.calculateTotalPrice()); // Atnaujinti bendrą kainą
        }
    }
    
    public List<Order> getAllOrders(){
    	return orders;
    }
}
