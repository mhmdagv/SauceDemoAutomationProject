package elements;

import lombok.Data;
import org.openqa.selenium.By;

@Data
public final class InventoryPom {

   private final By inventoryItemNames = By.className("inventory_item_name");

    private InventoryPom(){

    }

    private static InventoryPom INSTANCE; // 1

    public static InventoryPom getInstance(){
        if(INSTANCE == null) {
            INSTANCE = new InventoryPom();
        }
        return INSTANCE;
    }
}
