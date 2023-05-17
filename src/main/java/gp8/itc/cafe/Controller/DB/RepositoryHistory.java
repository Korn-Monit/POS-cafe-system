package gp8.itc.cafe.Controller.DB;

import org.springframework.data.jpa.repository.JpaRepository;
import gp8.itc.cafe.Controller.DataStructure.History;
public interface RepositoryHistory extends JpaRepository<History, Integer>{
    
}
