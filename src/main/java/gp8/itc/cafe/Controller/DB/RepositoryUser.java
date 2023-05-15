package gp8.itc.cafe.Controller.DB;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gp8.itc.cafe.Controller.DataStructure.User;


// The repository extends the JpaRepository interface, which provides several CRUD methods out-of-the-box for interacting with the database.
@Repository
public interface RepositoryUser extends JpaRepository<User, String>{
        User getUserByUsername(String username);

        // Create
        // User save(User user);

        // // Read
        //Optional<User> findById(int id);
        // List<User> findAll();
        
        // // Update
        // User saveAndFlush(User user);
    
        // // Delete
        // void delete(User user);
        // void deleteById(String id);
}
