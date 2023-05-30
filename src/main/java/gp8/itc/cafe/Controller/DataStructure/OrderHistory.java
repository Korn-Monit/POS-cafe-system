package gp8.itc.cafe.Controller.DataStructure;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name = "order_history")
public class OrderHistory {



    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "drink_id", referencedColumnName = "id")
    // private drink drink_id;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "drink_size_id", referencedColumnName = "id")
    // private drink_size drink_size_id;

    @Column(name = "drinkName")
    private String drinkName;

    @Column(name = "drinkSize")
    private String drinkSize;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private Float price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    
}
