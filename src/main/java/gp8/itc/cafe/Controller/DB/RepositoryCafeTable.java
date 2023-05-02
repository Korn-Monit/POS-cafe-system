package gp8.itc.cafe.Controller.DB;

import org.springframework.data.jpa.repository.JpaRepository;

import gp8.itc.cafe.Controller.DataStructure.CafeTable;

public interface RepositoryCafeTable extends JpaRepository<CafeTable, Integer>{
    
}
