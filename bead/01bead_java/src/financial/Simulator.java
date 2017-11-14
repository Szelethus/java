package financial;

import financial.bank.ATM;
import financial.person.Customer;
import java.util.*;
import java.io.*;

public class Simulator
{
  private ATM atm;
  private LinkedList<Customer> customers;
  private PrintWriter pwLog;

  private Customer getCustomerByName(String customerName)
  {
    int i = 0;
    while (i < customers.size()
        && customers.get(i).getName().equals(customerName) == false)
      ++i;
    if (i < customers.size())
      return customers.get(i);
    else
      return null;
  }

  public Simulator(String bankName, int initAmount, String outputFileName)
      throws IllegalArgumentException, FileNotFoundException, SecurityException
  {
    customers = new LinkedList<Customer>();
    pwLog = new PrintWriter(outputFileName);
    this.atm = ATM.makeATM(bankName, initAmount);

    if (this.atm == null)
      throw new IllegalArgumentException();
  }

  public void insertCustomer(
      String customerName, int birthYear, String bankName)
  {
    if (getCustomerByName(customerName) == null)
    {
      Customer newCustomer
          = Customer.makeCustomer(customerName, birthYear, bankName);
      if (newCustomer != null)
        customers.add(newCustomer);
    }
  }

  public void withdrawCash(String customerName, int amount)
  {
    Customer current = getCustomerByName(customerName);

    if (current != null && amount > 0 && atm.getAmount() > amount)
    {
      int amountPlusFee = amount + atm.calculateFee(current.getBank(), amount);

      if (current.getAmount() > amountPlusFee)
      {
        current.decreaseAmount(amountPlusFee);
        atm.decreaseAmount(amount);
        pwLog.println(current.toString());
      }
    }
  }

  public void depositCash(String customerName, int amount)
  {
    Customer current = getCustomerByName(customerName);
    if (current != null && amount > 0)
    {
      current.increaseAmount(amount);
      atm.increaseAmount(amount);
      pwLog.println(current.toString());
    }
  }

  private void executeCommand(String command, String args[])
  {
    switch (command)
    {
    case "REG":
      if (args.length != 3)
        return;
      insertCustomer(args[0], Integer.parseInt(args[1]), args[2]);
      break;

    case "GET":
      if (args.length != 2)
        return;
      withdrawCash(args[0], Integer.parseInt(args[1]));
      break;

    case "PUT":
      if (args.length != 2)
        return;
      depositCash(args[0], Integer.parseInt(args[1]));
      break;
    }
  }

  public void simulate(String inputFileName) throws Exception
  {
    BufferedReader reader
        = new BufferedReader(new FileReader(new File(inputFileName)));

    String str = reader.readLine();

    while (str != null)
    {
      String commandAndArgs[] = str.split(":"); // processing the current line
      str = reader.readLine(); // reading the NEXT line

      if (commandAndArgs.length != 2)
        continue;

      String command = commandAndArgs[0];
      String args[] = commandAndArgs[1].split(",");
      try
      {
        executeCommand(command, args);
      }
      catch (NumberFormatException e)
      {
        // If this exception is caught, args' second element isnt a number.
      }
    }
  }

  public void close()
  {
    pwLog.close();
  }
}
