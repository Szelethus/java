package financial.person;

import financial.bank.Bank;
import java.lang.Enum;

public class Customer
{
  /*     PRIVATE FIELDS    */

  private String name;
  private int birthYear;
  private Bank bank;
  private int amount;

  /*     PRIVATE METHODS     */

  private Customer(String name, int birthYear, Bank bank)
  {
    this.name = name;
    this.birthYear = birthYear;
    this.bank = bank;
  }

  private static boolean checkName(String name)
  {
    String strArr[] = name.split(" ");
    if (strArr.length < 2 || strArr.length > 4)
      return false;
    for (String subName : strArr)
    {
      if (subName.length() < 3)
        return false;
      if (subName.substring(0, 1).matches("[A-Z]") == false
          || Character.isUpperCase(subName.charAt(0)) == false)
        return false;
      if (subName.substring(1).matches("[a-z]+") == false)
        return false;
    }
    return true;
  }

  private static boolean checkBirthYear(int year)
  {
    return year >= 1918 && year <= 1998;
  }

  /*     PUBLIC METHODS     */

  public static Customer makeCustomer(
      String name, int birthYear, String bankName)
  {
    if (checkName(name) && checkBirthYear(birthYear))
    {
      try
      {
        return new Customer(name, birthYear, Bank.valueOf(bankName));
      }
      catch (IllegalArgumentException e)
      {
        return null;
      }
    }
    else
      return null;
  }

  public String getName()
  {
    return this.name;
  }

  public Bank getBank()
  {
    return this.bank;
  }

  public int getAmount()
  {
    return amount;
  }

  public void decreaseAmount(int value)
  {
    amount -= value;
  }

  public void increaseAmount(int value)
  {
    amount += value;
  }

  public String toString()
  {
    return name + ": " + amount;
  }
}
