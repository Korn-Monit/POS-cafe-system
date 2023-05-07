package gp8.itc.cafe.Controller.DataStructure;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="drink_size")
public class DrinkSize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int drink_sizeId;

    @ManyToOne
    @JoinColumn(name="drink_id")
    private Drink drink_id;

    @Column(name = "size")
    private String size;

    @Column(name = "price")
    private double price;


    public int getDrink_sizeId() {
        return drink_sizeId;
    }
    public void setDrink_sizeId(int drink_sizeId) {
        this.drink_sizeId = drink_sizeId;
    }


    public Drink getDrink_id() {
        return drink_id;
    }
    public void setDrink_id(Drink drink_id) {
        this.drink_id = drink_id;
    }


    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }


    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
