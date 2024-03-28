package gp8.itc.cafe.Controller.DB;

import org.springframework.data.jpa.repository.JpaRepository;
import gp8.itc.cafe.Controller.DataStructure.User;


// The repository extends the JpaRepository interface, which provides several CRUD methods out-of-the-box for interacting with the database.
//Integer here represents primary key of user entity
public interface RepositoryUser extends JpaRepository<User, Integer>{
        User getUserByUsername(String username);
}
