package Managers;

import DatabaseAccess.Food4UDAO;
import Models.Customer;
import Models.Item;
import Models.Restaurant;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

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
      food4UDAO.addCustomer(customer);
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

  public void UpdateCustomer(String customerAsJson){
    try{
      Customer customer = gson.fromJson(customerAsJson, Customer.class);
      food4UDAO.updateCustomer(customer);
    }
    catch (Exception e){
      System.out.println(e);
    }
  }

  public void deleteCustomer(String customerAsJson){
    try{
      Customer customer = gson.fromJson(customerAsJson, Customer.class);
      food4UDAO.deleteCustomer(customer.getUsername());
    } catch (JsonSyntaxException e) {
      e.printStackTrace();
    }
  }

}
