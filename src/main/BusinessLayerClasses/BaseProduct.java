package main.BusinessLayerClasses;

import java.util.ArrayList;
import java.util.Vector;

public class BaseProduct extends MenuItem
{
    String itemName;
    float itemPrice;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public float getItemPrice()
    {
        return itemPrice;
    }
    public void setItemPrice(float price)
    {
        this.itemPrice = price;
    }
    @Override
    public float computePrice()
    {
        return itemPrice;
    }

    @Override
    public Vector<String> tableFormat()
    {
        Vector<String> result = new Vector<>();
        result.add(0,this.itemName);
        result.add(1,String.valueOf(this.computePrice()));
        return result;
    }

    @Override
    public String toString()
    {
        return this.getItemName();
    }
}
