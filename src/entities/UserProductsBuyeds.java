package entities;

public class UserProductsBuyeds {
  private Integer quantity;
  private Double price;
  private String userName;

  public UserProductsBuyeds(Integer quantity, Double price, String userName) {
    this.price = price;
    this.quantity = quantity;
    this.userName = userName;
  }

  public Double getPrice() {
    return price;
  }

  public String getUserName() {
    return userName;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void addQuantity(Integer quantity) {
    this.quantity += quantity;
  }


  public void addPrice(Double price) {
    this.price += price;
  }
}
