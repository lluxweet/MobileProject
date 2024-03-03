package com.example.diplomproject.server.models;

public class ClientEntity {
    private int idClient;
    private String familia;
    private String name;
    private String otchestvo;
    private int idOrganizacia;
    private int Predprinimatel;
    private int Phone;
    private int Passport;
    public int getIdClient() { return idClient; }
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
    public String getFamilia() { return familia; }
    public void setFamilia(String familia) { this.familia = familia; }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getOtchestvo() { return otchestvo; }

    public void setOtchestvo(String otchestvo) { this.otchestvo = otchestvo; }
    public int getIdOrganizacia() {
        return idOrganizacia;
    }
    public void setIdOrganizacia(int idOrganizacia) {
        this.idOrganizacia = idOrganizacia;
    }
    public int getPassport() {
        return Passport;
    }
    public void setPassport(int passport) {
        Passport = passport;
    }
    public int getPredprinimatel() { return Predprinimatel; }
    public void setPredprinimatel(int predprinimatel) { Predprinimatel = predprinimatel; }
    public int getPhone() { return Phone; }
    public void setPhone(int phone) { Phone = phone; }
}
