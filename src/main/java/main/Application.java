package main;

import dao.CategoryRepository;
import entities.Category;

import java.io.IOException;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException, IOException {
        //CREATE
        Category testCat = new Category(200,"Test category",1);
        CategoryRepository cr = new CategoryRepository();
        cr.create(testCat);

        //READ
//        CategoryRepository cr = new CategoryRepository();
//        cr.findAll();

//        CategoryRepository cr = new CategoryRepository();
//        cr.find(1);

//        CategoryRepository cr = new CategoryRepository();
//        Category cat = new Category(0,"",1);
//        cr.findAllByParent(cat);

        //UPDATE
//        CategoryRepository cr = new CategoryRepository();
//        Category category = new Category(103,"test",0);
//        cr.update(category);

        //DELETE
//        CategoryRepository cr = new CategoryRepository();
//        Category category1 = new Category(200,"ion",1);
//        cr.delete(category1);

        //SAVE
//        CategoryRepository cr = new CategoryRepository();
//        Category category2 = new Category(105,"ion",1);
//        cr.save(category2);

    }
}
