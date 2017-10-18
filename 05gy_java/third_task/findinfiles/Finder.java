package findinfiles;

import java.io.*;

public class Finder
{
  public static void main(String[] args)
  {
    try
    {
      BufferedReader reader
          = new BufferedReader(new FileReader(new File(args[0])));
      String str = "";
      while (str != null)
      {
        str = reader.readLine();
        System.out.println(str);
      }
    }
    catch (Exception e)
    {
      System.out.println(e.getClass() + " " + e.getMessage());
    }
  }
}
