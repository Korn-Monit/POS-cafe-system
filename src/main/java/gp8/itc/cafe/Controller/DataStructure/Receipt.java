// package gp8.itc.cafe.Controller.DataStructure;

// import jakarta.persistence.*;

// import java.util.Date;

// @Entity
// @Table(name = "receipt")
// public class Receipt {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     @Column(name = "id")
//     private int receiptId;

//     @ManyToOne
//     @JoinColumn(name = "invoice_id")
//     private Invoice invoiceId;

//     @ManyToOne
//     @JoinColumn(name = "user_id")
//     private User userId;

//     @ManyToOne
//     @JoinColumn(name = "drink_id")
//     private Drink drinkId;

//     @ManyToOne
//     @JoinColumn(name = "table_id")
//     private CafeTable table;

//     @Column(name = "cash_received")
//     private double cashReceived;

//     @Column(name = "change")
//     private double change;

//     @Column(name = "rate")
//     private double rate;

//     @Column(name = "date")
//     private Date date;

// }
