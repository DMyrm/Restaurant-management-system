package main.BusinessLayerClasses;

import java.util.ArrayList;
import java.util.Vector;

public class CompositeProduct extends MenuItem
{
    String itemName;
    float itemPrice;
    ArrayList<MenuItem> composition = new ArrayList<>();

    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public ArrayList<MenuItem> getComposition() {
        return composition;
    }
    public void setComposition(ArrayList<MenuItem> composition) {
        this.composition = composition;
    }
    float addItemToProduct()
    {
        return itemPrice;
    }
    void setItemPrice(float price)
    {
        this.itemPrice = price;
    }

    @Override
    public float computePrice()
    {
        float sum = 0.0f;
        for(MenuItem product : this.composition)
        {
            sum = sum + product.computePrice();
        }
        return sum;
    }

    @Override
    public Vector<String> tableFormat() {
        Vector<String> result = new Vector<>();
        int index = 2;
        result.add(0,this.itemName);
        result.add(1,String.valueOf(this.computePrice()));

        for(MenuItem b : this.composition)
        {
            result.add(index,b.toString());
        }
        return result;
    }

    @Override
    public String toString()
    {
        return this.getItemName();
    }
}
