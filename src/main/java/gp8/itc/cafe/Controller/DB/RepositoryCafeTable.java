package gp8.itc.cafe.Controller.DB;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import gp8.itc.cafe.Controller.DataStructure.CafeTable;

public interface RepositoryCafeTable extends JpaRepository<CafeTable, Integer>{
    // Optional<CafeTable> findById(int id);
}
