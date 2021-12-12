package Managers;

import DatabaseAccess.ManageCustomers;
import Models.Customer;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class CustomerManager
{
  ManageCustomers manageCustomers;
  Gson gson = new Gson();

  public void addCustomer(String customerAsJson)
  {
    System.out.println(customerAsJson);
    try
    {
      Customer customer = gson.fromJson(customerAsJson, Customer.class);
      manageCustomers.addCustomer(customer);
    }
    catch (Exception e){
      System.out.println(e);
    }
  }

  public String getCustomer(String username)
  {
    try
    {
      return gson.toJson(manageCustomers.getCustomer(username));
    }
    catch (Exception e){
      System.out.println(e);
      return null;
    }
  }

  public void updateCustomer(String customerAsJson){
    try{
      Customer customer = gson.fromJson(customerAsJson, Customer.class);
      manageCustomers.updateCustomer(customer);
    }
    catch (Exception e){
      System.out.println(e);
    }
  }

  public void deleteCustomer(String username){
    try{
      manageCustomers.deleteCustomer(username);
    } catch (JsonSyntaxException e) {
      e.printStackTrace();
    }
  }


}
