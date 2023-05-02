// package gp8.itc.cafe.Controller.DataStructure;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;

// @Entity
// @Table(name="receipt")
// public class Receipt extends Invoice{

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)

//     @Column(name="receipt_id")
//     private int receiptId;

//     @Column(name="number")
//     private int invoiceNumber;

//     @Column(name="drink_name")
//     private String drinkName;

//     @Column(name = "table")
//     private String tableInOut;

//     @Column(name = "price")
//     private double price;

//     @Column(name = "order_date_time")
//     private String orderDateTime;

//     @Column(name = "issue_by")
//     private boolean issueBy;

//     @Column(name = "branch")
//     private String branch;

//     @Column(name = "note")
//     private String note;

//     @Column(name = "cash_received")
//     private double cashReceived;

//     @Column(name="change")
//     private double change;

//     @Column(name = "rate")
//     private double rate;

//     @Column(name = "receipt_date_time")
//     private String receiptDateTime;


//     //setter and getter
//     public int getInvoiceNumber(){
//         return invoiceNumber;
//     }
//     public void setDrinkName(int invoiceNumber){
//         this.invoiceNumber = invoiceNumber;
//     }


//     public String getDrinkName(){
//         return drinkName;
//     }
//     public void setDrinkName(String drinkName){
//         this.drinkName = drinkName;
//     }

    
//     public String getTableInOut(){
//         return tableInOut;
//     }
//     public void setTableInOut(String tableInOut){
//         this.tableInOut = tableInOut;
//     }


//     public double getPrice(){
//         return price;
//     }
//     public void setPrice(double price){
//         this.price = price;
//     }


//     public String getOrderDateTime(){
//         return orderDateTime;
//     }
//     public void setOrderDateTime(String orderDateTime){
//         this.orderDateTime = orderDateTime;
//     }


//     public boolean getIssueBy(){
//         return issueBy;
//     }
//     public void setIssueBy(boolean issueBy){
//         this.issueBy = issueBy;
//     }


//     public String getBranch(){
//         return branch;
//     }
//     public void setBranch(String branch){
//         this.branch = branch;
//     }

//     public String getNote(){
//         return note;
//     }
//     public void setNote(String note){
//         this.note = note;
//     }

//     public double getCashReceived(){
//         return cashReceived;
//     }
//     public void setCashReceived(double cashReceived){
//         this.cashReceived = cashReceived;
//     }

//     public double getChange(){
//         return change;
//     }
//     public void setChange(double change){
//         this.change = change;
//     }

//     public double getRate(){
//         return rate;
//     }
//     public void setRate(double rate){
//         this.rate = rate;
//     }

//     public String getReceipt(){
//         return receiptDateTime;
//     }
//     public void setReceiptDateTime(String receiptDateTime){
//         this.receiptDateTime = receiptDateTime;
//     }

// }
