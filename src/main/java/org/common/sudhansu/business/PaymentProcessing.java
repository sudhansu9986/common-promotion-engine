package org.common.sudhansu.business;

import org.common.sudhansu.model.*;
import org.common.sudhansu.staticdb.StaticDatabase;

import java.util.List;
import java.util.Optional;

/**
 * Class contains business logic which involves processing of the payment after the promotion discount applied
 */
public class PaymentProcessing {

    /**
     * method is used to get Shopping kart
     * @param cartItemList
     * @return ShoppingCart object
     */
    public ShoppingCart getShoppingKart(List<CartItem> cartItemList){
        ShoppingCart shoppingCart = new ShoppingCart();
        double totalPriceOfAllItems = 0;
        for (CartItem cartItem: cartItemList){
            int totalQuantity = cartItem.getQuantity();
            if(isPromotionOnItemAvailableAndSatisfies(cartItem)){
                PromotionEngine promotionEngine = getPromotionEngineOnItem(cartItem.getSKU());
                if(promotionEngine.isPromoOnQuantity()){
                    int promoQuantity = promotionEngine.getQuantityPromo();
                    int discountQuantity = totalQuantity / promoQuantity;
                    int withoutDiscQuantity = totalQuantity % promoQuantity;
                    int discountOnQuantity = promotionEngine.getDiscountOnQuantity();
                    //Logic for discount
                    totalPriceOfAllItems += ((cartItem.getSKU().getPrice()*promoQuantity*discountQuantity - discountOnQuantity*discountQuantity)+(cartItem.getSKU().getPrice()*withoutDiscQuantity));

                }else if(promotionEngine.isPromoOnItemPercentage()){
                    int discountPercentage = promotionEngine.getItemPercentage();
                    //bill - (bill * discount / 100)
                    totalPriceOfAllItems += ((cartItem.getSKU().getPrice() - (cartItem.getSKU().getPrice() * discountPercentage/100))*totalQuantity);
                }

            }else if(isMultiPromotionOnItemsAndCompanionAvailable(cartItem, cartItemList)){
                MultiPromotionEngine multiPromotionEngine = getMultiPromotionEngineOnItem(cartItem.getSKU());
                Character value = multiPromotionEngine.getMultiItem().get(cartItem.getSKU().getSkuId());
                int quantity = cartItem.getQuantity();
                int valueCount = cartItemList.stream().filter(x->x.getSKU().getSkuId().equals(value)).mapToInt(CartItem::getQuantity).sum();
                if(quantity == valueCount){
                    totalPriceOfAllItems += multiPromotionEngine.getPriceOfBothItem()*quantity;
                    cartItemList.removeIf(x->x.getSKU().getSkuId().equals(value));
                }else if(quantity > valueCount){
                    totalPriceOfAllItems += ((multiPromotionEngine.getPriceOfBothItem()*valueCount) + (cartItem.getSKU().getPrice()*(quantity-valueCount)));
                    cartItemList.removeIf(x->x.getSKU().getSkuId().equals(value));
                }else if(quantity < valueCount) {
                    Optional<CartItem> valuePriceSku = cartItemList.stream().filter(x -> x.getSKU().getSkuId().equals(value)).findAny();
                    if (valuePriceSku.isPresent()) {
                        totalPriceOfAllItems += ((multiPromotionEngine.getPriceOfBothItem() * quantity) + (valuePriceSku.get().getSKU().getPrice() * (valueCount - quantity)));
                        cartItemList.removeIf(x -> x.getSKU().getSkuId().equals(value));
                    }
                }

            }else{
                totalPriceOfAllItems += (cartItem.getSKU().getPrice()*totalQuantity);
            }
        }
        shoppingCart.setCartItemList(cartItemList);
        shoppingCart.setShoppingCartId("SCID123");
        shoppingCart.setTotalPrice(totalPriceOfAllItems);
        return shoppingCart;
    }

    /**
     * method to check promotion is applicable for the particular SKU in the cart item
     * @param cartItem
     * @return boolean true or false
     */
    public boolean isPromotionOnItemAvailableAndSatisfies(CartItem cartItem){
        boolean isPromotionCodeAvailable = false;
        Optional<PromotionEngine> optionalPromotionEngine = StaticDatabase.getAllPromotion()
                .stream()
                .filter(x->x.getSkuId().equals(cartItem.getSKU().getSkuId()))
                .findFirst();
        if(optionalPromotionEngine.isPresent()){
            PromotionEngine promotionEngine = optionalPromotionEngine.get();
            if(promotionEngine.isPromoOnQuantity()){
                if(cartItem.getQuantity() >= promotionEngine.getQuantityPromo())
                    isPromotionCodeAvailable = true;
            }else if(promotionEngine.isPromoOnItemPercentage()){
                isPromotionCodeAvailable = true;
            }
        }
        return  isPromotionCodeAvailable;
    }

    /**
     * method to check multi promotion is applicable for the particular SKU in the cart item
     * @param cartItem
     * @param cartItemList
     * @return boolean true or false
     */
    public boolean isMultiPromotionOnItemsAndCompanionAvailable(CartItem cartItem, List<CartItem> cartItemList){
        boolean isCompanionFound = false;
        MultiPromotionEngine multiPromotionEngine = getMultiPromotionEngineOnItem(cartItem.getSKU());
        if(multiPromotionEngine != null) {
            Character value = multiPromotionEngine.getMultiItem().get(cartItem.getSKU().getSkuId());
            Optional<CartItem> cartItemOptional = cartItemList.stream()
                    .filter(x -> x.getSKU().getSkuId().equals(value)).findFirst();
            if (cartItemOptional.isPresent()) {
                isCompanionFound = true;
            }
        }
        return isCompanionFound;
    }

    /**
     * method to get PromotionEngine object applicable for the particular SKU
     * @param sku
     * @return PromotionEngine object
     */
    public PromotionEngine getPromotionEngineOnItem(SKU sku){
        return StaticDatabase.getAllPromotion()
                .stream()
                .filter(x->x.getSkuId().equals(sku.getSkuId()))
                .findFirst().orElse(null);
    }

    /**
     * method to get MultiPromotionEngine object applicable for the particular SKU
     * @param sku
     * @return PromotionEngine object
     */
    public MultiPromotionEngine getMultiPromotionEngineOnItem(SKU sku){
        return StaticDatabase.getMultiItemPromotion()
                .stream().filter(m->m.getMultiItem().containsKey(sku.getSkuId()))
                .findFirst().orElse(null);
    }
}
