package converter.entity;



import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity

public class Convertation {

    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    private int convertationnumber;

    private String valutefrom;

    private String valuteto;

    private  int valutefromid;

    private  int valutetoid;

    private double valutefromvalue;

    private double valutetovalue;

    private String convertationday;

    private String valutefromcharcode;

    private String valutetocharcode;

    private double number;

    private double result;

    public Convertation() {
    }

    public Convertation (int convertationnumber, String valutefrom, String valuteto, int valutefromid, int valutetoid,
                         double valutefromvalue, double valutetovalue, String convertationday, String valutefromcharcode,
                         String valutetocharcode, double number, double result) {

        this.convertationnumber = convertationnumber;
        this.valutefrom = valutefrom;
        this.valuteto = valuteto;
        this.valutefromid = valutefromid;
        this.valutetoid = valutetoid;
        this.valutefromvalue = valutefromvalue;
        this.valutetovalue = valutetovalue;
        this.convertationday = convertationday;
        this.valutefromcharcode = valutefromcharcode;
        this.valutetocharcode = valutetocharcode;
        this.number = number;
        this.result = result;

    }

    public int getConvertationnumber() {
        return convertationnumber;
    }

    public String getValutefrom() {
        return valutefrom;
    }

    public String getValuteto() {
        return valuteto;
    }

    public int getValutefromid() {
        return valutefromid;
    }

    public int getValutetoid() {
        return valutetoid;
    }

    public double getValutefromvalue() {
        return valutefromvalue;
    }

    public double getValutetovalue() {
        return valutetovalue;
    }

    public String getConvertationday() {
        return convertationday;
    }

    public String getValutefromcharcode() {
        return valutefromcharcode;
    }

    public String getValutetocharcode() {
        return valutetocharcode;
    }

    public double getNumber() {
        return number;
    }

    public void setConvertationnumber(int convertationnumber) {
        this.convertationnumber = convertationnumber;
    }

    public void setValutefrom(String valutefrom) {
        this.valutefrom = valutefrom;
    }

    public void setValuteto(String valuteto) {
        this.valuteto = valuteto;
    }

    public void setValutefromid(int valutefromid) {
        this.valutefromid = valutefromid;
    }

    public void setValutetoid(int valutetoid) {
        this.valutetoid = valutetoid;
    }

    public void setValutefromvalue(double valutefromvalue) {
        this.valutefromvalue = valutefromvalue;
    }

    public void setValutetovalue(double valutetovalue) {
        this.valutetovalue = valutetovalue;
    }

    public void setConvertationday(String convertationday) {
        this.convertationday = convertationday;
    }

    public void setValutefromcharcode(String valutefromcharcode) {
        this.valutefromcharcode = valutefromcharcode;
    }

    public void setValutetocharcode(String valutetocharcode) {
        this.valutetocharcode = valutetocharcode;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public Convertation(String valutefrom, String valuteto, int valutefromid, int valutetoid, double valutefromvalue, double valutetovalue,
                        String convertationday, String valutefromcharcode, String valutetocharcode, double number, double result) {
        this.valutefrom = valutefrom;
        this.valuteto = valuteto;
        this.valutefromid = valutefromid;
        this.valutetoid = valutetoid;
        this.valutefromvalue = valutefromvalue;
        this.valutetovalue = valutetovalue;
        this.convertationday = convertationday;
        this.valutefromcharcode = valutefromcharcode;
        this.valutetocharcode = valutetocharcode;
        this.number = number;
        this.result = result;
    }

    @Override
    public String toString() {
        return "Convertation{" +
                "convertationnumber=" + convertationnumber +
                ", valutefrom='" + valutefrom + '\'' +
                ", valuteto='" + valuteto + '\'' +
                ", valutefromid=" + valutefromid +
                ", valutetoid=" + valutetoid +
                ", valutefromvalue=" + valutefromvalue +
                ", valutetovalue=" + valutetovalue +
                ", convertationday='" + convertationday + '\'' +
                ", valutefromcharcode='" + valutefromcharcode + '\'' +
                ", valutetocharcode='" + valutetocharcode + '\'' +
                ", number=" + number +
                ", result=" + result +
                '}';
    }
}
