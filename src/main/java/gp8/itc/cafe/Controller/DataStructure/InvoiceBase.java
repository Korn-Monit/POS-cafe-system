// package gp8.itc.cafe.Controller.DataStructure;

// import java.util.List;

// import jakarta.persistence.CascadeType;
// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.OneToMany;
// import jakarta.persistence.Table;


// @Entity
// @Table(name = "invoice")
// public class InvoiceBase {

//     @Id
//     //generate the id automatically and increase the id too
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     @Column(name = "id")
//     private int id;

//     // @OneToMany(mappedBy = "receipt_id", cascade = CascadeType.ALL)
//     // private List<Receipt> receipts;

//     @Column(name = "drink")
//     private String drink;

//     @Column(name = "number")
//     private int number;

//     @Column(name = "price")
//     private double price;

//     @Column(name = "timestamp")
//     private String timestamp;

//     @Column(name = "status")
//     private String status;

//     @Column(name = "issueByCashier")
//     private String issueByCashier;

//     @Column(name = "branch")
//     private String branch;

//     @Column(name = "note")
//     private String note;

//     public int getId() {
//         return id;
//     }

//     public void setId(int id) {
//         this.id = id;
//     }

//     // public List<Receipt> getReceipts() {
//     //     return receipts;
//     // }

//     // public void setReceipts(List<Receipt> receipts) {
//     //     this.receipts = receipts;
//     // }

//     public String getDrink() {
//         return drink;
//     }

//     public void setDrink(String drink) {
//         this.drink = drink;
//     }

//     public int getNumber() {
//         return number;
//     }

//     public void setNumber(int number) {
//         this.number = number;
//     }

//     public double getPrice() {
//         return price;
//     }

//     public void setPrice(double price) {
//         this.price = price;
//     }

//     public String getTimestamp() {
//         return timestamp;
//     }

//     public void setTimestamp(String timestamp) {
//         this.timestamp = timestamp;
//     }

//     public String getStatus() {
//         return status;
//     }

//     public void setStatus(String status) {
//         this.status = status;
//     }

//     public String getIssueByCashier() {
//         return issueByCashier;
//     }

//     public void setIssueByCashier(String issueByCashier) {
//         this.issueByCashier = issueByCashier;
//     }

//     public String getBranch() {
//         return branch;
//     }

//     public void setBranch(String branch) {
//         this.branch = branch;
//     }

//     public String getNote() {
//         return note;
//     }

//     public void setNote(String note) {
//         this.note = note;
//     }


// }
