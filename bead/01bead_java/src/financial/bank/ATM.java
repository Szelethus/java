package financial.bank;

import financial.bank.Bank;
// import java.lang.Math;

public class ATM
{
  private Bank bank;
  private int amount;

  private ATM(Bank bank, int amount)
  {
    this.bank = bank;
    this.amount = amount;
  }

  public static ATM makeATM(String bankName, int amount)
  {
    if (amount > 0)
    {
      try
      {
        return new ATM(Bank.valueOf(bankName), amount);
      }
      catch (IllegalArgumentException e)
      {
        return null;
      }
    }
    else
      return null;
  }

  public int getAmount()
  {
    return this.amount;
  }

  public void decreaseAmount(int value)
  {
    amount -= value;
  }

  public void increaseAmount(int value)
  {
    amount += value;
  }

  public int calculateFee(Bank bank, int value)
  {
    int ATMCost;

    if (this.bank == bank)
    {
      int onePercent = (int)Math.ceil(value * 0.01);
      ATMCost = (onePercent < 200 ? 200 : onePercent);
    }
    else
    {
      int threePercent = (int)Math.ceil(value * 0.03);
      ATMCost = (threePercent < 500 ? 500 : threePercent);
    }

    return ATMCost;
  }
}
