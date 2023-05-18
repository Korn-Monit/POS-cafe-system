package gp8.itc.cafe.Controller.DataStructure;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "user_type")
    private String type;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String sex;

    @Column(name = "date_of_birth")
    private String dob;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Invoice> invoices;
    
    @OneToMany(mappedBy = "history_id", cascade = CascadeType.ALL)
    private List<History> history;

    // @Lob
    // @Column(name = "image", length = 9000)
    // private String cashierImage;

    // public String getImage() {
    //     return cashierImage;
    // }


    // public void setImage(String cashierImage) {
    //     this.cashierImage = cashierImage;
    // }



    public int getUser_id() {
        return user_id;
    }


    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
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


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getSex() {
        return sex;
    }


    public void setSex(String sex) {
        this.sex = sex;
    }


    public String getDob() {
        return dob;
    }


    public void setDob(String dob) {
        this.dob = dob;
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


