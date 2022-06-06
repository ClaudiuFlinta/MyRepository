package BusinessLayer;

public class MenuItem {


    protected int id;
    protected double price;
    protected String nume;
    protected double rating;
    protected double calories;
    protected double protein;
    protected double fat;
    protected double sodium;
    protected int noOfOrders;

    public MenuItem(int id, double price, String nume, double rating, double calories, double protein, double fat, double sodium) {
        super();
        this.id = id;
        this.price = price;
        this.nume = nume;
        this.rating = rating;
        this.calories = calories ;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
        this.noOfOrders = 0;
    }


    public void setNumberOfOrders(){

        this.noOfOrders = this.noOfOrders + 1;

    }
    public double computePrice() {
        return price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }


    public void setPrice(int price) {
        this.price = price;
    }


    public String getTitle() {
        return nume;
    }


    public void setTitle(String nume) {
        this.nume = nume;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getSodium() {
        return sodium;
    }

    public void setSodium(double sodium) {
        this.sodium = sodium;
    }

    public void add(MenuItem m1) {
        // TODO Auto-generated method stub

    }

    public int getNoOfOrders() {
        return noOfOrders;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "id=" + id +
                ", price=" + price +
                ", nume='" + nume + '\'' +
                ", rating=" + rating +
                ", calories=" + calories +
                ", protein=" + protein +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", noOfOrders=" + noOfOrders+
                '}';
    }
}
