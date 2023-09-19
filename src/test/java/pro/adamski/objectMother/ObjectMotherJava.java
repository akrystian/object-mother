package pro.adamski.objectMother;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObjectMotherJava {
    private static final Random random = new Random();

    public static CustomerBuilder customer() {
        return new CustomerBuilder()
                .withId(random.nextInt())
                .withName("John Doe" + random.nextInt())
                .withEmail("info-" + random.nextInt() + "@example.com");
    }

    public static ProductBuilder product() {
        return new ProductBuilder()
                .withId(random.nextInt())
                .withName("The " + random.nextInt() + "th laptop")
                .withPrice(random.nextDouble() * (5000.0 - 1000.0) + 1000.0);
    }

    public static OrderBuilder order() {
        return new OrderBuilder()
                .withId(random.nextInt())
                .withCustomer(customer().build())
                .addProduct(product().build());
    }

    public static Order largeOrder() {
        OrderBuilder orderBuilder = new OrderBuilder()
                .withId(random.nextInt())
                .withCustomer(customer().build());

        for (int i = 0; i < 100; i++) {
            orderBuilder.addProduct(product().withId(i).withName("Product" + i).build());
        }
        return orderBuilder.build();
    }
}

class CustomerBuilder {
    private int id;
    private String name;
    private String email;

    public CustomerBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public CustomerBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CustomerBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public Customer build() {
        return new Customer(id, name, email);
    }
}

class ProductBuilder {
    private int id;
    private String name;
    private double price;

    public ProductBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public ProductBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder withPrice(double price) {
        this.price = price;
        return this;
    }

    public Product build() {
        return new Product(id, name, price);
    }
}

class OrderBuilder {
    private int id;
    private Customer customer;
    private List<Product> products = new ArrayList<>();

    public OrderBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public OrderBuilder withCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public OrderBuilder addProduct(Product product) {
        this.products.add(product);
        return this;
    }

    public OrderBuilder withProducts(List<Product> products) {
        this.products = products;
        return this;
    }

    public Order build() {
        return new Order(id, customer, products);
    }
}
