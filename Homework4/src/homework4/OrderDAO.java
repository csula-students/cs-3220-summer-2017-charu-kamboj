package homework4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class OrderDAO implements DAO<Order> {
	
	public List<Order>list(){
		List<Order> list=new ArrayList<>();
		List<Integer> orderids = new ArrayList<>();
		Database db=new Database();
		try(Connection c=db.connection()){
			
			Statement stmt =c.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM orders INNER JOIN order_foods INNER JOIN FoodItems WHERE orders.order_id = order_foods.order_foods_id AND FoodItems.id = order_foods.food_id;");
				while(rs.next()){
					int order_id=rs.getInt("order_id");
					CreateFoodEntry food_item_to_add = new CreateFoodEntry(
		                    rs.getInt("ID"),
		                    rs.getString("FoodName"),
		                    rs.getString("ImageUrl"),
		                    rs.getString("Description"), 
		                    (double) rs.getFloat("Price")
		                );
		                //food_item_to_add.quantity = rs.getInt("food_quantity");
					if (!orderids.contains(order_id)) {
	                    
	                    orderids.add(order_id);

	                    List<CreateFoodEntry> list_with_food_item = new ArrayList<CreateFoodEntry>();
	                    list_with_food_item.add(food_item_to_add);

	                    list.add(new Order(
	                        order_id,
	                        list_with_food_item,
	                        rs.getString("customer_name"),
	                        rs.getString("order_status"),
	                        rs.getTimestamp("order_time")
	                    ));
					}
					
	                    else {
	                        for (int i = 0; i < list.size(); i++) {
	                            if (list.get(i).getID() == order_id) {
	                                list.get(i).items.add(food_item_to_add);
	                            }
	                        }
	                    }
	                }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	

	@Override
	public Optional<Order> get(int id) {
		
		Optional<Order> toRet = Optional.empty();
        Database db = new Database();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("SELECT * FROM orders INNER JOIN order_foods INNER JOIN FoodItems WHERE orders.order_id = ? AND order_foods.order_foods_id = ? AND order_foods.food_id = FoodItems.ID");
            pstmt.setInt(1, id);
            pstmt.setInt(2, id);
            ResultSet rs = pstmt.executeQuery();

            boolean createdNewOrder = false;
            Order newOrder = null;
            if (rs.next()) {
                
                CreateFoodEntry foodItemToAdd = new CreateFoodEntry(
                    rs.getInt("Id"),
                    rs.getString("FoodName"),
                    rs.getString("ImageUrl"),
                    rs.getString("description"), 
                    (double) rs.getFloat("Price")
                );
                //foodItemToAdd.quantity = rs.getInt("food_quantity");

                if (!createdNewOrder) {
                    List<CreateFoodEntry> listOfFoodItems = new ArrayList<CreateFoodEntry>();
                    listOfFoodItems.add(foodItemToAdd);
                    newOrder = new Order(rs.getInt("order_id"),
                                            listOfFoodItems,
                                            rs.getString("customer_name"),
                                            rs.getString("order_status"),
                                            rs.getTimestamp("order_time")
                                            );
                    createdNewOrder = true;
                } else {
                    newOrder.items.add(foodItemToAdd);
                }

                toRet = Optional.of(newOrder);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toRet;
	}

	@Override
	public void add(Order obj) {
		Database db = new Database();
        try (Connection c = db.connection()) {

            // insert into ORDERS table
            PreparedStatement pstmt = c.prepareStatement("INSERT INTO orders (order_id, customer_name, order_status, order_time) VALUES (?, ?, ?, ?)");
            pstmt.setInt(1, obj.getID());
            pstmt.setString(2, obj.getCustomerName());
            pstmt.setString(3, obj.getstatus());
            pstmt.setTimestamp(4, getSQLDate(obj.getOrdertime()));
            pstmt.executeUpdate();

            // for each food item in the order, insert one line into ORDER_FOODS table
            for (int i = 0; i < obj.getItems().size(); i++) {
                pstmt = c.prepareStatement("INSERT INTO order_foods (order_foods_id, menu_id, food_quantity) VALUES (?, ?, ?)");
                pstmt.setInt(1, obj.getID());
                pstmt.setInt(2, obj.getItems().get(i).getId());
                //pstmt.setInt(3, obj.getItems().get(i).getQuantity());
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	private static java.sql.Timestamp getSQLDate(java.util.Date date) {
        return new java.sql.Timestamp(date.getTime());
}

	public int getNextOrderId(){
		Database db=new Database();
		int highest=1;
		try(Connection c=db.connection()){
			Statement stmt=c.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT max(order_id) FROM orders;");
			while(rs.next()){
				highest=rs.getInt("max(order_id)");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return highest+1;
	}


	@Override
	public void update(Order obj) {
		 Database db = new Database();
	        try (Connection c = db.connection()) {
	            PreparedStatement pstmt = c.prepareStatement("UPDATE orders SET order_id = ?, customer_name = ?, order_status = ?, order_time = ? WHERE order_id = ?");
	            pstmt.setInt(1, obj.getID());
	            pstmt.setString(2, obj.getCustomerName());
	            pstmt.setString(3, obj.getstatus());
	            pstmt.setTimestamp(4, getSQLDate(obj.getOrdertime()));
	            pstmt.setInt(5, obj.getID());
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	}
		
	}

	@Override
	public void delete(int id) {
		 Database db = new Database();
	        try (Connection c = db.connection()) {
	            PreparedStatement pstmt = c.prepareStatement("DELETE FROM orders WHERE orders.order_id = ? ");
	            pstmt.setInt(1, id);
	            pstmt.executeUpdate();

	            pstmt = c.prepareStatement("DELETE FROM order_foods WHERE order_foods.order_foods_id = ? ");
	            pstmt.setInt(1, id);
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}
		
	}

	

