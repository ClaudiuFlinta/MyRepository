package start;

import businessLogic.StudentBLL;
import businessLogic.ProductBLL;
import businessLogic.OrderBLL;
import presentation.Controller;
import presentation.View;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Start {

    protected static final Logger LOGGER = Logger.getLogger(Start.class.getName());

    public static void main(String[] args) throws SQLException {

        View theView = new View();

        StudentBLL studentBll = new StudentBLL();
        ProductBLL productBLL = new ProductBLL();
        OrderBLL orderBLL = new OrderBLL();
        ResultSet rs  =studentBll.connectToTable();
        theView.updateTable(rs);
        ResultSet rs2 = productBLL.connectToTable2();
        theView.updateTable2(rs2);
        rs = studentBll.connectToTable();
        theView.updateTable3(rs);
        rs2 = productBLL.connectToTable2();
        theView.updateTable4(rs2);
        ResultSet rs3 = orderBLL.connectToTableOrder();
        theView.updateTable5(rs3);
        Controller controller = new Controller(theView);



    }


}
