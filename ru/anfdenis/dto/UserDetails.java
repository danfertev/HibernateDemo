package ru.anfdenis.dto;

import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Denis Anfertev
 * 21.01.13 15:26
 */
@Entity
@SelectBeforeUpdate
public class UserDetails {
    @Id
    @GeneratedValue
    private int userId;
    private String userName;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
