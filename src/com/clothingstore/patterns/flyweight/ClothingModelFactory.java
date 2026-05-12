package com.clothingstore.patterns.flyweight;

import java.util.HashMap;
import java.util.Map;

public class ClothingModelFactory {
    private static final Map<String, ClothingModel> models = new HashMap<>();

    public static ClothingModel getClothingModel(
            String type, String brand, String design, String color, String material, double basePrice, String imageURL) {

        String key = type + "_" + brand + "_" + design + "_" + color + "_" + material + "_" + basePrice + "_" + imageURL;

        if (!models.containsKey(key)) {
            models.put(key, new ClothingModel(type, brand, design, color, material, basePrice, imageURL));
        }
        return models.get(key);
    }

    public static int getNumberOfModels() {
        return models.size();
    }

    public static long getMemoryFootprint() {
        long size = 0;
        for (Map.Entry<String, ClothingModel> entry : models.entrySet()) {
            size += estimateObjectSize(entry.getKey()); // Key string size
            size += estimateObjectSize(entry.getValue()); // ClothingModel object size
        }
        return size;
    }

    // A very rough estimation of object size for demonstration purposes.
    // In a real application, memory profiling tools would be used.
    private static long estimateObjectSize(Object o) {
        if (o == null) return 0;
        if (o instanceof String) {
            return ((String) o).length() * 2 + 40; // Rough estimate: 2 bytes per char + object overhead
        }
        if (o instanceof ClothingModel) {
            // Estimate for ClothingModel fields (String, String, String, String, String, double, String)
            // Assuming average string length for estimation
            ClothingModel model = (ClothingModel) o;
            long stringSize = (model.getType().length() + model.getBrand().length() + model.getDesign().length() +
                               model.getColor().length() + model.getMaterial().length() + model.getImageURL().length()) * 2;
            return stringSize + 8 + 100; // Strings + double + object overhead
        }
        return 100; // Default for other objects
    }
}
