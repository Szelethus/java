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
    while (i < customers.size() && customers.get(i).getName() == customerName)
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
    if(getCustomerByName(customerName) != null)
    {
      customers.add(Customer.makeCustomer(customerName, birthYear, bankName));
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
        pwLog.print(current.toString());
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
      pwLog.print(current.toString());
    }
  }

  public void simulate(String inputFileName) throws Exception
  {
		BufferedReader reader = new BufferedReader(new FileReader(new File(inputFileName)));
		
		String str [] = new String[2];
		String command;

		while(str != null)
    {
			str = reader.readLine().split(":");
			command = str[0];

			switch(command)
			{
			  case "REG":
          String customerData [] = str[1].split(",");
          insertCustomer(customerData[0], Integer.parseInt(customerData[1]), customerData[2]);
          break;
        case "GET":
          String withdrawData [] = str[1].split(",");
          withdrawCash(withdrawData[0], Integer.parseInt(withdrawData[1]));
          break;
        case "PUT":
          String depositData [] = str[1].split(",");
          depositCash(depositData[0], Integer.parseInt(depositData[1]));
          break;
			}
		}
  }
  
  public void close()
  {
    pwLog.close();
  }
}
