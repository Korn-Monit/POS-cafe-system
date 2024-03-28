package gp8.itc.cafe.Controller.DataStructure;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="Drink")
public class Drink {

    @Id
    //generate the id automatically and increase the id too
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="drink_id")
    private int drink_id;

    @Column(name = "price")
    private Float price;

    @Column(name="drink_name")
    private String drinkName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private DrinkCategory category_id;
    
    @Lob
    @Column(name = "image", length = 9000)
    private String image;

    // @ManyToMany(cascade = CascadeType.ALL)
    // @JoinTable(
    //     name = "drink_addon",
    //     joinColumns = @JoinColumn(name = "drink_id"),
    //     inverseJoinColumns = @JoinColumn(name = "addon_id")
    // )
    // private List<Addon> addons = new ArrayList<>();

    public int getDrink_id() {
        return drink_id;
    }

    public void setDrink_id(int drink_id) {
        this.drink_id = drink_id;
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

    public DrinkCategory getCategory_id() {
        return category_id;
    }

    public void setCategory_id(DrinkCategory category_id) {
        this.category_id = category_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
