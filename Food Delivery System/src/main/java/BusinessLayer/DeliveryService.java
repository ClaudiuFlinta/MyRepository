package BusinessLayer;



import java.util.LinkedHashMap;
import java.util.Observable;


/**
 * @author Claudiu
 *
 * This Class is for managing orders
 */
public class DeliveryService extends Observable implements DeliveryServiceInterface {

    public static LinkedHashMap<Order, Order> comenzi =  new LinkedHashMap<>();

    public DeliveryService(){
       // comenzi =  new LinkedHashMap<>();
    }

    /**
     * Sets the id (must correspond to a legal id).
     *
     * @param order current order.
     */
    public static void addComanda(Order order){

        assert order.getClientId() < 0 : "Not a valid ID!!";
        comenzi.put(order, order);

    }


    /**
     * Method used to notify the Observer each time an order is made
     */
    public void nofificare(){
        setChanged();
        notifyObservers();
    }

    /**
     * Method used to check if client Id is > than 0
     *
     * @param o current order
     */
    public boolean checkId(Order o){
        boolean b = comenzi.get(o).getClientId() > 0;
        return b;
    }


    /**
     * Method used to generate the orders in chronological order
     *
     */
    public static void parcurgereComenzi(){
     for(Order o : comenzi.keySet()){
         System.out.println(o.hashCode() + "->" +comenzi.get(o));
     }
    }

}
