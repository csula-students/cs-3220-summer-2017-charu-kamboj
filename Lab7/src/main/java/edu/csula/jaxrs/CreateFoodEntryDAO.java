package edu.csula.jaxrs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import edu.csula.jaxrs.model.CreateFoodEntry;

public class CreateFoodEntryDAO implements DAOResource<CreateFoodEntry> {
    public List<CreateFoodEntry> list() {
        List<CreateFoodEntry> foodlist = new ArrayList<>();
        DatabaseResource db = new DatabaseResource();
        try (Connection c = db.connection()) {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM foodmenu");
            while (rs.next()) {
                foodlist.add(new CreateFoodEntry(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getString("imgURL"),
                 rs.getDouble("price")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return foodlist;
        }
        return foodlist;
    }

    public Optional<CreateFoodEntry> get(int id) {
        Optional<CreateFoodEntry> items = Optional.empty();
        DatabaseResource db = new DatabaseResource();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("SELECT * FROM foodmenu WHERE foodmenu.id = ? ");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                CreateFoodEntry edifood = new CreateFoodEntry(rs.getInt("id"),
                                                    rs.getString("name"),
                                                    rs.getString("description"),
                                                    rs.getString("imgURL"),
                                                     rs.getDouble("price"));
                items = Optional.of(edifood);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    public void add(CreateFoodEntry obj) {
        DatabaseResource db = new DatabaseResource();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("INSERT INTO foodmenu (id, name, description, imgURL, price) VALUES (?, ?, ?, ?, ?)");
            pstmt.setInt(1, obj.getId());
            pstmt.setString(2, obj.getName());
            pstmt.setString(3, obj.getDescription());
            pstmt.setString(4, obj.getImgURL());
            pstmt.setDouble(5,  obj.getPrice());
           
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(CreateFoodEntry obj) {
        DatabaseResource db = new DatabaseResource();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("UPDATE foodmenu SET id = ?, name = ?, description = ?, imgURL = ?, price = ? WHERE id = ?");
            pstmt.setInt(1, obj.getId());
            pstmt.setString(2, obj.getName());
            pstmt.setString(3, obj.getDescription());
            pstmt.setString(4, obj.getImgURL());
            pstmt.setDouble(5,  obj.getPrice());
            pstmt.setInt(6, obj.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        DatabaseResource db = new DatabaseResource();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("DELETE FROM foodmenu WHERE menu.id = ? ");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}