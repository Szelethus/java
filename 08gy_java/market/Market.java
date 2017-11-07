package market;

import market.Fruit;
import java.io.*;
import java.util.*;

public class Market
{
  private LinkedList<Fruit> avaibleFruits;

  public Market(String oFileName) throws FileNotFoundException, IOException
  {
    BufferedReader reader = new BufferedReader(new FileReader(new File(oFileName)));
    
    String line = reader.readLine();

    while(line != null)
    {
      String nameAndPrice[] = line.split(",");
      if(nameAndPrice.length != 2)
        continue;
      try
      {
        avaibleFruits.add(Fruit.make(nameAndPrice[0], Integer.parseInt(nameAndPrice[1])));
      }
      catch(NumberFormatException e)
      {
        continue;
      }
      line = reader.readLine();
    }
  }

  public int numberOfFruits()
  {
    return avaibleFruits.size();
  }

  public String show()
  {
    StringBuilder ret = new StringBuilder("");
    for(int i = 0; i < avaibleFruits.size() - 1; i++)
    {
      ret.append(avaibleFruits.get(i) + "\n");
    }
    ret.append(avaibleFruits.get(avaibleFruits.size() - 1));

    return ret.toString();
  }

  public LinkedList<Fruit> cheaperThan(Fruit param)
  {
    LinkedList<Fruit> ret = new LinkedList<Fruit>();

    for(Fruit fruit : avaibleFruits)
    {
      if(fruit.getPrice() < param.getPrice())
        ret.add(fruit);
    }

    return ret;
  }

  public double avarage()
  {
    double sumPrice;

    if(avaibleFruits.size() == 0)
      return -1;
    else
      sumPrice = 0;

    for(Fruit fruit : avaibleFruits)
      sumPrice += fruit.getPrice();

    return sumPrice / (float)avaibleFruits.size();
  }


  public Fruit buyCheapestFruit()
  {
    if(avaibleFruits.size() == 0)
      return null;

    Fruit cheapest = avaibleFruits.get(0);

    for(Fruit fruit : avaibleFruits)
    {
      if(cheapest.getPrice() >= fruit.getPrice())
        cheapest = fruit;
    }

    avaibleFruits.remove(cheapest);
    return cheapest;
  }

  public LinkedList<Fruit> sale()
  {
    LinkedList<Fruit> ret = new LinkedList<Fruit>();

    while(avaibleFruits.size() != 0)
      ret.add(buyCheapestFruit());

    return ret;
  }
}
