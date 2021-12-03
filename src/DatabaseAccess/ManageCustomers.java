package DatabaseAccess;

import Models.Customer;

public interface ManageCustomers {
    void AddCustomer(Customer customer);
    void updateCustomer(Customer customer);
    Customer getCustomer(String username);
    void deleteCustomer(String username);
}
