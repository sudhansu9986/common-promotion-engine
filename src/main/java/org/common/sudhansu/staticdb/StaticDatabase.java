package org.common.sudhansu.staticdb;

import org.common.sudhansu.model.CartItem;
import org.common.sudhansu.model.MultiPromotionEngine;
import org.common.sudhansu.model.PromotionEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * It is static database which holds promotion details and act as a database
 */
public class StaticDatabase {
    public static List<PromotionEngine> promotionEngineList = new ArrayList<>();
    public static List<MultiPromotionEngine> multiPromotionEngineList = new ArrayList<>();

    public static void addPromotion(PromotionEngine promotionEngine){
        if(promotionEngine != null)
            promotionEngineList.add(promotionEngine);
    }

    public static List<PromotionEngine> getAllPromotion(){
        return promotionEngineList;
    }

    public static void addMultiItemPromotion(MultiPromotionEngine multiPromotionEngine){
        if(multiPromotionEngine != null)
            multiPromotionEngineList.add(multiPromotionEngine);
    }

    public static List<MultiPromotionEngine> getMultiItemPromotion(){
        return multiPromotionEngineList;
    }
}
