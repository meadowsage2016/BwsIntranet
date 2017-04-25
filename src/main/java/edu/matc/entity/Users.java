package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Users Class holds all information for users of BwsIntranet
 * @author Susan Hundt
 */
@Entity
@Table(name="users")
public class Users {


    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private int user_id;
    private String user_name;
    private String user_pass;

    public Users (){

    }

    public Users(String user_name, String user_pass) {
        this.user_name = user_name;
        this.user_pass = user_pass;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    @Override
    public String toString() {
        return "Users{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_pass='" + user_pass + '\'' +
                '}';
    }
}
