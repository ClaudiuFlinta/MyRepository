package model;

public class Orders {

    private int id;
    private String nume;
    private String adress;
    private int age;
    private String productName;
    private int pricePerUnit;
    private int quantity;
    private int totalPrice;

    public Orders(){

    }

    public Orders(int id, String nume, String adress, int age, String productName, int pricePerUnit, int quantity, int totalPrice) {
        this.id = id;
        this.nume = nume;
        this.adress = adress;
        this.age = age;
        this.productName = productName;
        this.pricePerUnit = pricePerUnit;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public Orders(String nume, String adress, int age, String productName, int pricePerUnit, int quantity, int totalPrce) {
        this.nume = nume;
        this.adress = adress;
        this.age = age;
        this.productName = productName;
        this.pricePerUnit = pricePerUnit;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(int pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalPrce() {
        return totalPrice;
    }

    public void setTotalPrce(int totalPrce) {
        this.totalPrice = totalPrce;
    }
}
