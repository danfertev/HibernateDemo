package ru.anfdenis.dto;

import javax.persistence.Entity;

/**
 * Denis Anfertev
 * 23.01.13 16:59
 */
@Entity
public class TwoWheeler extends Vehicle {
    private String SteeringHandle;

    public String getSteeringHandle() {
        return SteeringHandle;
    }

    public void setSteeringHandle(String steeringHandle) {
        SteeringHandle = steeringHandle;
    }
}
