package person;

import java.util.*;

public class Driver
{
  private String name;
  private String races[];

  public String getName()
  {
    return new String(name);
  }

  public String[] getRaces()
  {
    return Arrays.copyOf(races, races.length);
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setRaces(String races[])
  {
    this.races = races;
  }

  public Driver(String name, String races[])
  {
    this.name = name;
    this.races = races;
  }

  public Driver(String data)
  {
    String dataSplit[] = data.split(",");
    if(dataSplit.length != 1)
    {
      this.name = dataSplit[0];
      this.races = Arrays.copyOfRange(dataSplit, 1, dataSplit.length);
    }
    else
    {
      this.name = data;
    }
  }

  public boolean hasRace(String raceName)
  {
    return Arrays.asList(races).contains(raceName);
  }

  public String toString()
  {
    return "Driver[" + name + races + "]";
  }
}
