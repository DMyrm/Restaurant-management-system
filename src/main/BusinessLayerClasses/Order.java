package main.BusinessLayerClasses;

import main.PresentationLayerClasses.Serialization;

import java.util.ArrayList;

public class Order extends Serialization
{
        private int orderID;
        private String date;
        private int table;
        private ArrayList<Integer> tableStatus;
        private float price;
        private int billID;

        public Order()
        {
            this.setPrice(0.0f);
            tableStatus = new ArrayList<>();
            orderID = 1;
            billID = 1;
        }

        public Order(int orderID, String date, int table)
        {
            super();
            this.tableStatus = new ArrayList<>();
            this.orderID = orderID;
            this.date = date;
            this.table = table;
            this.setPrice(0.0f);
        }

        public int getBillID() {
        return billID;
    }
        public void setBillID(int billID) {
        this.billID = billID;
    }
        public int getOrderID() {
            return orderID;
        }
        public void setOrderID(int orderId) {
            this.orderID = orderId;
        }
        public String getDate() {
            return date;
        }
        public void setDate(String date) {
            this.date = date;
        }
        public int getTable() {
            return table;
        }
        public void setTable(int table) {
            tableStatus.set(table,1);
            this.table = table;
        }
        public int getTableStatus()
        {
            return tableStatus.get(this.table);
        }
        public float getPrice() {
            return price;
        }
        public void setPrice(float price) {
            this.price = price;
        }

        @Override
        public int hashCode() {
            return this.orderID;
        }

        @Override
        public boolean equals(Object o) {
            if( o == null) {
                return false;
            }
            if(!(o instanceof Order)) {
                return false;
            }

            if(o == this) {
                return true;
            }
            return this.getOrderID() == ((Order) o).getOrderID();
        }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                '}';
    }
}

