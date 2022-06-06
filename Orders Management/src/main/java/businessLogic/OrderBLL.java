package businessLogic;

import java.sql.ResultSet;
import java.util.NoSuchElementException;

import dao.OrderDAO;
import model.Orders;

/**
 * This class is for manipulating Orders
 *
 * @author Flinta Claudiu Constantin
 */

public class OrderBLL {

    private OrderDAO orderDAO;

    public OrderBLL() {

        orderDAO = new OrderDAO();
    }

    /**
     * This method is for finding an order after it's id
     *
     * @param id Id of the order, in the table that stored data about it
     * @return An object of type Order, which is the object that we are looking for
     */
    public Orders findOrderById(int id) {
        Orders ord  = orderDAO.findById(id);
        if (ord == null) {
            throw new NoSuchElementException("The order with id =" + id + " was not found!");
        }
        return ord;
    }


    public Orders insertOrder(Orders order) {

        return orderDAO.insert(order);
    }

    public ResultSet connectToTableOrder(){
        return orderDAO.setTable();
    }
}
