package main.PresentationLayerClasses;

import main.BusinessLayerClasses.Restaurant;

import java.io.*;

public class Serialization implements Serializable
{
    Restaurant restaurant;

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void serializedOutputFile()
    {
        try {
            FileOutputStream fout = new FileOutputStream("restaurant.ser");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
