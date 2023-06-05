package gp8.itc.cafe.Controller.DB;
import org.springframework.data.jpa.repository.JpaRepository;
import gp8.itc.cafe.Controller.DataStructure.TableOrder;

public interface RepositoryTableOrder extends JpaRepository<TableOrder, Integer>{
    
}