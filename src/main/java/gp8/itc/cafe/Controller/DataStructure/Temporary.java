package gp8.itc.cafe.Controller.DataStructure;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="temporary")
public class Temporary {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "drink_id", referencedColumnName = "id")
    // private Drink drink_id;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "drink_size_id", referencedColumnName = "id")
    // private DrinkSize drink_size_id;

    // @ManyToOne
    // @JoinColumn(name = "table_id", referencedColumnName = "id")
    // private CafeTable table_id;

    // @ManyToOne
    // @JoinColumn(name = "username", referencedColumnName = "id")
    // private user username;

    @Column(name = "price")
    private Float price;

    @Column(name = "drinkName")
    private String drinkName;

    @Column(name = "drinkSize")
    private String drinkSize;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "total")
    private Float total;

    @Column(name = "changed")
    private Float changed;

    @Column(name = "table_id")
    private int table_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public String getDrinkSize() {
        return drinkSize;
    }

    public void setDrinkSize(String drinkSize) {
        this.drinkSize = drinkSize;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Float getChanged() {
        return changed;
    }

    public void setChanged(Float changed) {
        this.changed = changed;
    }

    public int getTable_id() {
        return table_id;
    }

    public void setTable_id(int table_id) {
        this.table_id = table_id;
    }

    
}
