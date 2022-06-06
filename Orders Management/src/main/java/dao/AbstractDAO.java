package dao;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;

public class AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    private final Class<T> type;

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }

    /**
     * This method is for making a comparison between 2 strings
     *
     * @param str1
     * @param str2
     * @return 0 if the two strings are equals from the morphological point if view, and something != 0 if they not
     */
    public static int stringCompare(String str1, String str2)
    {

        int l1 = str1.length();
        int l2 = str2.length();
        int lmin = Math.min(l1, l2);

        for (int i = 0; i < lmin; i++) {
            int str1_ch = (int)str1.charAt(i);
            int str2_ch = (int)str2.charAt(i);

            if (str1_ch != str2_ch) {
                return str1_ch - str2_ch;
            }
        }

        if (l1 != l2) {
            return l1 - l2;
        }

        else {
            return 0;
        }
    }

    /**
     * This method is for creating a string which represents Select after a criteria
     *
     * @param field criteria of selection
     * @return The query
     */
    private String createSelectQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " =?");
        return sb.toString();
    }

    /**
     *This method is for creating the string for Select Query
     *
     * @return a string which represents the select query
     */
    private String createTableQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        return sb.toString();
    }

    /**
     * This method is for creating an insert query
     *
     * @return a string which represents the insert query
     */
    private String createInsertQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ");
        sb.append(type.getSimpleName() + " (");
        int iteratie = 0;
        int lungime = type.getDeclaredFields().length;
        for (Field field : type.getDeclaredFields()) {
            if(iteratie ==0){
                iteratie ++;
                continue;
            }else {
                sb.append(field.getName());
                iteratie++;
                if(iteratie < lungime){
                    sb.append(",");
                }
                else {
                    sb.append(")");
                }
            }
        }
        sb.append(" VALUES(");
        for(int i=0; i<lungime-2; i++){
            sb.append("?,");
        }
        sb.append("?)");

        return sb.toString();
    }

    /**
     * This method is for create an update query
     *
     * @return a string which represents the update query
     */
    private String createUpdateQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ");
        sb.append(type.getSimpleName());
        sb.append(" SET ");
        int iteratie = 0;
        int lungime = type.getDeclaredFields().length;
        for (Field field : type.getDeclaredFields()) {
            if(iteratie ==0){
                iteratie ++;
                continue;
            }else {
                sb.append(field.getName());
                iteratie++;
                if(iteratie < lungime){
                    sb.append(" =?, ");
                }
                else {
                    sb.append(" =? ");
                }
            }
        }
        sb.append(" WHERE id =?");
        return sb.toString();
    }

    /**
     * This method is for creating delete querys
     *
     * @return the string contains the delete query
     */
    private String createDeleteQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE id=? ");
        return sb.toString();
    }

    public List<T> findAll() {
        // TODO:
        return null;
    }

    /**
     * This method is for set the data into JTabels
     *
     * @return a ResultSet which represents the set of rows form a certain table
     */
    public ResultSet setTable() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createTableQuery();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);

            resultSet = statement.executeQuery();


        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            return resultSet;
        }

    }

    /**
     * This method is for seraching aftre an item in a table using the id parameter
     *
     * @param id is for identification of the row we are looking for
     * @return an instance of the class that extends this abstract class
     */
    public T findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("id");
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * This method is for creating a list of oblects T from the ResultSet of the table
     *
     * @param resultSet rows of the table
     * @return list of objects T
     */
    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T)ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Method used for inserting a row in a table using Reflection
     *
     * @param t could be any instance of a class that extends the abstract class
     * @return an instance of the class extends the abstract class
     */
    public T insert(T t) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createInsertQuery();
        int id = 1;
        System.out.println("Fac Insert din clasa" + t.getClass().getName());
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            //ar trebui setate vaorile de inserat
            int iteratie = 0;
            for (Field field : t.getClass().getDeclaredFields()) {
                if(iteratie == 0){
                    //sar peste id
                    iteratie ++;
                    continue;
                }
                else {
                    field.setAccessible(true);
                    Object value;
                    try {
                        value = field.get(t);
                        int comp = stringCompare(field.getType().toString(), "int");
                        if (comp == 0) {
                            statement.setInt(id, (Integer) value);
                            id = id + 1;
                        } else {
                            statement.setString(id, (String) value);
                            id = id + 1;
                        }


                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            statement.executeUpdate();
            return t;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;

    }

    /**
     * Method used for updating a row in a table using Reflection
     *
     * @param t could be any instance of a class that extends the abstract class
     * @return an instance of the class extends the abstract class
     */
    public T update(T t) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createUpdateQuery();
        int id = 1;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            //ar trebui setate vaorile de inserat
            int iteratie = 0;
            int firstValue;
            for (Field field : t.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Object value;
                try {
                    value = field.get(t);
                    if (iteratie == 0) {
                        //setez ultimul parametru;
                        iteratie ++;
                        int comp = stringCompare(field.getType().toString(), "int");
                        if (comp == 0) {
                            statement.setInt(t.getClass().getDeclaredFields().length, (Integer) value);
                            //id = id + 1;
                        } else {
                            statement.setString(t.getClass().getDeclaredFields().length, (String) value);
                            // id = id + 1;
                        }
                    } else {
                        int comp = stringCompare(field.getType().toString(), "int");
                        if (comp == 0) {
                            statement.setInt(id, (Integer) value);
                            id = id + 1;
                        } else {
                            statement.setString(id, (String) value);
                            id = id + 1;
                        }

                    }
                } catch(IllegalArgumentException e){
                    e.printStackTrace();
                } catch(IllegalAccessException e){
                    e.printStackTrace();
                }

            }

            statement.executeUpdate();
            return t;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;

    }

    /**
     * Method used for deleting a row from a table using Reflection
     *
     * @param t could be any instance of a class that extends the abstract class
     * @return an instance of the class extends the abstract class
     */
    public T delete(T t) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createDeleteQuery();
        int id = 1;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            //ar trebui setate vaorile de inserat

            int firstValue;
            for (Field field : t.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Object value;
                try {
                    value = field.get(t);
                    int comp = stringCompare(field.getType().toString(), "int");
                    if (comp == 0) {
                        statement.setInt(id, (Integer) value);

                    } else {
                        statement.setString(id, (String) value);

                    }

                } catch(IllegalArgumentException e){
                    e.printStackTrace();
                } catch(IllegalAccessException e){
                    e.printStackTrace();
                }
                break;

            }

            statement.executeUpdate();
            return t;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;

    }


}
