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
// le nom de table
@Table(name ="drink")
public class Drink {
    //Table
    @Id
    //generate the id automatically and increase the id too
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="drink_id")
    private int drink_id;

    @Column(name="drink_name")
    private String drinkName;

    @Column(name = "drink_size")
    private String drinkSize;

    @Column(name = "zone")
    private String zone;

    @Column(name="addons")
    private String addons;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drink_category_Id")
    private DrinkCategory category_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drink_size_id")
    private DrinkSize sizeId;

    public int getDrink_id() {
        return drink_id;
    }

    public void setDrink_id(int drink_id) {
        this.drink_id = drink_id;
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

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getAddons() {
        return addons;
    }

    public void setAddons(String addons) {
        this.addons = addons;
    }

    public DrinkCategory getCategory_id() {
        return category_id;
    }

    public void setCategory_id(DrinkCategory category_id) {
        this.category_id = category_id;
    }

    public DrinkSize getSize_id() {
        return sizeId;
    }

    public void setSize_id(DrinkSize sizeId) {
        this.sizeId = sizeId;
    }   
}
