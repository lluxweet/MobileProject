package com.example.diplomproject.server.models;

import java.util.Date;

public class ProductEntity {
    private int idProduct;
    private int Partia;
    private String name;
    private int idCategory;
    private int idRazreshenie;
    private int Price;
    private Date Date_delete;

    public int getIdProduct(){ return idProduct; }
    public void setIdProduct(int value){ idProduct = value; }
    public int getPartia(){ return Partia; }
    public void setPartia(int value){ Partia = value; }
    public String getName(){ return name; }
    public void setName(String value){ name = value; }
    public int getIdCategory(){ return idCategory; }
    public void setIdCategory(int value){ idCategory = value; }
    public int getIdRazreshenie(){ return idRazreshenie; }
    public void setIdRazreshenie(int value){ idRazreshenie= value; }
    public int getPrice(){ return Price; }
    public void setPrice(int value){ Price= value; }
    public Date getDate_delete(){ return Date_delete; }
    public void setDate_delete(Date value){ Date_delete = value; }

}
