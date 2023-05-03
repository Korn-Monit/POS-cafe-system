// package gp8.itc.cafe.Controller.DataStructure;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.Table;

// @Entity
// @Table(name="order")
// public class Order {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     @Column(name="order_id")
//     private int order_id;

//     @JoinColumn(name = "user_id")
//     private User userId;

//     @JoinColumn(name = "table_id")
//     private User tableId;

//     @Column(name = "timestamp")
//     private String timestamp;

//     @Column(name = "status")
//     private String status;

    
//     public int getOrder_id() {
//         return order_id;
//     }

//     public void setOrder_id(int order_id) {
//         this.order_id = order_id;
//     }

//     public User getUserId() {
//         return userId;
//     }

//     public void setUserId(User userId) {
//         this.userId = userId;
//     }

//     public User getTableId() {
//         return tableId;
//     }

//     public void setTableId(User tableId) {
//         this.tableId = tableId;
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

    
// }
