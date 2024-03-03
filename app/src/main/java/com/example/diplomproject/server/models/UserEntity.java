package com.example.diplomproject.server.models;

public class UserEntity {
    private int idUser;
    private int idRole;
    private String Familia;
    private String Name;
    private String Otchestvo;
    private String Login;
    private String Password;

    public int getIdUser(){
        return idUser;
    }
    public void setIdUser(int value){
        idUser = value;
    }

    public  int getIdRole(){
        return idRole;
    }
    public  void setIdRole(int value){
        idRole = value;
    }

    public String getFamilia(){
        return Familia;
    }
    public void setFamilia(String value){
        Familia = value;
    }

    public String getName(){
        return  Name;
    }
    public  void setName(String value){
        Name = value;
    }

    public String getOtchestvo(){
        return Otchestvo;
    }
    public  void setOtchestvo(String value){
        Otchestvo = value;
    }

    public String getLogin(){
        return Login;
    }
    public void setLogin(String value){
        Login = value;
    }

    public String getPassword(){
        return Password;
    }
    public void setPassword(String value){
        Password = value;
    }

}
