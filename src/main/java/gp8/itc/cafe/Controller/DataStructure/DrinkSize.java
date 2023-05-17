package gp8.itc.cafe.Controller.DataStructure;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="drink_size")
public class DrinkSize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int drink_sizeId;

    @OneToMany(mappedBy = "sizeId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Drink> drink;

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

    public List<Drink> getDrink() {
        return drink;
    }

    public void setDrink(List<Drink> drink) {
        this.drink = drink;
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
