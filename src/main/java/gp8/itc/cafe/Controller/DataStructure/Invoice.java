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
@Table(name="invoice")
public class Invoice {
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

    @ManyToOne
    @JoinColumn(name = "table_id", referencedColumnName = "table_id")
    private CafeTable table_id;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "user_id")
    private User username;

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

    public CafeTable getTable_id() {
        return table_id;
    }

    public void setTable_id(CafeTable table_id) {
        this.table_id = table_id;
    }

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }
}
