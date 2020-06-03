package main.PresentationLayerClasses;

import main.DataLayerClasses.ChefModel;

import java.awt.*;
import javax.swing.*;

public class ChefView extends JFrame
{
    private JTable orderList = new JTable();

    public ChefView(ChefModel model)
    {
        JPanel content = new JPanel();
        content.setLayout(new GridLayout(1,1));
        content.add(orderList);

        this.setContentPane(content);
        this.pack();

        this.setTitle("Chef GUI");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
