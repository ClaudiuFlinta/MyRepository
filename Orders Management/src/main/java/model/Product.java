package model;

public class Product {

    private int id;
    private String nume;
    private int price;
    private int quantity;

    public Product(){

    }

    public Product(int id, String nume, int price, int quantity) {
        super();
        this.id = id;
        this.nume = nume;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(String nume, int price, int quantity) {
        super();
        this.nume = nume;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
