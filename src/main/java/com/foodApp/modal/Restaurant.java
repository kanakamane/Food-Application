package com.foodApp.modal;


public class Restaurant {

    private int restaurantId;
    private String name;
    private String cuisineType;
    private int deliveryTime;
    private String address;
    private int adminUserId;
    private int rating;
    private int isActive;
    private String imgPath;

    public Restaurant(int restaurantId, String name, String cuisineType, int deliveryTime, String address,
            int adminUserId, int rating, int isActive, String imgPath) {
        super();
        this.restaurantId = restaurantId;
        this.name = name;
        this.cuisineType = cuisineType;
        this.deliveryTime = deliveryTime;
        this.address = address;
        this.adminUserId = adminUserId;
        this.rating = rating;
        this.isActive = isActive;
        this.imgPath = imgPath;
    }

    public Restaurant() {
        super();
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAdminUserId() {
        return adminUserId;
    }

    public void setAdminUserId(int adminUserId) {
        this.adminUserId = adminUserId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "Restaurant [restaurantId=" + restaurantId
                + ", name=" + name
                + ", cuisineType=" + cuisineType
                + ", deliveryTime=" + deliveryTime
                + ", address=" + address
                + ", adminUserId=" + adminUserId
                + ", rating=" + rating
                + ", isActive=" + isActive
                + "]";
    }
}
