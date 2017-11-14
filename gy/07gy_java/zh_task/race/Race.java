package race;

import person.Driver;
import java.io.*;
import java.util.*;

public class Race
{
  private String name;
  private Driver drivers[];

  public Race(String inputFileName) throws Exception
  {
    BufferedReader reader
        = new BufferedReader(new FileReader(new File(inputFileName)));

    name = reader.readLine();
    int raceCount = Integer.parseInt(reader.readLine());

    LinkedList<Driver> list = new LinkedList<Driver>();

    for (int i = 0; i < raceCount; ++i)
    {
      list.add(new Driver(reader.readLine()));
    }

    drivers = list.toArray(new Driver[raceCount]);
  }

  public List getDriversOfRace(String raceName)
  {
    LinkedList<Driver> ret = new LinkedList<Driver>();
    for (Driver driver : drivers)
    {
      if (Arrays.asList(driver.getRaces()).contains(raceName))
      {
        ret.add(driver);
      }
    }
    return new LinkedList<Driver>(ret);
  }

  public String toString()
  {
    return "Race: (" + name + ", " + drivers + ")";
  }
}
