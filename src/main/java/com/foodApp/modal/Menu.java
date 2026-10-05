package com.foodApp.modal;


public class Menu {

    private int menuId;
    private int restaurantId;
    private String itemName;
    private String description;
    private String price;
    private String isAvailable;
    private String imgPath;

    public Menu(int menuId, int restaurantId, String itemName, String description,
            String price, String isAvailable, String imgParh) {
        super();
        this.menuId = menuId;
        this.restaurantId = restaurantId;
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.isAvailable = isAvailable;
        this.imgPath = imgParh;
    }

    public Menu() {
        super();
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgParh) {
        this.imgPath = imgParh;
    }

    @Override
    public String toString() {
        return "Menu [menuId=" + menuId
                + ", restaurantId=" + restaurantId
                + ", itemName=" + itemName
                + ", description=" + description
                + ", price=" + price
                + ", isAvailable=" + isAvailable
                +  "]";
    }
}