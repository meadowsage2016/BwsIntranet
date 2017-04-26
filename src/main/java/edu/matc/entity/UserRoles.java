package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User Roles Class holds all information for users of BwsIntranet
 * @author Susan Hundt
 */
@Entity
@Table(name="user_roles")
public class UserRoles {


    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private int user_roles_Id;
    private String user_name;
    private String role_name;

    public UserRoles (){

    }

    public UserRoles(String user_name, String role_name) {
        this.user_name = user_name;
        this.role_name = role_name;
    }

    public int getUser_roles_Id() {
        return user_roles_Id;
    }

    public void setUser_roles_Id(int user_roles_Id) {
        this.user_roles_Id = user_roles_Id;
    }
    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    @Override
    public String toString() {
        return "UserRoles{" +
                "user_roles_id=" + user_roles_Id +
                ", user_name='" + user_name + '\'' +
                ", role_name='" + role_name + '\'' +
                '}';
    }
}
