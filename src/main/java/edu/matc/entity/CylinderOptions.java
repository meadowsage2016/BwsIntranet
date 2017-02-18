package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CylinderOptions Class holds all information for individual gas types
 * @author Susan Hundt
 */
@Entity
@Table(name="CylinderOptions")
public class CylinderOptions {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private int cylinderOptionId;
    private String gasNumber;
    private String  gasDescription;
    private String cylinderCode;
    private Double cylinderRent;
    private Double cylinderOnePPRent;
    private Double cylinderFiveYearLease;
    private Double cylinderPurchase;

    public CylinderOptions() {

    }

    public CylinderOptions(String gasNumber, String gasDescription, String cylinderCode, Double cylinderRent, Double cylinderOnePPRent, Double cylinderFiveYearLease, Double cylinderPurchase) {
        super();
        this.gasNumber = gasNumber;
        this.gasDescription = gasDescription;
        this.cylinderCode = cylinderCode;
        this.cylinderRent = cylinderRent;
        this.cylinderOnePPRent = cylinderOnePPRent;
        this.cylinderFiveYearLease = cylinderFiveYearLease;
        this.cylinderPurchase = cylinderPurchase;
    }

    public String getGasNumber() {
        return gasNumber;
    }

    public void setGasNumber(String gasNumber) {
        this.gasNumber = gasNumber;
    }

    public String getGasDescription() {
        return gasDescription;
    }

    public void setGasDescription(String gasDescription) {
        this.gasDescription = gasDescription;
    }

    public String getCylinderCode() {
        return cylinderCode;
    }

    public void setCylinderCode(String cylinderCode) {
        this.cylinderCode = cylinderCode;
    }

    public Double getCylinderRent() {
        return cylinderRent;
    }

    public void setCylinderRent(Double cylinderRent) {
        this.cylinderRent = cylinderRent;
    }

    public Double getCylinderOnePPRent() {
        return cylinderOnePPRent;
    }

    public void setCylinderOnePPRent(Double cylinderOnePPRent) {
        this.cylinderOnePPRent = cylinderOnePPRent;
    }

    public Double getCylinderFiveYearLease() {
        return cylinderFiveYearLease;
    }

    public void setCylinderFiveYearLease(Double cylinderFiveYearLease) {
        this.cylinderFiveYearLease = cylinderFiveYearLease;
    }

    public Double getCylinderPurchase() {
        return cylinderPurchase;
    }

    public void setCylinderPurchase(Double cylinderPurchase) {
        this.cylinderPurchase = cylinderPurchase;
    }



    @Override
    public String toString() {
        return "CylinderOptions{" +
                "cylinderOptionId=" + cylinderOptionId +
                ", gasNumber='" + gasNumber + '\'' +
                ", gasDescription='" + gasDescription + '\'' +
                ", cylinderCode='" + cylinderCode + '\'' +
                ", cylinderRent=" + cylinderRent +
                ", cylinderOnePPRent=" + cylinderOnePPRent +
                ", cylinderFiveYearLease=" + cylinderFiveYearLease +
                ", cylinderPurchase=" + cylinderPurchase +
                '}';
    }
}
