package Managers;

import DatabaseAccess.ManageDeliveryOptions;
import com.google.gson.Gson;

public class DeliveryOptionsManager {
    private ManageDeliveryOptions manageDeliveryOptions;
    private Gson gson;

    public DeliveryOptionsManager(ManageDeliveryOptions manageDeliveryOptions) {
        this.manageDeliveryOptions = manageDeliveryOptions;
        this.gson = new Gson();
    }
}
