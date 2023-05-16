package gp8.itc.cafe.Controller.DB;

import org.springframework.data.jpa.repository.JpaRepository;
import gp8.itc.cafe.Controller.DataStructure.DrinkSize;

public interface RepositoryDrinkSize extends JpaRepository<DrinkSize, Integer>{
    
}
