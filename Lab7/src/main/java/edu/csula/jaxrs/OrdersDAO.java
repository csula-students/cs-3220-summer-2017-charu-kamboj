package edu.csula.jaxrs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import edu.csula.jaxrs.model.Order;


public class OrdersDAO implements DAOResource<Order>{

    public List<Order> list() {
        List<Order> list = new ArrayList<>();
       DatabaseResource db = new DatabaseResource();
        try (Connection c = db.connection()) {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM orders;");
            while (rs.next()) {
                    list.add(new Order(
                       rs.getInt("order_id"), 
                        rs.getString("customer_name"),
                        rs.getString("status")
                    ));
                } 

               
            

        } catch (SQLException e) {
            e.printStackTrace();
            return list;
        }
        return list;
    }
    

    
    
    public Optional<Order> get(int id) {
        Optional<Order> items = Optional.empty();
        DatabaseResource db = new DatabaseResource();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("SELECT * FROM orders where order_id=?");
            pstmt.setInt(1, id);
          
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
               
                 Order   order = new Order(rs.getInt("order_id"),
                                            rs.getString("customer_name"),
                                            rs.getString("status")
                                            );
                

                items = Optional.of(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
    
    
    
    public void add(Order order) {

        DatabaseResource db = new DatabaseResource();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("INSERT INTO orders (order_id,customer_name,status) VALUES (?,?,?)");
            pstmt.setInt(1, order.getId());
            pstmt.setString(2, order.getCustomerName());
            pstmt.setString(3, order.getStatus());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
    public void update(Order order) {
        DatabaseResource db = new DatabaseResource();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("UPDATE orders SET order_id=?, customer_name=?,status=? WHERE order_id=?");
            pstmt.setInt(1, order.getId());
            pstmt.setString(2, order.getCustomerName());
            pstmt.setString(3, order.getStatus());
            pstmt.setInt(4, order.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        DatabaseResource db = new DatabaseResource();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("DELETE FROM orders WHERE orders.order_id=?");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
