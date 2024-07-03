/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author FPT
 */
public class Order {
    private int orderID;
    private String emailCustomer;
    private String date;
    private String namePricing;
    private int totalOrder;

    public Order() {
    }

    public Order(int orderID, String emailCustomer, String date, String namePricing, int totalOrder) {
        this.orderID = orderID;
        this.emailCustomer = emailCustomer;
        this.date = date;
        this.namePricing = namePricing;
        this.totalOrder = totalOrder;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getEmailCustomer() {
        return emailCustomer;
    }

    public void setEmailCustomer(String emailCustomer) {
        this.emailCustomer = emailCustomer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNamePricing() {
        return namePricing;
    }

    public void setNamePricing(String namePricing) {
        this.namePricing = namePricing;
    }

    public int getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(int totalOrder) {
        this.totalOrder = totalOrder;
    }





    
}
