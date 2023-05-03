// package gp8.itc.cafe.Controller.DataStructure;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.Table;

// @Entity
// @Table(name = "order_detail")
// public class Order_detail {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     @Column(name = "order_detailId")
//     private int id;

//     @JoinColumn(name = "order_id")
//     private Order order_id;

//     @Column(name = "drink_id")
//     private Drink drink_id;

//     @Column(name = "drink_sizeId")
//     private DrinkSize drink_sizeId;

//     @Column(name = "quantity")
//     private int quantity;

//     @Column(name = "price")
//     private double price;

//     //setter and getter
//     public int getId() {
//         return id;
//     }

//     public void setId(int id) {
//         this.id = id;
//     }

//     public Order getOrder_id() {
//         return order_id;
//     }

//     public void setOrder_id(Order order_id) {
//         this.order_id = order_id;
//     }

//     public Drink getDrink_id() {
//         return drink_id;
//     }

//     public void setDrink_id(Drink drink_id) {
//         this.drink_id = drink_id;
//     }

//     public DrinkSize getDrink_sizeId() {
//         return drink_sizeId;
//     }

//     public void setDrink_sizeId(DrinkSize drink_sizeId) {
//         this.drink_sizeId = drink_sizeId;
//     }

//     public int getQuantity() {
//         return quantity;
//     }

//     public void setQuantity(int quantity) {
//         this.quantity = quantity;
//     }

//     public double getPrice() {
//         return price;
//     }

//     public void setPrice(double price) {
//         this.price = price;
//     } 

// }
