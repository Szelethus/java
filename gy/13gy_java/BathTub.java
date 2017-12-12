public class BathTub
{

  private String tubName;

  public BathTub(String tubName)
  {
    this.tubName = tubName;
  }

  public String getTubName()
  {
    return tubName;
  }

  public void setTubName(String tubName)
  {
    this.tubName = tubName;
  }

  @Override
  public Object clone() 
  {
    try
    {
      return (BathTub)super.clone();
    }
    catch(CloneNotSupportedException e)
    {
      assert false;
      return null;
    }
  }

}
