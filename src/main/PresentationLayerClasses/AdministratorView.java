package main.PresentationLayerClasses;

import main.BusinessLayerClasses.BaseProduct;
import main.BusinessLayerClasses.CompositeProduct;
import main.BusinessLayerClasses.Restaurant;
import main.DataLayerClasses.AdministratorModel;
import main.BusinessLayerClasses.MenuItem;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class AdministratorView extends JFrame
{
    public Restaurant restaurant;
    public Serialization serialization;

    //Create base item block
    public JLabel nameCreate = new JLabel("name");
    public JLabel priceCreate = new JLabel("price");

    public JTextField baseNameCreate = new JTextField();
    public JTextField basePriceCreate = new JTextField();

    public JList<MenuItem> baseItemListForCreateBase = new JList<>();
    public JButton createBaseItem = new JButton("Create item");

    //Create composite item block
    public JTextField compositeNameCreate = new JTextField();
    public JButton createCompositeItem = new JButton("Create item");

    public JList<MenuItem> baseItemListForCreateComposite = new JList<>();

    //Edit base item block
    public JLabel nameEdit = new JLabel("name");
    public JLabel priceEdit = new JLabel("price");

    public JList<MenuItem> baseItemListForEditBase = new JList<>();

    public JTextField baseNameEdit = new JTextField();
    public JTextField basePriceEdit = new JTextField();

    public JButton editBaseItem = new JButton("Edit item");

    //Edit composite item block
    public JButton editCompositeItem = new JButton("Edit item");
    public JTextField compositeNameEdit = new JTextField();

    public JList<MenuItem> baseItemListForEditComposite = new JList<>();

    //Delete item
    public JButton deleteItem = new JButton("Delete item");
    public JList<MenuItem> menuItemList = new JList<MenuItem>();

    public JTable menuItemsTable = new JTable();
    public JList<MenuItem> compositeItemList = new JList<MenuItem>();


    public AdministratorView(Restaurant r)
    {
        JPanel content = new JPanel();
        content.setLayout(new GridLayout(1,2));

        content.add(menuItemsTable);

        JPanel input = new JPanel();
        input.setLayout(new GridLayout(5,1));

        JPanel createBase = new JPanel();
        createBase.setLayout(new GridLayout(3,2));

        createBase.add(nameCreate); createBase.add(baseNameCreate);
        createBase.add(priceCreate);createBase.add(basePriceCreate);
        createBase.add(baseItemListForCreateBase);createBase.add(createBaseItem);

        input.add(createBase);

        JPanel createComposite = new JPanel();
        createComposite.setLayout(new GridLayout(2,2));

        createComposite.add(baseItemListForCreateComposite);createComposite.add(compositeNameCreate);
        createComposite.add(new JLabel(" "));createComposite.add(createCompositeItem);

        input.add(createComposite);

        JPanel editBase = new JPanel();
        editBase.setLayout(new GridLayout(3,2));

        editBase.add(nameEdit); editBase.add(baseNameEdit);
        editBase.add(priceEdit); editBase.add(basePriceEdit);
        editBase.add(baseItemListForEditBase); editBase.add(editBaseItem);

        input.add(editBase);

        JPanel editComposite = new JPanel();
        editComposite.setLayout(new GridLayout(2,2));

        JPanel lists = new JPanel();
        lists.setLayout(new GridLayout(1,2));
        lists.add(compositeItemList);
        lists.add(baseItemListForEditComposite);

        editComposite.add(lists);editComposite.add(compositeNameEdit);
        editComposite.add(new JLabel(" "));editComposite.add(editCompositeItem);

        input.add(editComposite);

        JPanel deleteBlock = new JPanel();
        deleteBlock.setLayout(new GridLayout(1,2));

        deleteBlock.add(menuItemList);
        deleteBlock.add(deleteItem);

        input.add(deleteBlock);
        content.add(input);
        this.setContentPane(content);
        this.pack();

        this.setTitle("Administrator GUI");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    // Button listeners
    public void createBaseItemListener(ActionListener mal)
    {
        createBaseItem.addActionListener(mal);
    }
    public void createCompositeItemListener(ActionListener mal)
    {
        createCompositeItem.addActionListener(mal);
    }
    public void editBaseItemListener(ActionListener mal)
    {
        editBaseItem.addActionListener(mal);
    }
    public void editCompositeItemListener(ActionListener mal)
    {
        editCompositeItem.addActionListener(mal);
    }
    public void deleteMenuItemListener(ActionListener mal)
    {
        deleteItem.addActionListener(mal);
    }


}
