package gp8.itc.cafe.Controller.DB;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import gp8.itc.cafe.Controller.DataStructure.DrinkSize;

public interface RepositoryDrinkSize extends JpaRepository<DrinkSize, Integer>{

    Optional<DrinkSize> findBySize(String drinkSize);
    
}
