import java.util.*;

public class EnumerateNumbers
{
  public static void main(String[] args)
  {
    Vector<Integer> numbers = new Vector<Integer>();
    int nonNumbers = 0;

    for (String arg : args)
    {
      try
      {
        numbers.add(Integer.parseInt(arg));
      }
      catch (java.lang.NumberFormatException e)
      {
        nonNumbers++;
      }
    }

    Collections.sort(numbers);

    System.out.println(numbers);
    System.out.println("Non-numbers: " + nonNumbers);
  }
}
