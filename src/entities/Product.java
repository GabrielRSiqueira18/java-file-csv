package entities;

import java.util.UUID;

public class Product {
  private String name;
  private Double price;
  private UUID user_id;

  public Product(String name, Double price, User user) {
    this.user_id = user.getId();
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public Double getPrice() {
    return price;
  }

  public UUID getUser_id() {
    return user_id;
  }
}
