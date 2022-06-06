package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;
import model.Student;


public class StudentDAO extends AbstractDAO<Student>{

    protected static final Logger LOGGER = Logger.getLogger(StudentDAO.class.getName());

}
