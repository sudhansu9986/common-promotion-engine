package org.common.sudhansu.model;

import java.util.Map;

/**
 * Model class to store Multiple SKU in a same promotion
 */
public class MultiPromotionEngine {
    private String multiPromotionId;
    private Map<Character, Character> multiItem;
    private double priceOfBothItem;

    public MultiPromotionEngine() {
    }

    public MultiPromotionEngine(String multiPromotionId, Map<Character, Character> multiItem, double priceOfBothItem) {
        this.multiPromotionId = multiPromotionId;
        this.multiItem = multiItem;
        this.priceOfBothItem = priceOfBothItem;
    }

    public String getMultiPromotionId() {
        return multiPromotionId;
    }

    public void setMultiPromotionId(String multiPromotionId) {
        this.multiPromotionId = multiPromotionId;
    }

    public Map<Character, Character> getMultiItem() {
        return multiItem;
    }

    public void setMultiItem(Map<Character, Character> multiItem) {
        this.multiItem = multiItem;
    }

    public double getPriceOfBothItem() {
        return priceOfBothItem;
    }

    public void setPriceOfBothItem(double priceOfBothItem) {
        this.priceOfBothItem = priceOfBothItem;
    }
}
