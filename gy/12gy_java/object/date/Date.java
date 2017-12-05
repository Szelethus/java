public class Date // implements Comparable<Date>
{
  public enum Month {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER
  }
  private final int day;
  private final int month;
  private final int year;

  public Date(int day, int month, int year)
  {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  public Date(String date)
  {
    String arr[] = date.split("/");
    this.day = Integer.parseInt(arr[0]);
    this.month = Integer.parseInt(arr[1]);
    this.year = Integer.parseInt(arr[2]);
  }
}
