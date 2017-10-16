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

  }

  public Simulator(String bankName, int initAmount, String outputFileName)
  {
    this.atm = ATM.makeATM(bankName, initAmount);
    
    if(this.atm == null)
      throw new IllegalArgumentException();

    customers = new LinkedList<Customer>();

    pwLog = new PrintWriter(outputFileName);
  }


}
