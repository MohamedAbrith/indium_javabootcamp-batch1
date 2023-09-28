package com.indium.capstone.Dao;
import com.indium.capstone.Model.Skill;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SkillDaoJdbc implements SkillDao {
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;


    public Connection getConnection() {
        try {
            if (conn == null) {
                MysqlDataSource datasource = new MysqlDataSource();
                datasource.setServerName("localhost");
                datasource.setDatabaseName("skill");
                datasource.setUser("root");
                datasource.setPassword("Abrith24@");


                conn = datasource.getConnection();
                System.out.println("Connection created successfully. " + conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public Boolean create(Skill skill) {
        boolean status = false;
        try {
            String query = "INSERT INTO skills(id,name,description, category, experiance) values(?,?,?,?,?)";
            pstmt = getConnection().prepareStatement(query);
            pstmt.setInt(1, skill.getId());
            pstmt.setString(2, skill.getName());
            pstmt.setString(3, skill.getDescription());
            pstmt.setString(4, skill.getCategory());
            pstmt.setInt(5, skill.getExperience());
            status = pstmt.executeUpdate() > 0 ? true : false;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
}

//    public List<Skill> getall() {
//        List<Skill> skills = new ArrayList<>();
//        try {
//            stmt = getConnection().createStatement();
//            rs = stmt.executeQuery("SELECT * FROM skills");
//
//            while (rs.next()) {
//                int skillId = rs.getInt("skillid");
//                String name = rs.getString("name");
//                String description = rs.getString("description");
//                String category = rs.getString("category");
//                int experience = rs.getInt("experience");
//                int id = rs.getInt("id");
//                skills.add(new Skill(id,name, description,category,experience,skillId));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return skills;
//    }
//
//    public boolean update(Skill skill) {
//        boolean status = false;
//        try {
//            String query = "UPDATE skills SET name =?,description=?,category=?,experience =? WHERE skillid= ?";
//            pstmt = getConnection().prepareStatement(query);
//            pstmt.setString(1,skill.getName());
//            pstmt.setString(2,skill.getDescription());
//            pstmt.setString(3, skill.getCategory());
//            pstmt.setInt(4, skill.getExperience());
//            pstmt.setInt(5, skill.getSkillId());
//
//            status = pstmt.executeUpdate() > 0 ? true : false;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return status;
//    }
//
//    public boolean delete(int skillID) {
//        boolean status = false;
//        try {
//            stmt = getConnection().createStatement();
//
//            String query = "DELETE FROM skills WHERE skillid = " + skillID;
//
//            status = stmt.execute(query);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return status;
//    }