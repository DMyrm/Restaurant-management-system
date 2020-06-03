package main.BusinessLayerClasses;

import main.PresentationLayerClasses.Serialization;

import java.util.ArrayList;
import java.util.Vector;

public abstract class MenuItem extends Serialization
{
    public abstract float computePrice();
    public abstract Vector<String> tableFormat();
}
