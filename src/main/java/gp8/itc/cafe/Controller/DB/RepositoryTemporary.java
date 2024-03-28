package gp8.itc.cafe.Controller.DB;
import org.springframework.data.jpa.repository.JpaRepository;
import gp8.itc.cafe.Controller.DataStructure.Temporary;

public interface RepositoryTemporary extends JpaRepository<Temporary, Integer>{
    
}