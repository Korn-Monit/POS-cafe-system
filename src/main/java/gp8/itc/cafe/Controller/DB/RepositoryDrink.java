package gp8.itc.cafe.Controller.DB;

import org.springframework.data.jpa.repository.JpaRepository;


import gp8.itc.cafe.Controller.DataStructure.Drink;


public interface RepositoryDrink extends JpaRepository<Drink, Integer>{
    
}
