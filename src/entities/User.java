package entities;

import java.util.UUID;

public class User {
  private UUID id;
  private String name;
  private Double spending;
  

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

  public UUID getId() {
    return id;
  }
}
