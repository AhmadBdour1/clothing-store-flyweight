package com.clothingstore.patterns.flyweight;

import java.util.Objects;

public class ClothingModel {
    private final String type;
    private final String brand;
    private final String design;
    private final String color;
    private final String material;
    private final double basePrice;
    private final String imageURL;

    public ClothingModel(String type, String brand, String design, String color, String material, double basePrice, String imageURL) {
        this.type = type;
        this.brand = brand;
        this.design = design;
        this.color = color;
        this.material = material;
        this.basePrice = basePrice;
        this.imageURL = imageURL;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public String getDesign() {
        return design;
    }

    public String getColor() {
        return color;
    }

    public String getMaterial() {
        return material;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public String getImageURL() {
        return imageURL;
    }

    @Override
    public String toString() {
        return "ClothingModel{" +
               "type='" + type + '\'' +
               ", brand='" + brand + '\'' +
               ", design='" + design + '\'' +
               ", color='" + color + '\'' +
               ", material='" + material + '\'' +
               ", basePrice=" + basePrice +
               ", imageURL='" + imageURL + '\'' +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClothingModel that = (ClothingModel) o;
        return Double.compare(that.basePrice, basePrice) == 0 &&
               Objects.equals(type, that.type) &&
               Objects.equals(brand, that.brand) &&
               Objects.equals(design, that.design) &&
               Objects.equals(color, that.color) &&
               Objects.equals(material, that.material) &&
               Objects.equals(imageURL, that.imageURL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, brand, design, color, material, basePrice, imageURL);
    }
}
