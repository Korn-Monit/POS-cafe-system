package gp8.itc.cafe.Controller.DataStructure;

import java.math.BigDecimal;
import java.util.Optional;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drink_id", referencedColumnName = "drink_id")
    private Drink drink_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drink_size_id", referencedColumnName = "drink_sizeId")
    private DrinkSize drink_size_id;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "table_id", referencedColumnName = "table_id")
    // private Optional<CafeTable> table_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username", referencedColumnName = "user_id")
    private User username;

    @Column(name = "price")
    private BigDecimal price;

    public Drink getDrink_id() {
        return drink_id;
    }

    public void setDrink_id(Drink drink_id) {
        this.drink_id = drink_id;
    }

    public DrinkSize getDrink_size_id() {
        return drink_size_id;
    }

    public void setDrink_size_id(DrinkSize drink_size_id) {
        this.drink_size_id = drink_size_id;
    }

    // public Optional<CafeTable> getTable_id() {
    //     return table_id;
    // }

    // public void setTable_id(Optional<CafeTable> table_id) {
    //     this.table_id = table_id;
    // }

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }

    @Column(name = "drinkName")
    private String drinkName;

    @Column(name = "drinkSize")
    private String drinkSize;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "changed")
    private BigDecimal changed;

    @Column(name = "table_id")
    private Integer tableId;

    public Integer getTableId() {
        return tableId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "table_id", referencedColumnName = "table_id", insertable = false, updatable = false)
    private CafeTable table;
    
    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }
    
    public Optional<CafeTable> getTable() {
        return Optional.ofNullable(table);
    }
    
    public void setTable(Optional<CafeTable> table) {
        this.table = table.orElse(null);
        this.tableId = table.map(CafeTable::getTable_id).orElse(null);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
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

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getChanged() {
        return changed;
    }

    public void setChanged(BigDecimal changed) {
        this.changed = changed;
    }

    // public Optional<CafeTable> getTable_id() {
    //     return table_id;
    // }

    // public void setTable_id(Optional<CafeTable> table_id) {
    //     this.table_id = table_id;
    // }

  
}
