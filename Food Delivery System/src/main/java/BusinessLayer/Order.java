package BusinessLayer;
import java.util.*;

public class Order {


    private int id;
    private int clientId;
    private Date date;
    private ArrayList<Integer> comandId;


    public Order(int id, int clientId) {
        this.id = id;
        this.clientId = clientId;
        this.date = new Date();
        comandId = new ArrayList<>();
    }

    public Order(int id, int clientId, Date d) {
        this.id = id;
        this.clientId = clientId;
        this.date = d;
        comandId = new ArrayList<>();
    }

    public void setTime(int h){
        this.date.setHours(h);
    }
    public void addMenuItem(MenuItem m){
        comandId.add(m.getId());
    }

    @Override
    public int hashCode() {

        int result = (((this.id + this.clientId) + 31)*7)%250;

        return result;

    }

    public int getId() {
        return id;
    }

    public int getHour(){
        return date.getHours();
    }

    public int getD(){
        return date.getDay();
    }

    public int getDate(){ return date.getDate(); }

    public int getYear(){ return date.getYear();}

    public int getMonth(){ return date.getMonth();}

    public int getClientId() {
        return clientId;
    }

    public ArrayList<Integer> getComandId() {
        return comandId;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", date=" + date +
                ", comandId=" + comandId +
                '}';
    }
}
