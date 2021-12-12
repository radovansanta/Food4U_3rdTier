package DatabaseAccess;

import Models.DeliveryOption;

import java.util.ArrayList;

public interface ManageDeliveryOptions
{
    void addDeliveryOption(DeliveryOption deliveryOption);
    ArrayList<DeliveryOption> getDeliveryOptionsByUsername(String username);
    DeliveryOption getDeliveryOption(int deliveryId);
    void updateDeliveryOption(DeliveryOption deliveryOption);
    void deleteDeliveryOption(int deliveryId);
}
