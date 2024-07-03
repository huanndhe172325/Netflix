/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dal.DAO;

/**
 *
 * @author FPT
 */
public class User {

    private int idUser;
    private String Email;
    private boolean Gender;
    private String DateOfBirth;
    private String PassWord;
    private String Name;
    private int role;
    private boolean status;

    public User() {
    }

    public User(int idUser, String Email, boolean Gender, String DateOfBirth, String PassWord, String Name, int role, boolean status) {
        this.idUser = idUser;
        this.Email = Email;
        this.Gender = Gender;
        this.DateOfBirth = DateOfBirth;
        this.PassWord = PassWord;
        this.Name = Name;
        this.role = role;
        this.status = status;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public boolean isGender() {
        return Gender;
    }

    public void setGender(boolean Gender) {
        this.Gender = Gender;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String PassWord) {
        this.PassWord = PassWord;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getPricing() {
        DAO dao = new DAO();
        return dao.getPricingIdByIdUser(idUser);
    }
}
