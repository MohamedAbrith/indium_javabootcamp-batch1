package com.indium.capstone.Dao;
import com.indium.capstone.Model.Associates;
import java.util.List;
public interface AssociatesDao {
    public boolean create(Associates associates);

    public boolean update(Associates associates);

    boolean delete(int id);
    List<Associates> getall();
}
