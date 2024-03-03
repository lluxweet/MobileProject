package com.example.diplomproject.server.models;

public class ProdajaEntity {
    private int id;
    private int idProduct;
    private int idClient;
    private int colichestvo;
    private int idStatus;
    private int idStatusOplata;
    private int idTipOplata;

    private ClientEntity client;
    private ProductEntity product;
    private StatusEntity status;
    private StatusPayEntity statusPay;
    private TypePayEntity typePay;
    public int getId(){
        return id;
    }
    public void setId(int value){
        id = value;
    }
    public int getIdProduct(){
        return idProduct;
    }
    public void setIdProduct(int value){
        idProduct = value;
    }
    public int getIdClient(){
        return idClient;
    }
    public void setIdClient(int value){ idClient = value; }
    public int getColichestvo(){
        return colichestvo;
    }
    public void setColichestvo(int value){
        colichestvo = value;
    }
    public int getIdStatus(){
        return idStatus;
    }
    public void setIdStatus(int value){
        idStatus = value;
    }
    public int getIdStatusOplata(){
        return idStatusOplata;
    }
    public void setIdStatusOplata(int value){
        idStatusOplata = value;
    }
    public int getIdTipOplata(){
        return idTipOplata;
    }
    public void setIdTipOplata(int value){
        idTipOplata = value;
    }



    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }


    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public StatusEntity getStatus() {
        return status;
    }

    public void setStatus(StatusEntity status) {
        this.status = status;
    }

    public StatusPayEntity getStatusPay() {
        return statusPay;
    }

    public void setStatusPay(StatusPayEntity statusPay) {
        this.statusPay = statusPay;
    }

    public TypePayEntity getTypePay() {
        return typePay;
    }

    public void setTypePay(TypePayEntity typePay) {
        this.typePay = typePay;
    }
}
