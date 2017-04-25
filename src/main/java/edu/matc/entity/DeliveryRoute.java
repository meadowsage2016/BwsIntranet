package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DeliveryRoute Class holds all information for individual cities and business delivery dates
 * @author Susan Hundt
 */
@Entity
@Table(name="DeliveryRoute")
public class DeliveryRoute {



    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private int deliveryRouteId;
    private String deliveryCityOrBusiness;
    private String deliveryDay;
    private String deliveryFrequency;

    public DeliveryRoute() {

    }

    public int getDeliveryRouteId() {
        return deliveryRouteId;
    }

    public void setDeliveryRouteId(int deliveryRouteId) {
        this.deliveryRouteId = deliveryRouteId;
    }
    public DeliveryRoute(String deliveryCityOrBusiness, String deliveryDay, String deliveryFrequency) {
        super();
        this.deliveryCityOrBusiness = deliveryCityOrBusiness;
        this.deliveryDay = deliveryDay;
        this.deliveryFrequency = deliveryFrequency;
    }

    public String getDeliveryCityOrBusiness() {
        return deliveryCityOrBusiness;
    }

    public void setDeliveryCityOrBusiness(String deliveryCityOrBusiness) {
        this.deliveryCityOrBusiness = deliveryCityOrBusiness;
    }

    public String getDeliveryDay() {
        return deliveryDay;
    }

    public void setDeliveryDay(String deliveryDay) {
        this.deliveryDay = deliveryDay;
    }

    public String getDeliveryFrequency() {
        return deliveryFrequency;
    }

    public void setDeliveryFrequency(String deliveryFrequency) {
        this.deliveryFrequency = deliveryFrequency;
    }


    @Override
    public String toString() {
        return "DeliveryRoute{" +
                "deliveryRouteId=" + deliveryRouteId +
                ", deliveryCityOrBusiness='" + deliveryCityOrBusiness + '\'' +
                ", deliveryDay='" + deliveryDay + '\'' +
                ", deliveryFrequency='" + deliveryFrequency + '\'' +
                '}';
    }
}
