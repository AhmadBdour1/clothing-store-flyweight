package com.clothingstore;

import com.clothingstore.domain.ClothingItem;
import com.clothingstore.patterns.flyweight.ClothingModel;
import com.clothingstore.patterns.flyweight.ClothingModelFactory;

import java.util.ArrayList;
import java.util.List;

public class ClothingStore {
    private final List<ClothingItem> inventory = new ArrayList<>();

    public void addClothingItem(
            String type, String brand, String design, String color, String material, double basePrice, String imageURL,
            String size, String sku, String stockLocation, int quantity) {

        ClothingModel model = ClothingModelFactory.getClothingModel(
                type, brand, design, color, material, basePrice, imageURL);

        ClothingItem item = new ClothingItem(model, size, sku, stockLocation, quantity);
        inventory.add(item);
    }

    public List<ClothingItem> getInventory() {
        return inventory;
    }

    public String getInventoryJson() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < inventory.size(); i++) {
            sb.append(inventory.get(i).toJson());
            if (i < inventory.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public String getFlyweightStatsJson() {
        return String.format(
            "{\"uniqueModels\": %d, \"estimatedMemory\": %d}",
            ClothingModelFactory.getNumberOfModels(),
            ClothingModelFactory.getMemoryFootprint()
        );
    }
}
