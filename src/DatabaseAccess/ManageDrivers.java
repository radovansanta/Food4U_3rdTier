package DatabaseAccess;

import Models.Driver;

public interface ManageDrivers {
    void addDriver(Driver driver);
    Driver getDriver(String username);
    void updateDriver(Driver driver);
    void deleteDriver(String username);
}
