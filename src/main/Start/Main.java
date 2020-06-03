package main.Start;

import main.BusinessLayerClasses.AdministratorController;
import main.BusinessLayerClasses.Restaurant;
import main.BusinessLayerClasses.WaiterController;
import main.DataLayerClasses.AdministratorModel;
import main.DataLayerClasses.ChefModel;
import main.DataLayerClasses.WaiterModel;
import main.PresentationLayerClasses.AdministratorView;
import main.PresentationLayerClasses.ChefView;
import main.PresentationLayerClasses.Serialization;
import main.PresentationLayerClasses.WaiterView;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Main
{
    public static void main(String[] args)
    {
//        try {
//            ObjectInputStream in = new ObjectInputStream(new FileInputStream(args[0]));
//            Restaurant restaurant = (Restaurant) in.readObject();
//
//            WaiterView waiterView = new WaiterView(restaurant);
//            WaiterController waiterController = new WaiterController(restaurant,waiterView);
//
//            AdministratorView administratorView = new AdministratorView(restaurant);
//            AdministratorController administratorController = new AdministratorController(restaurant,administratorView);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        Restaurant restaurant = new Restaurant();
        Serialization serialization = new Serialization();

        WaiterView waiterView = new WaiterView(restaurant);
        WaiterController waiterController = new WaiterController(restaurant,waiterView);

        AdministratorView administratorView = new AdministratorView(restaurant);
        AdministratorController administratorController = new AdministratorController(restaurant,administratorView);


    }
}
