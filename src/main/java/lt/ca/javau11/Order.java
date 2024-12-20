package lt.ca.javau11;

import java.util.List;

public class Order {
    private Long id;
    private List<Pizza> pizzas;
    private double totalPrice;

    // Konstruktorius
    public Order(Long id, List<Pizza> pizzas) {
        this.id = id;
        this.pizzas = pizzas;
        this.totalPrice = calculateTotalPrice();  // Apskaičiuojame pradinę kainą
    }

    // Apskaičiuoti bendrą užsakymo kainą
    public double calculateTotalPrice() {
        return pizzas.stream()
                .mapToDouble(Pizza::getPrice)
                .sum();
    }

    // Nustatyti bendrą kainą
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    // Getteriai ir setteriai
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
        this.totalPrice = calculateTotalPrice();  // Atnaujiname kainą, kai keičiasi picos
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
