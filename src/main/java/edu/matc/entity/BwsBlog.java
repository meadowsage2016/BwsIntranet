package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.print.attribute.standard.DateTimeAtCompleted;
import java.sql.Timestamp;

/**
 * BwsBlog Class holds all information for individual blog entries
 * @author Susan Hundt
 */
@Entity
@Table(name="BwsBlog")
public class BwsBlog {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private int blogId;
    private String blogUser;
    private Timestamp blogDateTime;
    private String blogText;

    public BwsBlog() {

    }

    public BwsBlog(String blogUser, Timestamp blogDateTime, String blogText) {
        this.blogUser = blogUser;
        this.blogDateTime = blogDateTime;
        this.blogText = blogText;
    }

    public String getBlogUser() {
        return blogUser;
    }

    public void setBlogUser(String blogUser) {
        this.blogUser = blogUser;
    }

    public Timestamp getBlogDateTime() {
        return blogDateTime;
    }

    public void setBlogDateTime(Timestamp blogDateTime) {
        this.blogDateTime = blogDateTime;
    }

    public String getBlogText() {
        return blogText;
    }

    public void setBlogText(String blogText) {
        this.blogText = blogText;
    }

    @Override
    public String toString() {
        return "BwsBlog{" +
                "blogId=" + blogId +
                ", blogUser='" + blogUser + '\'' +
                ", blogDateTime=" + blogDateTime +
                ", blogText='" + blogText + '\'' +
                '}';
    }
}
