package com.indium.capstone.Dao;
import com.indium.capstone.Model.Associates;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AssociatesDaoJdbc implements AssociatesDao{

    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;


    public Connection getConnection() {
        try {
            if(conn == null) {
                MysqlDataSource datasource = new MysqlDataSource();
                datasource.setServerName("localhost");
                datasource.setDatabaseName("associateskilltracker");
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

    @Override
    public boolean create(Associates associates) {
        boolean status = false;
        try {

            String query = "INSERT INTO asso (id,name,age,BussinessUnit,email,location) values(?,?,?,?,?,?)";
            pstmt = getConnection().prepareStatement(query);
            pstmt.setInt(1, associates.getId());
            pstmt.setString(2, associates.getName());
            pstmt.setInt(3, associates.getAge());
            pstmt.setString(4, associates.getBusinessUnit());
            pstmt.setString(5, associates.getEmail());
            pstmt.setString(6, associates.getLocation());
            System.out.println("Data created and Stored successfully");
            status = pstmt.executeUpdate() > 0 ? true : false;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public boolean update(Associates associates) {
        boolean status = false;
        try {
            String query = "UPDATE asso SET name =?,age=?,BussinessUnit=?,email=?,location=? WHERE id = ?";
            pstmt = getConnection().prepareStatement(query);
            pstmt.setString(1,associates.getName());
            pstmt.setInt(2, associates.getAge());
            pstmt.setString(3, associates.getBusinessUnit());
            pstmt.setString(4, associates.getEmail());
            pstmt.setString(5, associates.getLocation());
            pstmt.setInt(6, associates.getId());

            status = pstmt.executeUpdate() > 0 ? true : false;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
    @Override
    public boolean delete(int id) {
        boolean status = false;
        try {
            stmt = getConnection().createStatement();

            String query = "DELETE FROM asso WHERE id = " + id;

            status = stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
    public List<Associates> getall() {
        List<Associates> accounts = new ArrayList<>();
        try {
            stmt = getConnection().createStatement();
            rs = stmt.executeQuery("SELECT * FROM asso");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String businessUnit = rs.getString("BussinessUnit");
                String email = rs.getString("email");
                String location = rs.getString("location");
                accounts.add(new Associates(id,name, age,businessUnit,email,location));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }
}

