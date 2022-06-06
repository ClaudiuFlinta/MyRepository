package BusinessLayer;

import java.util.LinkedList;

public class ComposedProduct  extends MenuItem{

    private LinkedList<BaseProduct> list;


    public ComposedProduct(int id, double price, String nume){
        super(id, price, nume, 0 ,0 ,0,0 ,0);
        this.list = new LinkedList<>();

    }
    public ComposedProduct(int id, double price, String nume, double rating, double calories, double protein, double fat, double sodium) {
        super(id, price, nume, rating, calories, protein, fat, sodium);
        this.list = new LinkedList<>();
        // TODO Auto-generated constructor stub
    }

    public double computePrice() {
        float price = 0;
        for(BaseProduct p : list) {
            price += p.computePrice();
        }
        this.price = price;
        return price;
    }

    public double computeRating() {
        float rating = 0;
        for(BaseProduct p : list) {
            rating += p.getRating();
        }
        this.rating = rating/list.size();
        return rating;
    }
    public double computeCalories() {
        float calories = 0;
        for(BaseProduct p : list) {
            calories += p.getCalories();
        }
        this.calories = calories;
        return calories;
    }

    public String computeName() {
        String name="";
        for(BaseProduct p : list) {
            name = name + p.getTitle() + " ";
        }
        this.nume = name;
        return name;
    }

    public double computeProtein() {
        float protein = 0;
        for(BaseProduct p : list) {
            protein += p.getProtein();
        }
        this.protein = protein;
        return protein;
    }

    public double computeFat() {
        float fat = 0;
        for(BaseProduct p : list) {
            fat += p.getFat();
        }
        this.fat = fat;
        return fat;
    }

    public double computeSodium() {
        float sodium = 0;
        for(BaseProduct p : list) {
            sodium += p.getSodium();
        }
        this.sodium = sodium;
        return sodium;
    }

    public void add(MenuItem m1) {
        list.add((BaseProduct) m1);
    }

    public int getSize(){
        return list.size();
    }

    public BaseProduct getElement(int index){
        return list.get(index);
    }

    @Override
    public String toString() {
        return "ComposedProduct{" +
                "list=" + list +
                '}';
    }
}
