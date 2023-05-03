// package gp8.itc.cafe.Controller.DataStructure;

// import java.util.ArrayList;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;
// import jakarta.persistence.Column;

// @Entity
// @Table(name = "history")
// public class History<Receipt> {

//     @Id
//     @GeneratedValue(strategy= GenerationType.IDENTITY)
//     @Column(name = "history_id")
//     private int history_id;

//     @Column(name = "description")
//     private String description;

//     @JoinColumn(name = "user_id");
    
//     @JoinColumn(name = "table_id");

//     @Column(name="list_of_receipts")
//     ArrayList<Receipt> history = new ArrayList<>();
// }
