/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author FPT
 */
public class Pricing {
    private int PricingID;
    private String PricingName;
    private int price;
    private String Resolution;
    private String Describe;

    public Pricing() {
    }

    public Pricing(int PricingID, String PricingName, int price, String Resolution, String Describe) {
        this.PricingID = PricingID;
        this.PricingName = PricingName;
        this.price = price;
        this.Resolution = Resolution;
        this.Describe = Describe;
    }

    public int getPricingID() {
        return PricingID;
    }

    public void setPricingID(int PricingID) {
        this.PricingID = PricingID;
    }

    public String getPricingName() {
        return PricingName;
    }

    public void setPricingName(String PricingName) {
        this.PricingName = PricingName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getResolution() {
        return Resolution;
    }

    public void setResolution(String Resolution) {
        this.Resolution = Resolution;
    }

    public String getDescribe() {
        return Describe;
    }

    public void setDescribe(String Describe) {
        this.Describe = Describe;
    }
    
}
