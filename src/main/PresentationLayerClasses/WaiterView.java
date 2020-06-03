package main.PresentationLayerClasses;

import main.BusinessLayerClasses.MenuItem;
import main.BusinessLayerClasses.Order;
import main.BusinessLayerClasses.Restaurant;
import main.DataLayerClasses.WaiterModel;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.util.ArrayList;

public class WaiterView extends JFrame
{
    public Restaurant restaurant = new Restaurant();
    public Serialization serialization;

    public JList<Order> orderList = new JList<>();
    public JButton newOrder = new JButton("New Order");
    public JButton computeBill = new JButton("Compute Bill");

    public JTable itemList = new JTable();

    public final JFrame newOrderPopup = new JFrame();

    public JButton addItem = new JButton();
    public JList<MenuItem> menuItemList = new JList<>();
    public JList<MenuItem> menuItemListP = new JList<>();
    DefaultTableModel tm = new DefaultTableModel();
    public JTable newOrderFormation = new JTable(tm);

    public WaiterView(Restaurant r)
    {
        this.setTitle("Waiter GUI");

        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(3,1));
        buttons.add(newOrder);
        buttons.add(orderList);
        buttons.add(computeBill);

        JPanel content = new JPanel();
        content.setLayout(new GridLayout(1,2));

        content.add(menuItemList);
        content.add(buttons);

        this.setContentPane(content);

        addItem.setText("Add Item");

        newOrderPopup.setTitle("Create new order");
        JPanel orderPopup = new JPanel();
        orderPopup.setLayout(new GridLayout(1,2));
        orderPopup.add(menuItemListP);
        orderPopup.add(addItem);

        tm.addColumn("Item");
        tm.addColumn("Amount");
        tm.addColumn("Price");

        JPanel finalLayout = new JPanel();
        finalLayout.setLayout(new GridLayout(2,1));
        finalLayout.add(orderPopup);
        finalLayout.add(newOrderFormation);

        newOrderPopup.add(finalLayout);
        newOrderPopup.pack();

        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public void newOrderListener(ActionListener mal)
    {
        newOrder.addActionListener(mal);
    }
    public void computeBillListener(ActionListener mal)
    {
        computeBill.addActionListener(mal);
    }
    public void addItemListener(ActionListener mal)
    {
        addItem.addActionListener(mal);
    }

}
