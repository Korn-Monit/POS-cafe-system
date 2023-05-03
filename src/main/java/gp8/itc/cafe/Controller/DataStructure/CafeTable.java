package gp8.itc.cafe.Controller.DataStructure;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
// le nom de table
@Table(name ="cafe_table")
public class CafeTable {
    //Table
    @Id
    //generate the id automatically and increase the id too
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="table_id")
    int table_id;

    @Column(name = "number")
    double tablenumber;

    @Column(name = "availability")
    double availability;



    //Setter and getter
    public int getId(){
        return table_id;
    }
    public void setTableId(int table_id){
        this.table_id = table_id;
    }

    
    public double getTableNumber(){
        return tablenumber;
    }
    public void setTableNumber(double tablenumber){
        this.tablenumber = tablenumber;
    }
    

    public double getAvaiabilitye(){
        return availability;
    }

    public void setAvaiability(double availability){
        this.availability = availability;
    }
}