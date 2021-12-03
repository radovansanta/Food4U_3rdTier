package Managers;

import DatabaseAccess.Food4UDAO;
import Models.Customer;
import Models.Restaurant;
import com.google.gson.Gson;

public class CustomerManager
{
  Food4UDAO food4UDAO = Food4UDAO.getInstance();
  Gson gson = new Gson();

  public void AddCustomer(String customerAsJson)
  {
    System.out.println(customerAsJson);
    try
    {
      Customer customer = gson.fromJson(customerAsJson, Customer.class);
      //TODO uncomment this once the DAO class impelemnted the method
      //food4UDAO.addCustomer(customer);
    }
    catch (Exception e){
      System.out.println(e);
    }
  }

  public String GetCustomer(String username)
  {
    try
    {
      return gson.toJson(food4UDAO.getCustomer(username));
    }
    catch (Exception e){
      System.out.println(e);
      return null;
    }
  }
}
