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
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
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


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drink_category_Id")
    private DrinkCategory category_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drink_size_id")
    private DrinkSize sizeId;

    @Lob
    @Column(name = "image", length = 9000)
    private String image;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "drink_addon",
        joinColumns = @JoinColumn(name = "drink_id"),
        inverseJoinColumns = @JoinColumn(name = "addon_id")
    )
    private List<Addon> addons = new ArrayList<>();

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

    public DrinkCategory getCategory_id() {
        return category_id;
    }

    public void setCategory_id(DrinkCategory category_id) {
        this.category_id = category_id;
    }

    public DrinkSize getSizeId() {
        return sizeId;
    }

    public void setSizeId(DrinkSize sizeId) {
        this.sizeId = sizeId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Addon> getAddons() {
        return addons;
    }

    public void setAddons(List<Addon> addons) {
        this.addons = addons;
    }


}
