package main.BusinessLayerClasses;

import main.DataLayerClasses.WaiterModel;
import main.PresentationLayerClasses.Serialization;
import main.PresentationLayerClasses.WaiterView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class WaiterController
{
    public Restaurant restaurant;
    public Serialization serialization;
    public WaiterView m_view;

    public WaiterController(Restaurant model, WaiterView view)
    {
        restaurant = model;
        m_view = view;

        view.newOrderListener(new newOrderListener());
        view.computeBillListener(new computeBillListener());
        view.addItemListener(new addItemListener());

//        view.addWindowListener(new java.awt.event.WindowAdapter()
//        {
//            @Override
//            public void windowClosing(java.awt.event.WindowEvent windowEvent)
//            {
//                {
//                    serialization.setRestaurant(restaurant);
//                    serialization.serializedOutputFile();
//                    System.exit(0);
//                }
//            }
//        });
    }

    public void addMenuItems()
    {
        DefaultListModel<MenuItem> menuItemListModel = new DefaultListModel<>();
        for(int i = 0;i < restaurant.getItemMenuList().getSize();i++)
        {
            menuItemListModel.addElement(restaurant.getItemMenuList().get(i));
        }
        m_view.menuItemList.setModel(menuItemListModel);
        m_view.menuItemListP.setModel(menuItemListModel);
    }

    public void orders()
    {
        DefaultListModel<Order> orderModel = new DefaultListModel<>();
        for(Order o : restaurant.orderList)
        {
            orderModel.addElement(o);
        }
        m_view.orderList.setModel(orderModel);
    }

    class newOrderListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            addMenuItems();
            orders();
            m_view.newOrderPopup.setVisible(true);
        }
    }

    class addItemListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Order newOrder = new Order();
            restaurant.createNewOrder(newOrder,(ArrayList<MenuItem>)m_view.menuItemListP.getSelectedValuesList());
            orders();
        }
    }

    class computeBillListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            restaurant.generateBill(m_view.orderList.getSelectedValue());
        }
    }
}
