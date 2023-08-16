package entities;

import java.util.ArrayList;
import java.util.List;

public class User {
  private String name;
  private Double spending;
  private List<Product> productsBuyeds = new ArrayList<>();

  public User(String name, Double spending) {
    this.name = name;
    this.spending = spending;
  }

  public String getName() {
    return name;
  }

  public Double getSpending() {
    return spending;
  }
}
