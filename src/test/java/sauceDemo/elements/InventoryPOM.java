package sauceDemo.elements;

import org.openqa.selenium.By;

public class InventoryPOM {
    public static final By filterDropdown = By.cssSelector(".product_sort_container");
    public static final By inventoryElementsName = By.cssSelector(".inventory_item_name");
    public static final By inventoryElementsPrices = By.cssSelector(".inventory_item_price");
    public static final By inventoryElementsAddBtn = By.cssSelector(".btn_inventory");
    public static final By basketBtn = By.cssSelector(".shopping_cart_link");
    public static final By basketNumberIcon = By.cssSelector(".shopping_cart_badge");
    public static final By basketRemoveBtn = By.cssSelector(".btn.btn_secondary.btn_small.cart_button");


}
