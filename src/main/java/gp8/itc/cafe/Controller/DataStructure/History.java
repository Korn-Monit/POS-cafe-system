package gp8.itc.cafe.Controller.DataStructure;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

@Entity
@Table(name = "history")
public class History{
    //note that this is history of cashier, not admin
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int history_id;

    @Column(name = "table_number")
    private int tableNumber;

    @Column(name = "price")
    private int price;

    @Column(name = "date")
    private String date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userId;


    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Invoice> invoices;


    public int getHistory_id() {
        return history_id;
    }


    public void setHistory_id(int history_id) {
        this.history_id = history_id;
    }


    public int getTableNumber() {
        return tableNumber;
    }


    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }


    public int getPrice() {
        return price;
    }


    public void setPrice(int price) {
        this.price = price;
    }


    public String getDate() {
        return date;
    }


    public void setDate(String date) {
        this.date = date;
    }


    public User getUserId() {
        return userId;
    }


    public void setUserId(User userId) {
        this.userId = userId;
    }


    public List<Invoice> getInvoices() {
        return invoices;
    }


    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    
}
