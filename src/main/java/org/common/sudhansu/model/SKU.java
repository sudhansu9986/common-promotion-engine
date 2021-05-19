package org.common.sudhansu.model;

import java.util.Objects;

/**
 * model class SKU is the specific item
 */
public class SKU {
    private Character skuId;
    private double price;

    public SKU(){}

    public SKU(Character skuId, double price) {
        this.skuId = skuId;
        this.price = price;
    }

    public Character getSkuId() {
        return skuId;
    }

    public void setSkuId(Character skuId) {
        this.skuId = skuId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SKU sku = (SKU) o;
        return Double.compare(sku.price, price) == 0 && skuId.equals(sku.skuId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(skuId, price);
    }
}
