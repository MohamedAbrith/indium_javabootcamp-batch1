package com.indium.capstone.Dao;
import com.indium.capstone.Model.Associates;
import java.util.List;
public interface AssociatesDao {
    public boolean create(Associates associates);

    public boolean update(Associates associates);

    boolean delete(int id);

    //
    //    @Override
    //    public boolean delete(int id) {
    //        boolean status = false;
    //        try {
    //            stmt = getConnection().createStatement();
    //
    //            String query = "DELETE FROM users WHERE id = " + id;
    //            System.out.println("Associates "+id+"deleted.");
    //            status = stmt.execute(query);
    //        } catch (SQLException e) {
    //            e.printStackTrace();
    //        }
    //        return status;
    //    }
    //
    List<Associates> getall();
//    public boolean update(Associates associates);
//
//    public boolean delete(int id);
//
//    public List<Associates> getall();

}
