package main.BusinessLayerClasses;

import java.util.ArrayList;

public interface IRestaurantProcessing
{
    //Waiter
    public void createNewOrder(Order newOrder, ArrayList<MenuItem> orderedItems);
    public float computeOrderPrice(Order order);
    public void generateBill(Order order);

    //Admin
    public void createMenuItem(String name, ArrayList<MenuItem> productComposition);
    public void createMenuItem(String name, float price);
    public void editMenuItem(MenuItem item, MenuItem editedItem);
    public void deleteMenuItem(MenuItem item);

}
