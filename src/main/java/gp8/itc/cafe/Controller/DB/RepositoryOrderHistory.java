package gp8.itc.cafe.Controller.DB;
import org.springframework.data.jpa.repository.JpaRepository;
import gp8.itc.cafe.Controller.DataStructure.OrderHistory;

public interface RepositoryOrderHistory extends JpaRepository<OrderHistory, Integer>{
    
}
