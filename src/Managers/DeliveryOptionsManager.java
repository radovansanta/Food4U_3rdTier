package Managers;

import DatabaseAccess.ManageDeliveryOptions;
import Models.DeliveryOption;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class DeliveryOptionsManager {
    private ManageDeliveryOptions manageDeliveryOptions;
    private Gson gson;

    public DeliveryOptionsManager(ManageDeliveryOptions manageDeliveryOptions) {
        this.manageDeliveryOptions = manageDeliveryOptions;
        this.gson = new Gson();
    }

    public void addDeliveryOption(String deliveryOptionAsJson) {
        try {
            DeliveryOption deliveryOption = gson.fromJson(deliveryOptionAsJson, DeliveryOption.class);
            manageDeliveryOptions.addDeliveryOption(deliveryOption);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
    }

    public String getDeliveryOptionsByUsername(String username) {
        try {
            return gson.toJson(manageDeliveryOptions.getDeliveryOptionsByUsername(username));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getDeliveryOption(String deliveryId){
        try{
            return gson.toJson(manageDeliveryOptions.getDeliveryOption(Integer.parseInt(deliveryId)));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateDeliveryOption(String deliveryOptionAsJson){
        try{
            DeliveryOption deliveryOption = gson.fromJson(deliveryOptionAsJson, DeliveryOption.class);
            manageDeliveryOptions.updateDeliveryOption(deliveryOption);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
    }

    public void deleteDeliveryOption(String deliveryId){
        try{
            manageDeliveryOptions.deleteDeliveryOption(Integer.parseInt(deliveryId));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
