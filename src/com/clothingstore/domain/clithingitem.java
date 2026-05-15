package com.clothingstore.domain;

import com.clothingstore.patterns.flyweight.ClothingModel;

public class ClothingItem {
    private final ClothingModel model; // Reference to the Flyweight
    private final String size;
    private final String sku;
    private final String stockLocation;
    private int quantity;

    public ClothingItem(ClothingModel model, String size, String sku, String stockLocation, int quantity) {
        this.model = model;
        this.size = size;
        this.sku = sku;
        this.stockLocation = stockLocation;
        this.quantity = quantity;
    }

    public ClothingModel getModel() {
        return model;
    }

    public String getSize() {
        return size;
    }

    public String getSku() {
        return sku;
    }

    public String getStockLocation() {
        return stockLocation;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Method to display item details, combining intrinsic and extrinsic states
    public String displayItem() {
        return "SKU: " + sku + ", Type: " + model.getType() + ", Brand: " + model.getBrand() +
               ", Design: " + model.getDesign() + ", Color: " + model.getColor() +
               ", Size: " + size + ", Price: " + model.getBasePrice() +
               ", Quantity: " + quantity + ", Location: " + stockLocation;
    }

    public String toJson() {
        return String.format(
            "{\"sku\": \"%s\", \"type\": \"%s\", \"brand\": \"%s\", \"design\": \"%s\", \"color\": \"%s\", \"size\": \"%s\", \"price\": %.2f, \"quantity\": %d, \"location\": \"%s\", \"imageURL\": \"%s\"}",
            sku, model.getType(), model.getBrand(), model.getDesign(), model.getColor(), size, model.getBasePrice(), quantity, stockLocation, model.getImageURL()
        );
    }
}
