# common-promotion-engine
This works as a user guide for the repository. This Project uses OOPS concepts, JUNIT for unit testing and maven based
project using Java.

#Steps to user
1. For clonning the repository use -> git clone https://github.com/sudhansu9986/common-promotion-engine.git
2. Once clonning is done go inside the common-promotion-engine path and execute command -> mvn clean install
3. It will automatically download all the jars defined in POM.xml file, build the project, run the test cases


# About the Project model
1. StaticDatabase class is being used to store the data of Promotion details
2. Business Logic is written inside PaymentProcessing class 
3. SKU class is to store the item and it's price
4. CartItem class contains SKU and it's quantity
5. ShoppingCart class contains list of CartItem and total price of the several CartItem
6. PromotionEngine contains SKUId, quantityPromo-> promotion is applicable for how many quantity,
   itemPercentage -> If some certain percentage discount applicable for a CartItem,
   discountOnQuantity -> how much discount for certain quantity,
   promoOnQuantity -> promotion on quantity or promoOnItemPercentage on percentage NOTE: either one should enabled.
7. MultiPromotionEngine contains multiItem -> which holds multi item for example C and D in this Project and 
   priceOfBothItem -> price of both item included
8. PaymentProcessingTest test class which includes all three scenarios 
   
NOTE: 
1. Model class Ids are hardcoded here, Autogenerated Logic is not being implemented
2. Logger Framework is not being implemented

For any clarity please contact me on : sudhansu.miet@gmail.com 
   
