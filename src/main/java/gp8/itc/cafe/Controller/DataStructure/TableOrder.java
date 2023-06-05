package gp8.itc.cafe.Controller.DataStructure;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="table_order")
public class TableOrder {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "table_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderHistory> order;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<OrderHistory> getOrder() {
        return order;
    }

    public void setOrder(List<OrderHistory> order) {
        this.order = order;
    }

    



    


}
