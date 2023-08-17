package entities;

import java.util.UUID;

public class User {
  private UUID id;
  private String name;
  

  public User(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }


  public UUID getId() {
    return id;
  }
}
