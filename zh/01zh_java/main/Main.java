package main;

import java.util.*;
import java.io.*;
import shop.Game;
import shop.Shop;
import shop.Platform;

public class Main
{
  public static void main(String[] args)
  {
    try
    {
      if (args.length != 2)
      {
        System.out.println("java main.Main <inputFileName> <outputFileName>");
        return;
      }
      Shop shop = new Shop(readStock(args[0]));
      simulate(shop, args[0]);
      print(shop, args[1]);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  static public ArrayList<Game> readStock(String fileName)
      throws FileNotFoundException, IOException
  {
    ArrayList<Game> list = new ArrayList<Game>();

    BufferedReader reader
        = new BufferedReader(new FileReader(new File(fileName)));

    for (String line = reader.readLine(); line != null;
         line = reader.readLine())
    {
      String gameAndParams[] = line.split(":");
      if (gameAndParams.length != 2 || gameAndParams[0].equals("Game") == false)
        continue;

      String params[] = gameAndParams[1].split(";");
      if (params.length != 4)
        continue;

      try
      {
        list.add(Game.make(
            params[0], params[1], Integer.parseInt(params[3]), params[2]));
      }
      catch (NumberFormatException e)
      {
      }
    }
    return list;
  }

  static public void simulate(Shop s, String fileName)
      throws FileNotFoundException, IOException
  {
    BufferedReader reader
        = new BufferedReader(new FileReader(new File(fileName)));
    for (String line = reader.readLine(); line != null;
         line = reader.readLine())
    {
      String sellAndParams[] = line.split(":");
      if (sellAndParams.length != 2 || sellAndParams[0].equals("Sell") == false)
        continue;

      String params[] = sellAndParams[1].split(";");
      if (params.length != 3)
        continue;

      try
      {
        ArrayList<Game> list
            = new ArrayList<Game>(s.browseGames(Platform.valueOf(params[1])));

        int index = 0;
        while (index < list.size()
            && list.get(index).getTitle().equals(params[0]) == false)
          ++index;
        if (index < list.size())
        {
          list.get(index).buy(Integer.parseInt(params[2]));
        }
      }
      catch (NumberFormatException e)
      {
      }
      catch (IllegalArgumentException e)
      {
      }
    }
  }

  static public void print(Shop a, String fileName) throws IOException
  {
    BufferedWriter writer
        = new BufferedWriter(new FileWriter(new File(fileName)));
    if (Shop.bestSellingInList(a.browseGames(Platform.XBOX)) != null)
      writer.write("XBOX : "
          + Shop.bestSellingInList(a.browseGames(Platform.XBOX)) + "\n");
    if (Shop.bestSellingInList(a.browseGames(Platform.PS)) != null)
      writer.write(
          "PS : " + Shop.bestSellingInList(a.browseGames(Platform.PS)) + "\n");
    if (Shop.bestSellingInList(a.browseGames(Platform.PC)) != null)
      writer.write(
          "PC : " + Shop.bestSellingInList(a.browseGames(Platform.PC)) + "\n");
    if (Shop.bestSellingInList(a.browseGames(Platform.COMMODORE64)) != null)
      writer.write("COMMODORE64 : "
          + Shop.bestSellingInList(a.browseGames(Platform.COMMODORE64)));
    writer.close();
  }
}