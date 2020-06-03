package main.BusinessLayerClasses;

import main.DataLayerClasses.AdministratorModel;
import main.PresentationLayerClasses.AdministratorView;
import main.BusinessLayerClasses.MenuItem;
import main.PresentationLayerClasses.Serialization;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.lang.Float.valueOf;

public class AdministratorController
{
    public Restaurant restaurant;
    public Serialization serialization;
    public AdministratorView m_view;

    public AdministratorController(Restaurant model, AdministratorView view)
    {
        restaurant = model;
        m_view = view;
        view.createBaseItemListener(new createBaseItemListener());
        view.createCompositeItemListener(new createCompositeItemListener());
        view.editBaseItemListener(new editBaseItemListener());
        view.editCompositeItemListener(new editCompositeItemListener());
        view.deleteMenuItemListener(new deleteMenuItemListener());
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

    public void addBaseItems()
    {
        DefaultListModel<MenuItem> baseItemListModel = new DefaultListModel<>();
        for(int i = 0;i < restaurant.getItemMenuList().getSize();i++)
        {
            if(restaurant.getItemMenuList().get(i) instanceof BaseProduct)
            {
                baseItemListModel.addElement(restaurant.getItemMenuList().get(i));
            }
        }

        m_view.baseItemListForCreateBase.setModel(baseItemListModel);
        m_view.baseItemListForCreateComposite.setModel(baseItemListModel);
        m_view.baseItemListForEditBase.setModel(baseItemListModel);
        m_view.baseItemListForEditComposite.setModel(baseItemListModel);
        serialization.setRestaurant(restaurant);
        serialization.serializedOutputFile();
    }

    public void addCompositeItems()
    {
        DefaultListModel<MenuItem> compositeItemListModel = new DefaultListModel<>();
        for(int i = 0;i < restaurant.getItemMenuList().getSize();i++)
        {
            if(restaurant.getItemMenuList().get(i) instanceof CompositeProduct)
            {
                compositeItemListModel.addElement(restaurant.getItemMenuList().get(i));
            }
        }
        m_view.compositeItemList.setModel(compositeItemListModel);
        serialization.setRestaurant(restaurant);
        serialization.serializedOutputFile();
    }

    public void addMenuItems()
    {
        DefaultListModel<MenuItem> menuItemListModel = new DefaultListModel<>();
        for(int i = 0;i < restaurant.getItemMenuList().getSize();i++)
        {
            menuItemListModel.addElement(restaurant.getItemMenuList().get(i));
        }
        m_view.menuItemList.setModel(menuItemListModel);
        setMenuItemsTable();
        serialization.setRestaurant(restaurant);
        serialization.serializedOutputFile();
    }

    public void setMenuItemsTable()
    {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnCount(7);
        for(int i = 0;i < restaurant.getItemMenuList().getSize();i++)
        {
            model.addRow(restaurant.getItemMenuList().get(i).tableFormat());
        }
        m_view.menuItemsTable.setModel(model);
    }

    class createBaseItemListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            restaurant.createMenuItem(m_view.baseNameCreate.getText(),
                    Float.parseFloat(m_view.basePriceCreate.getText()));
            addBaseItems();
            addMenuItems();
        }
    }
    class createCompositeItemListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            restaurant.createMenuItem(m_view.compositeNameCreate.getText(), (ArrayList<MenuItem>) m_view.baseItemListForCreateComposite.getSelectedValuesList());
            addCompositeItems();
            addMenuItems();
        }
    }
    class editBaseItemListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            BaseProduct newItem = new BaseProduct();
            newItem.setItemName(m_view.baseNameEdit.getText());
            newItem.setItemPrice(Float.parseFloat(m_view.basePriceEdit.getText()));

            restaurant.editMenuItem(m_view.baseItemListForEditBase.getSelectedValue(),newItem);
            addBaseItems();
            addMenuItems();
        }
    }
    class editCompositeItemListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            CompositeProduct newItem = new CompositeProduct();
            newItem.setItemName(m_view.compositeNameEdit.getText());
            newItem.setComposition((ArrayList<MenuItem>) m_view.baseItemListForCreateComposite.getSelectedValuesList());
            newItem.setItemPrice(newItem.computePrice());

            restaurant.editMenuItem(m_view.compositeItemList.getSelectedValue(),newItem);
            addCompositeItems();
            addMenuItems();
        }
    }
    class deleteMenuItemListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            restaurant.deleteMenuItem(m_view.menuItemList.getSelectedValue());
            addBaseItems();
            addCompositeItems();
            addMenuItems();
        }
    }
}
