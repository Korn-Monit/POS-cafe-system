package gp8.itc.cafe.Controller.DataStructure;

public class OrderData {
    private String drinkName;
    private String selectedSize;
    private int quantity;
    private Float price;
    
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
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    } 
}
