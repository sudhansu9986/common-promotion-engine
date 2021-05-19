package org.common.sudhansu.model;

/**
 * Model object to store promotion for the same SKU
 */
public class PromotionEngine {
    private String promotionId;
    private Character skuId;
    private boolean promoOnQuantity;
    private boolean promoOnItemPercentage;
    private int quantityPromo;
    private int discountOnQuantity;
    private int itemPercentage;

    public PromotionEngine() {
    }

    public PromotionEngine(String promotionId, Character skuId, boolean promoOnQuantity, boolean promoOnItemPercentage, int quantityPromo, int discountOnQuantity, int itemPercentage) {
        this.promotionId = promotionId;
        this.skuId = skuId;
        this.promoOnQuantity = promoOnQuantity;
        this.promoOnItemPercentage = promoOnItemPercentage;
        this.quantityPromo = quantityPromo;
        this.discountOnQuantity = discountOnQuantity;
        this.itemPercentage = itemPercentage;
    }

    public String getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(String promotionId) {
        this.promotionId = promotionId;
    }

    public Character getSkuId() {
        return skuId;
    }

    public void setSkuId(Character skuId) {
        this.skuId = skuId;
    }

    public boolean isPromoOnQuantity() {
        return promoOnQuantity;
    }

    public void setPromoOnQuantity(boolean promoOnQuantity) {
        this.promoOnQuantity = promoOnQuantity;
    }

    public boolean isPromoOnItemPercentage() {
        return promoOnItemPercentage;
    }

    public void setPromoOnItemPercentage(boolean promoOnItemPercentage) {
        this.promoOnItemPercentage = promoOnItemPercentage;
    }

    public int getQuantityPromo() {
        return quantityPromo;
    }

    public void setQuantityPromo(int quantityPromo) {
        this.quantityPromo = quantityPromo;
    }

    public int getDiscountOnQuantity() {
        return discountOnQuantity;
    }

    public void setDiscountOnQuantity(int discountOnQuantity) {
        this.discountOnQuantity = discountOnQuantity;
    }

    public int getItemPercentage() {
        return itemPercentage;
    }

    public void setItemPercentage(int itemPercentage) {
        this.itemPercentage = itemPercentage;
    }
}
