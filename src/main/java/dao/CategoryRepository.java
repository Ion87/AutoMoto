package dao;


import entities.Category;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import db.PostgresConnectionManager;
import db.ReadSQLFile;


public class CategoryRepository {

    private List<Category> list = new ArrayList<>();

    public boolean create(Category category) throws SQLException,IOException {

        PreparedStatement pst = PostgresConnectionManager.getConnection().prepareStatement(ReadSQLFile.getText("create"));
        pst.setLong(1,category.getId());
        pst.setString(2,category.getName());
        return pst.execute();
    }

    public boolean update(Category category)throws SQLException,IOException{
        PreparedStatement pst = PostgresConnectionManager.getConnection().prepareStatement(ReadSQLFile.getText("update"));
        pst.setString(1,category.getName());
        pst.setLong(2,category.getId());
        pst.executeUpdate();
        return true;
    }
    public boolean delete(Category category)throws SQLException,IOException{
        PreparedStatement pst = PostgresConnectionManager.getConnection().prepareStatement(ReadSQLFile.getText("delete"));
        pst.setLong(1,category.getId());
        return pst.execute();
    }
    public boolean save(Category category)throws SQLException{
        try{
            Category currentCat = find(category.getId());
            if (currentCat != null){
                update(category);
            }else {
                create(category);
            }
            return true;
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }

    public Category find(long id)throws SQLException,IOException{
        PreparedStatement pst = PostgresConnectionManager.getConnection().prepareStatement(ReadSQLFile.getText("find"));
        pst.setLong(1,id);
        ResultSet rs = pst.executeQuery();
        Category newCat = null;
        if (rs.next()){
            newCat = new Category();
            newCat.setId(rs.getLong("id"));
            newCat.setName(rs.getString("name"));
            newCat.setParentCategoryId(rs.getLong("parent_category_Id"));
        }
        System.out.println(newCat);
        return newCat;
    }

    public List<Category> findAll()throws SQLException, IOException{
        Statement st = PostgresConnectionManager.getConnection().createStatement();
        ResultSet rs = st.executeQuery(ReadSQLFile.getText("findAll"));
        Category newCat = null;
        list.clear();
        while (rs.next()){
            newCat = new Category();
            newCat.setId(rs.getLong("id"));
            newCat.setName(rs.getString("name"));
            newCat.setParentCategoryId(rs.getLong("parent_category_Id"));
            list.add(newCat);
        }
        list.forEach(System.out::println);
        return list;
    }
    public List<Category> findAllByParent(Category category)throws SQLException,IOException{
        PreparedStatement pst = PostgresConnectionManager.getConnection().prepareStatement(ReadSQLFile.getText("findAll"));
        long parent_id = category.getParentCategoryId();
        pst.setLong(1,parent_id);
        ResultSet rs = pst.executeQuery();
        category = null;
        list.clear();
        while (rs.next()){
            category = new Category();
            category.setId(rs.getLong("id"));
            category.setName(rs.getString("name"));
            category.setParentCategoryId(rs.getLong("parent_category_Id"));
            list.add(category);
        }
        list.forEach(System.out::println);
        return list;
    }

}
