// package gp8.itc.cafe.Controller.DataStructure;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;

// @Entity
// // le nom de table
// @Table(name ="drink")
// public class Drink {
//     //Table
//     @Id
//     //generate the id automatically and increase the id too
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     @Column(name="drink_id")
//     private int drink_id;

//     @Column(name="drink_name")
//     private String drinkName;

//     @Column(name = "drink_size")
//     private String drinkSize;

//     @Column(name = "zone")
//     private String zone;

//     @Column(name="addons")
//     private String addons;


//     //Setter and getter
//     public String getDrinkName(){
//         return drinkName;
//     }
//     public void setDrinkName(String drinkName){
//         this.drinkName = drinkName;
//     }

    
//     public String getDrinkSize(){
//         return drinkSize;
//     }
//     public void setDrinkSize(String drinkSize){
//         this.drinkSize = drinkSize;
//     }


//     public String getZone(){
//         return zone;
//     }
//     public void setZone(String zone){
//         this.zone = zone;
//     }


//     public String getAddons(){
//         return addons;
//     }
//     public void setAddons(String addons){
//         this.addons = addons;
//     }

    

// }
