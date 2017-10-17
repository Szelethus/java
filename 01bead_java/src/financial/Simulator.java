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
    while (i < customers.size() && customers.get(i).getName().equals(customerName) == false)
      ++i;
    if(i < customers.size())
      return customers.get(i);
    else
      return null;
  }

  public Simulator(String bankName, int initAmount, String outputFileName) throws IllegalArgumentException, FileNotFoundException, SecurityException
  {
    this.atm = ATM.makeATM(bankName, initAmount);
    
    if(this.atm == null)
      throw new IllegalArgumentException();

    customers = new LinkedList<Customer>();

    pwLog = new PrintWriter(outputFileName);
  }
  
  public void insertCustomer(String customerName, int birthYear, String bankName)
  {
    if(getCustomerByName(customerName) == null)
    {
      Customer newCustomer = Customer.makeCustomer(customerName, birthYear, bankName);
      if(newCustomer != null)
        customers.add(newCustomer);
    }
  }

  public void withdrawCash(String customerName, int amount)
  {
    Customer current = getCustomerByName(customerName);

    if(current != null && amount > 0 && atm.getAmount() > amount)
    {
      int amountPlusFee = amount + atm.calculateFee(current.getBank(), amount);

      if(current.getAmount() > amountPlusFee)
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
    if(current != null && amount > 0)
    {
      current.increaseAmount(amount);
      atm.increaseAmount(amount);
      pwLog.println(current.toString());
    }
  }

  public void simulate(String inputFileName) throws Exception
  {
		BufferedReader reader = new BufferedReader(new FileReader(new File(inputFileName)));
		
		String str = reader.readLine();
		String command;

		while(str != null)
    {
			String strArr [] = str.split(":"); //processing the current line
      str = reader.readLine(); //reading the NEXT line

      if(strArr.length != 2)
        continue;

			command = strArr[0];
      try
      {
        switch(command)
        {
          case "REG":
            String customerData [] = strArr[1].split(",");
            if(customerData.length != 3)
              continue;
            insertCustomer(customerData[0], Integer.parseInt(customerData[1]), customerData[2]);
            break;

          case "GET":
            String withdrawData [] = strArr[1].split(",");
            if(withdrawData.length != 2)
              continue;
            withdrawCash(withdrawData[0], Integer.parseInt(withdrawData[1]));
            break;

          case "PUT":
            String depositData [] = strArr[1].split(",");
            if(depositData.length != 2)
              continue;
            depositCash(depositData[0], Integer.parseInt(depositData[1]));
            break;

          default:
            break;
        }
      }
      catch(NumberFormatException e)
      {
        //If this exception is caught, *Data array's second element isnt a number.
        //This is not a fatal error, the rest of the file can be processed,
        //but this line is not a valid input.
      }
    }
  }
  
  public void close()
  {
    pwLog.close();
  }
}
