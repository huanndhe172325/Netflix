/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author FPT
 */
public class Country {
    private int CountryID;
    private String name;

    public Country() {
    }

    public Country(int CountryID, String name) {
        this.CountryID = CountryID;
        this.name = name;
    }

    public int getCountryID() {
        return CountryID;
    }

    public void setCountryID(int CountryID) {
        this.CountryID = CountryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
