package gp8.itc.cafe.Controller.DB;

import org.springframework.data.jpa.repository.JpaRepository;

import gp8.itc.cafe.Controller.DataStructure.DrinkCategory;


public interface RepositoryDrinkCategory extends JpaRepository<DrinkCategory, Integer>{
    
}
