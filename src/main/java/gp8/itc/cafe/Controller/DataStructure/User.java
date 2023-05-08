package gp8.itc.cafe.Controller.DataStructure;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {

    @Id
    //generate the id automatically and increase the id too
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int user_id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;


    @Column(name = "user_type")
    private String type;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Invoice> invoices;

    
    @OneToMany(mappedBy = "history_id", cascade = CascadeType.ALL)
    private List<History> history;


    public int getUser_id() {
        return user_id;
    }


    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public List<Invoice> getInvoices() {
        return invoices;
    }


    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }


    public List<History> getHistory() {
        return history;
    }


    public void setHistory(List<History> history) {
        this.history = history;
    }



}


