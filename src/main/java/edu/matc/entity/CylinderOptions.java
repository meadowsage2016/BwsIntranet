package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

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
    private BigDecimal cylinderRent;
    private BigDecimal cylinderOnePPRent;
    private BigDecimal cylinderFiveYearLease;
    private BigDecimal cylinderPurchase;

    public CylinderOptions() {

    }

    public CylinderOptions(String gasNumber, String gasDescription, String cylinderCode, BigDecimal cylinderRent, BigDecimal cylinderOnePPRent, BigDecimal cylinderFiveYearLease, BigDecimal cylinderPurchase) {
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

    public BigDecimal getCylinderRent() {
        return cylinderRent;
    }

    public void setCylinderRent(BigDecimal cylinderRent) {
        this.cylinderRent = cylinderRent;
    }

    public BigDecimal getCylinderOnePPRent() {
        return cylinderOnePPRent;
    }

    public void setCylinderOnePPRent(BigDecimal cylinderOnePPRent) {
        this.cylinderOnePPRent = cylinderOnePPRent;
    }

    public BigDecimal getCylinderFiveYearLease() {
        return cylinderFiveYearLease;
    }

    public void setCylinderFiveYearLease(BigDecimal cylinderFiveYearLease) {
        this.cylinderFiveYearLease = cylinderFiveYearLease;
    }

    public BigDecimal getCylinderPurchase() {
        return cylinderPurchase;
    }

    public void setCylinderPurchase(BigDecimal cylinderPurchase) {
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
