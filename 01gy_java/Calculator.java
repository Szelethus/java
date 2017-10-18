public class Calculator
{
  public static void main(String[] args)
  {
    if (args.length == 2)
    {
      double first = Double.parseDouble(args[0]),
             second = Double.parseDouble(args[1]);
      System.out.println("---===ADDITION===---");
      System.out.println(first + second);
      System.out.println("---===SUBTRACTION===---");
      System.out.println(first + second);
      System.out.println("---===MULTIPLICATION===---");
      System.out.println(first * second);
      System.out.println("---===DIVISION===---");
      if (second == 0)
        System.out.println("Not defined.");
      else
        System.out.println(first / second);
    }
    else
    {
      System.out.println("This program requires exactly 2 arguments.");
    }
  }
}