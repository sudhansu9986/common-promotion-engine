package org.common.sudhansu.business;

import org.common.sudhansu.model.*;
import org.common.sudhansu.staticdb.StaticDatabase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Test class to test three scenarios
 */
public class PaymentProcessingTest {
    SKU skuA;
    SKU skuB;
    SKU skuC;
    SKU skuD;
    PaymentProcessing paymentProcessing;
    @Before
    public void initStaticDatabase(){
        //Add Promotion to staticDB
        PromotionEngine promotionEngineA = new PromotionEngine("ENG1234",'A',true,false,3,20,0);
        StaticDatabase.addPromotion(promotionEngineA);
        PromotionEngine promotionEngineB = new PromotionEngine("ENG5678",'B',true,false,2,15,0);
        StaticDatabase.addPromotion(promotionEngineB);

        Map<Character, Character> hMap = new HashMap<>();
        hMap.put('C','D');
        MultiPromotionEngine multiPromotionEngineCD = new MultiPromotionEngine("MULTI123",hMap,30);
        StaticDatabase.addMultiItemPromotion(multiPromotionEngineCD);

        //Product and there prices
        skuA = new SKU('A',50);
        skuB = new SKU('B',30);
        skuC = new SKU('C',20);
        skuD = new SKU('D',15);
        paymentProcessing = new PaymentProcessing();
    }

    //test Scenario A
    //1 * A 50
    //1 * B 30
    //1 * C 20
    //======
    //Total 100
    @Test
    public void testShoppingCartScenarioA(){
        CartItem cartItemOne = new CartItem("CartId1",skuA,1);
        CartItem cartItemTwo = new CartItem("CartId2",skuB,1);
        CartItem cartItemThree = new CartItem("CartId3",skuC,1);

        List<CartItem> cartItemList = new ArrayList<>();
        cartItemList.add(cartItemOne);
        cartItemList.add(cartItemTwo);
        cartItemList.add(cartItemThree);
        ShoppingCart shoppingCart = paymentProcessing.getShoppingKart(cartItemList);
        Assert.assertEquals("Total Price of all the items should be equal on expected and actual ",100,shoppingCart.getTotalPrice(),0);
    }

    //test Scenario B
    //5 * A 130 + 2*50
    //5 * B 45 + 45 + 30
    //1 * C 20
    //======
    //Total 370
    @Test
    public void testShoppingCartScenarioB(){
        CartItem cartItemOne = new CartItem("CartId1",skuA,5);
        CartItem cartItemTwo = new CartItem("CartId2",skuB,5);
        CartItem cartItemThree = new CartItem("CartId3",skuC,1);

        List<CartItem> cartItemList = new ArrayList<>();
        cartItemList.add(cartItemOne);
        cartItemList.add(cartItemTwo);
        cartItemList.add(cartItemThree);
        ShoppingCart shoppingCart = paymentProcessing.getShoppingKart(cartItemList);
        Assert.assertEquals("Total Price of all the items should be equal on expected and actual ",370,shoppingCart.getTotalPrice(),0);
    }

    //test Scenario C
    //3 * A 130
    //5 * B 45 + 45 + 1 * 30
    //1 * C -
    //1 * D 30
    //======
    //Total 280
    @Test
    public void testShoppingCartScenarioC(){
        CartItem cartItemOne = new CartItem("CartId1",skuA,3);
        CartItem cartItemTwo = new CartItem("CartId2",skuB,5);
        CartItem cartItemThree = new CartItem("CartId3",skuC,1);
        CartItem cartItemFour = new CartItem("CartId4",skuD,1);

        List<CartItem> cartItemList = new ArrayList<>();
        cartItemList.add(cartItemOne);
        cartItemList.add(cartItemTwo);
        cartItemList.add(cartItemThree);
        cartItemList.add(cartItemFour);
        ShoppingCart shoppingCart = paymentProcessing.getShoppingKart(cartItemList);
        Assert.assertEquals("Total Price of all the items should be equal on expected and actual ",280,shoppingCart.getTotalPrice(),0);
    }
}
