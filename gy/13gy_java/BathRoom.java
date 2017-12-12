public class BathRoom implements Cloneable
{

  private int length;
  private int width;
  private int height;
  private BathTub bathTub;

  public BathRoom(int length, int width, int height, BathTub bathTub)
  {
    this.length = length;
    this.width = width;
    this.height = height;
    this.bathTub = bathTub;
  }

  public BathTub getBathTub()
  {
    return bathTub;
  }

  @Override
  public Object clone() 
  {
    try
    {
      return (BathRoom)super.clone();
    }
    catch(CloneNotSupportedException e)
    {
      assert false;
      return null;
    }
  }
}
