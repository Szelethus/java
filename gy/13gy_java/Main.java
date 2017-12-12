public class Main
{

  public static void main(String[] args)
  {
    try
    {
      BathTub bT = new BathTub("BreezeTub");
      BathRoom bR1 = new BathRoom(10, 10, 12, bT);
      BathRoom bR2 = (BathRoom)bR1.clone();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}
