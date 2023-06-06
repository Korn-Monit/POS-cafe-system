package gp8.itc.cafe.Controller.DataStructure;

import java.math.BigDecimal;

public class OrderData {
    private String drinkName;
    private String selectedSize;
    private int quantity;
    private BigDecimal price;
    
    public String getDrinkName() {
        return drinkName;
    }
    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }
    
    public String getSelectedSize() {
        return selectedSize;
    }
    public void setSelectedSize(String selectedSize) {
        this.selectedSize = selectedSize;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    } 
}
