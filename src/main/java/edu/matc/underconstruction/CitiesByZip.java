package edu.matc.underconstruction;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by student on 3/16/17.
 */
@Entity
@Table(name="CitiesByZip")
public class CitiesByZip {


    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private int citiesByZipId;
    private String zipCode;
    private String cityName;
    private String countyNumber;
    private String salesmanNumber;

    public CitiesByZip() {

    }

    public CitiesByZip(String zipCode, String cityName, String countyNumber, String salesmanNumber) {
        super();
        this.zipCode = zipCode;
        this.cityName = cityName;
        this.countyNumber = countyNumber;
        this.salesmanNumber = salesmanNumber;
    }

    public int getCitiesByZipId() {
        return citiesByZipId;
    }

    public void setCitiesByZipId(int CitiesByZipId) {
        citiesByZipId = CitiesByZipId;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountyNumber() {
        return countyNumber;
    }

    public void setCountyNumber(String countyNumber) {
        this.countyNumber = countyNumber;
    }

    public String getSalesmanNumber() {
        return salesmanNumber;
    }

    public void setSalesmanNumber(String salesmanNumber) {
        this.salesmanNumber = salesmanNumber;
    }

    @Override
    public String toString() {
        return "CitiesByZip{" +
                "CitiesByZipId=" + citiesByZipId +
                ", zipCode='" + zipCode + '\'' +
                ", cityName='" + cityName + '\'' +
                ", countyNumber='" + countyNumber + '\'' +
                ", salesmanNumber='" + salesmanNumber + '\'' +
                '}';
    }
}
