package main;

import financial.Simulator;

public class Main
{
  public static void main(String args[])
  {
    if(args.length < 3 || args.length > 4)
    {
      System.out.println("The program requires exactly 3 arguments.");
      return;
    }
    try
    {
      Simulator simulator = new Simulator(args[0], Integer.parseInt(args[1]), args[2]); 
    }
    catch(Exception e)
    {
      System.out.println(e.getClass() + " " + e.getMessage());
    }
  }
}
