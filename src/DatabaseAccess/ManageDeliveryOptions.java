package DatabaseAccess;

import Models.DeliveryOption;

import java.util.ArrayList;

public interface ManageDeliveryOptions
{
    void addDeliveryOption(DeliveryOption deliveryOption, int restaurantID);
    ArrayList<DeliveryOption> getDeliveryOption(int restaurantID);
    void updateDeliveryOption(DeliveryOption deliveryOption);
}
