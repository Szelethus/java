package shop;

import shop.Platform;

public class Game
{
  private String developer;
  private String title;
  private int piecesOnStock;
  private int soldCount;
  private int id;
  private Platform platform;

  private static int idTracker = 0;

  private Game(
      String developer, String title, int piecesOnStock, Platform platform)
  {
    this.developer = developer;
    this.title = title;
    this.piecesOnStock = piecesOnStock;
    this.soldCount = 0;
    this.id = Game.idTracker++;
    this.platform = platform;
  }

  static public Game make(
      String developer, String title, int piecesOnStock, String platform)
  {
    if (developer != null && developer.length() != 0 && title != null
        && title.length() != 0 && piecesOnStock > 0)
    {
      try
      {
        return new Game(
            developer, title, piecesOnStock, Platform.valueOf(platform));
      }
      catch (IllegalArgumentException e)
      {
        return null;
      }
    }
    else
      return null;
  }

  public String getDeveloper()
  {
    return new String(developer);
  }

  public String getTitle()
  {
    return new String(title);
  }

  public int getPiecesOnStock()
  {
    return piecesOnStock;
  }

  public Platform getPlatform()
  {
    return platform;
  }

  public void buy(int count)
  {
    if (count < this.piecesOnStock)
    {
      this.piecesOnStock -= count;
      this.soldCount += count;
    }
  }

  public String toString()
  {
    return developer + ": " + title + " (" + piecesOnStock + " pcs)";
  }

  public boolean betterSellThan(Game other)
  {
    if (other != null)
      return this.soldCount > other.soldCount;
    else
      return false;
  }
}