package BusinessLayer;

public class BaseProduct extends MenuItem{


    public BaseProduct(int id, double price, String nume, double rating, double calories, double protein, double fat, double sodium) {
        super(id, price, nume, rating, calories, protein, fat, sodium);

        // TODO Auto-generated constructor stub
    }

    public double computePrice() {
        return this.price;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }

    @Override
    public double getRating() {
        return super.getRating();
    }

    @Override
    public double getCalories() {
        return super.getCalories();
    }

    @Override
    public double getProtein() {
        return super.getProtein();
    }

    @Override
    public double getFat() {
        return super.getFat();
    }

    @Override
    public double getSodium() {
        return super.getSodium();
    }
}
