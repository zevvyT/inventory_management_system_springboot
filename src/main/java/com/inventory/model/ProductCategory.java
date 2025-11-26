package com.inventory.model;

public enum ProductCategory {
    FOOD("Food"),
    HEALTH_CARE("Health Care"),
    OUTDOORS("Outdoors"),
    GENERAL_DRY_GOODS("General Dry Goods");

    private final String displayName;

    ProductCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
