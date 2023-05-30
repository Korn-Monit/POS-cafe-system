package gp8.itc.cafe.Controller.DB;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import gp8.itc.cafe.Controller.DataStructure.Drink;

@EnableJpaRepositories
public interface RepositoryDrink extends JpaRepository<Drink, Integer>{
        Optional<Drink> findByName(String name);
        // retrieve a list of drinks that belong to a specific category.
        @Query("SELECT d FROM drink_category dc JOIN drink d ON dc.category_id = d.drink_category_Id where dc.category_id=:category_id")
        List<Drink> findByCategory_id(@Param("category_id") int category_id);
}
