package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Subdealers Class holds all information for subdealers
 * @author Susan Hundt
 */
@Entity
@Table(name="Subdealers")
public class Subdealers {


    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private int subdealerId;
    private String customerNumber;
    private String customerName;
    private String sbAddress1;
    private String sdAddress2;
    private String sdCity;
    private String sdState;
    private String sdZipCode;
    private String sdCounty;
    private String subdealerNotes;

    public Subdealers() {

    }

    public Subdealers(String customerNumber, String customerName, String sbAddress1, String sdAddress2, String sdCity, String sdState, String sdZipCode, String sdCounty, String subdealerNotes) {
        super();
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.sbAddress1 = sbAddress1;
        this.sdAddress2 = sdAddress2;
        this.sdCity = sdCity;
        this.sdState = sdState;
        this.sdZipCode = sdZipCode;
        this.sdCounty = sdCounty;
        this.subdealerNotes = subdealerNotes;
    }
    public int getSubdealerId() {
        return subdealerId;
    }

    public void setSubdealerId(int subdealerId) {
        this.subdealerId = subdealerId;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSbAddress1() {
        return sbAddress1;
    }

    public void setSbAddress1(String sbAddress1) {
        this.sbAddress1 = sbAddress1;
    }

    public String getSdAddress2() {
        return sdAddress2;
    }

    public void setSdAddress2(String sdAddress2) {
        this.sdAddress2 = sdAddress2;
    }

    public String getSdCity() {
        return sdCity;
    }

    public void setSdCity(String sdCity) {
        this.sdCity = sdCity;
    }

    public String getSdState() {
        return sdState;
    }

    public void setSdState(String sdState) {
        this.sdState = sdState;
    }

    public String getSdZipCode() {
        return sdZipCode;
    }

    public void setSdZipCode(String sdZipCode) {
        this.sdZipCode = sdZipCode;
    }

    public String getSdCounty() {
        return sdCounty;
    }

    public void setSdCounty(String sdCounty) {
        this.sdCounty = sdCounty;
    }

    public String getSubdealerNotes() {
        return subdealerNotes;
    }

    public void setSubdealerNotes(String subdealerNotes) {
        this.subdealerNotes = subdealerNotes;
    }


    @Override
    public String toString() {
        return "Subdealers{" +
                "subdealerId=" + subdealerId +
                ", customerNumber='" + customerNumber + '\'' +
                ", customerName='" + customerName + '\'' +
                ", sbAddress1='" + sbAddress1 + '\'' +
                ", sdAddress2='" + sdAddress2 + '\'' +
                ", sdCity='" + sdCity + '\'' +
                ", sdState='" + sdState + '\'' +
                ", sdZipCode='" + sdZipCode + '\'' +
                ", sdCounty='" + sdCounty + '\'' +
                ", subdealerNotes='" + subdealerNotes + '\'' +
                '}';
    }
}
