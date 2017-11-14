package shop;

import shop.Game;
import java.util.*;

public class Shop
{

  public ArrayList<Game> getGames()
  {
    ArrayList<Game> temp = new ArrayList<>();
    for (Game b : games)
      temp.add(b);
    return temp;
  }

  private ArrayList<Game> games;

  public Shop(ArrayList<Game> games)
  {
    this.games = new ArrayList<Game>();
    for (Game game : games)
      this.games.add(Game.make(game.getDeveloper(), game.getTitle(),
          game.getPiecesOnStock(), game.getPlatform().toString()));
  }

  public double numberOfGames()
  {
    return games.size();
  }

  public List<Game> browseGames(Platform p)
  {
    ArrayList<Game> aList = new ArrayList<Game>();
    for (Game game : games)
      if (game.getPlatform().equals(p))
      {
        aList.add(game);
      }
    return aList;
  }

  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < games.size() - 1; ++i)
      sb.append(games.get(i).toString() + "\n");
    if (games.size() > 0)
      sb.append(games.get(games.size() - 1).toString());
    return sb.toString();
  }

  public static Game bestSellingInList(List<Game> games)
  {
    if (games.size() != 0)
    {
      Game max = games.get(0);
      for (Game game : games)
      {
        if (game.betterSellThan(max))
        {
          max = game;
        }
      }
      return max;
    }
    else
      return null;
  }
}
