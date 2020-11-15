package converter.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

@Entity
public class Course {

    @Id
    private int id;

    private String charcode;

    private int nominal;

    private String valutename;

    private double valutevalue;

    private String today;

    public Course(int id, String charcode, int nominal, String valutename, double valutevalue, String today) {

        this.id = id;
        this.charcode = charcode;
        this.nominal = nominal;
        this.valutename = valutename;
        this.valutevalue = valutevalue;
        this.today = today;

    }

    public Course() {  }

    public String getToday() {
        return today;
    }

    public void setToday(String today) {
        this.today = today;
    }

    public int getId() {
        return id;
    }

    public String getCharcode() {
        return charcode;
    }

    public int getNominal() {
        return nominal;
    }

    public String getValutename() {
        return valutename;
    }

    public double getValutevalue() {
        return valutevalue;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCharcode(String charcode) {
        this.charcode = charcode;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public void setValutename(String valutename) {
        this.valutename = valutename;
    }

    public void setValutevalue(double valutevalue) {
        this.valutevalue = valutevalue;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", charcode='" + charcode + '\'' +
                ", nominal=" + nominal +
                ", valutename='" + valutename + '\'' +
                ", valutevalue=" + valutevalue +
                ", today='" + today + '\'' +
                '}';
    }
}
