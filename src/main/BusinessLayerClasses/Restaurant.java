package main.BusinessLayerClasses;

import main.PresentationLayerClasses.Serialization;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

public class Restaurant extends Serialization implements IRestaurantProcessing
{
    public HashMap<Order, ArrayList<MenuItem>> orders = new HashMap<>();
    public int nextOrderID = 1;
    public DefaultListModel<MenuItem> itemMenu = new DefaultListModel<>();
    public ArrayList<Order> orderList = new ArrayList<>();


    public DefaultListModel<MenuItem> getItemMenuList()
    {
        return itemMenu;
    }

    @Override
    public void createNewOrder(Order newOrder, ArrayList<MenuItem> orderedItems)
    {
        LocalDate currentDate = LocalDate.now();
        newOrder.setDate(currentDate.toString());
        newOrder.setOrderID(nextOrderID);
        this.nextOrderID++;

        orders.put(newOrder,orderedItems);
        orderList.add(newOrder);
    }

    @Override
    public float computeOrderPrice(Order order)
    {
        float sum = 0.0f;
        for(MenuItem mi : orders.get(order))
        {
            sum = sum + mi.computePrice();
        }
        return sum;
    }

    @Override
    public void generateBill(Order order)
    {
        File file = new File("Bill for order" + order.getOrderID() +".txt");

        try {
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            writer.write("Bill No."+ order.getBillID() + " :\n");
            orders.get(order).forEach( (menuItem) ->
            {
                try
                {
                    writer.write(menuItem + "\n");
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            });
            writer.write("For the price of " + computeOrderPrice(order) +".");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createMenuItem(String name, ArrayList<MenuItem> productComposition)
    {
        CompositeProduct item = new CompositeProduct();
        item.setItemName(name);
        item.setComposition(productComposition);
        item.setItemPrice(item.computePrice());
        itemMenu.addElement(item);
    }

    @Override
    public void createMenuItem(String name, float price)
    {
        BaseProduct item = new BaseProduct();
        item.setItemName(name);
        item.setItemPrice(price);
        itemMenu.addElement(item);
    }

    @Override
    public void editMenuItem(MenuItem item, MenuItem editedItem)
    {
        itemMenu.set(itemMenu.indexOf(item),editedItem);
    }

    @Override
    public void deleteMenuItem(MenuItem item)
    {
        itemMenu.removeElement(item);
    }


}
