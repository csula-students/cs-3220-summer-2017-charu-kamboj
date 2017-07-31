package lab6;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateFoodEntryDAO {
	public List<CreateFoodEntry>list(){
		List<CreateFoodEntry> list=new ArrayList<>();
		Database db=new Database();
		try(Connection c =db.connection()){
			Statement stmt =c.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM FoodItems");
			while(rs.next()){
				list.add(new CreateFoodEntry(
				rs.getInt("ID"),
				rs.getString("FoodName"),
				rs.getString("ImageUrl"),
				rs.getString("Description"),
				rs.getDouble("Price")
				));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			return list;
		}
		return list;
		
	}
	
	public Optional<CreateFoodEntry> get(int id) {
        Optional<CreateFoodEntry> tor = Optional.empty();
        Database db = new Database();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("SELECT * FROM FoodItems WHERE FoodItems.ID = ? ");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                CreateFoodEntry foodToEdit = new CreateFoodEntry(rs.getInt("ID"),
                                                    rs.getString("FoodName"),
                                                    rs.getString("ImageUrl"),
                                                    rs.getString("Description"),
                                                    (double) rs.getFloat("Price"));
                tor = Optional.of(foodToEdit);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tor;
}
	
	public void add(CreateFoodEntry entry) {
        Database db = new Database();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("INSERT INTO FoodItems ( FoodName,ImageUrl,Description,Price) VALUES ( ?,?,?,?)");
            pstmt.setString(1, entry.getName());
            pstmt.setString(2, entry.getDesc());
            pstmt.setString(3, entry.getImage());
            pstmt.setDouble(4, entry.getPrice());
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
}
    public void update(CreateFoodEntry entry) {
        Database db = new Database();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("UPDATE FoodItems SET  FoodName = ?, ImageUrl = ?,Description = ? Price = ? WHERE FoodItems.ID = ?");
           // pstmt.setInt(1, entry.getId());
            pstmt.setString(1, entry.getName());
            pstmt.setString(2, entry.getDesc());
            pstmt.setString(3, entry.getImage());
            pstmt.setFloat(4, (float) entry.getPrice());
            pstmt.setInt(5, entry.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        Database db = new Database();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("DELETE FROM FoodItems WHERE ID = ? ");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
}

}
