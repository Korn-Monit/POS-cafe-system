package gp8.itc.cafe.Controller.DataStructure;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {

    //Table
    @Id
    //generate the id automatically and increase the id too
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int user_id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    // @Enumerated(EnumType.STRING)
    @Column(name = "user_type")
    private String type;
    // private UserType type;

    // public UserType getType() {
    //     return type;
    // }
    // public void setType(UserType type) {
    //     this.type = type;
    // }

    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
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


    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    // public enum UserType{
    //     Admin,
    //     Cashier,
    // };
}


