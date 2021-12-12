package Managers;

import DatabaseAccess.ManageDrivers;
import Models.Driver;
import com.google.gson.Gson;

public class DriverManager {
    ManageDrivers manageDrivers;
    Gson gson = new Gson();

    public void addDriver(String driverAsJson) {
        System.out.println(driverAsJson);
        try {
            Driver driver = gson.fromJson(driverAsJson, Driver.class);
            manageDrivers.addDriver(driver);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String getDriver(String username) {
        try {
            return gson.toJson(manageDrivers.getDriver(username));
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void updateDriver(String driverAsJson) {
        try {
            Driver driver = gson.fromJson(driverAsJson, Driver.class);
            manageDrivers.updateDriver(driver);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteDriver(String username) {
        try {
            manageDrivers.deleteDriver(username);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
