package market;

import java.text.NumberFormat;

public class Fruit
{
  private String name;
  private int price;

  static Fruit cheapest;

  private Fruit(String name, int price)
  {
    this.name = name;
    this.price = price;
    if(cheapest != null && cheapest.price > price)
      cheapest = this;
  }

  private Fruit(Fruit other)
  {
    this(other.name, other.price);
  }

  public int getPrice()
  {
    return this.price;
  }

  public boolean cheaperThan(Fruit other)
  {
    return this.price < other.price;
  }

  static public Fruit make(String name, int price)
  {
    if(name.matches("[A-Za-z]{2,}") && price < 5000 && price % 5 == 0)
      return new Fruit(name, price);
    else
      return null;
  }

  public String show()
  {
    return name + " (" + price + " FT)";
  }

  public static Fruit getCheapest()
  {
    return new Fruit(Fruit.cheapest);
  }
}
