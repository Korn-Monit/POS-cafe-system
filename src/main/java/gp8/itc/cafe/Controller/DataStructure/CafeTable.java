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
// le nom de table
@Table(name ="cafe_table")
public class CafeTable {
    //Table
    @Id
    //generate the id automatically and increase the id too
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int table_id;

    @Column(name = "number")
    int tablenumber;

    @Column(name = "availability")
    int availability;

    // @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    // private List<Invoice> invoices;

    public int getTable_id() {
        return table_id;
    }

    public void setTable_id(int table_id) {
        this.table_id = table_id;
    }

    public int getTablenumber() {
        return tablenumber;
    }

    public void setTablenumber(int tablenumber) {
        this.tablenumber = tablenumber;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    // public List<Invoice> getInvoices() {
    //     return invoices;
    // }

    // public void setInvoices(List<Invoice> invoices) {
    //     this.invoices = invoices;
    // }



    //Setter and getter

}