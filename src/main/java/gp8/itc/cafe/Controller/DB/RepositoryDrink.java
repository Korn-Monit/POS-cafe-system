package gp8.itc.cafe.Controller.DB;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gp8.itc.cafe.Controller.DataStructure.Drink;
@Repository
@EnableJpaRepositories
public interface RepositoryDrink extends JpaRepository<Drink, Integer>{
        // Optional<Drink> findByName(String name);
        // retrieve a list of drinks that belong to a specific category.
        @Query("SELECT d FROM Drink d WHERE d.category_id.drink_categoryId = :category_id")
        List<Drink> findByCategoryID(@Param("category_id") int category_id);
}
