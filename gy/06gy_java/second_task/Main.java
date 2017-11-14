import auto.Auto;
import auto.color.Color;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Main
{
  public static void main() throws Exception
  {
    LinkedList<Auto> list;
    BufferedReader reader
        = new BufferedReader(new FileReader(new File("input.txt")));

    for (String str = reader.readLine(); str != null; str = reader.readLine())
    {
      String autoData[] = str.split(",");
      list.add(Auto(autoData[0].substring(1, autoData[0].length() - 1),
          Color.valueOf(autoData[1]), Integer.parseInt(autoData[2])));
    }
  }
}
