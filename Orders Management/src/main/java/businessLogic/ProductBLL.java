package businessLogic;

import businessLogic.validators.EmailValidator;
import businessLogic.validators.StudentAgeValidator;
import businessLogic.validators.Validator;
import dao.StudentDAO;
import model.Product;
import dao.ProductDAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


public class ProductBLL {

    private ProductDAO productDAO;

    public ProductBLL() {

        productDAO = new ProductDAO();
    }

    public Product findProductById(int id) {
        Product prod = productDAO.findById(id);
        if (prod == null) {
            throw new NoSuchElementException("The product with id =" + id + " was not found!");
        }
        return prod;
    }

    public Product insertProduct(Product product) {

        return productDAO.insert(product);
    }

    public Product updateProduct(Product product) {

        return productDAO.update(product);
    }

    public Product deleteProduct(Product product) {

        return productDAO.delete(product);
    }

    public ResultSet connectToTable2(){
        return productDAO.setTable();
    }
}
