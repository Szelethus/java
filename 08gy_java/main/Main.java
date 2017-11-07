package main;

import market.Market;
import market.Fruit;
import java.util.*;

public class Main
{
  public static void main(String[] args)
  {
    try
    {
      if(args.length != 1)
        System.out.println("java main.Main <file_name>");
      
      Market market = new Market(args[0]);
      LinkedList<Fruit> list = market.sale();

      for(Fruit fruit : list)
        System.out.println(fruit);
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }
}

