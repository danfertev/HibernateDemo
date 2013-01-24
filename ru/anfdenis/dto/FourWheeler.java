package ru.anfdenis.dto;

import javax.persistence.Entity;

/**
 * Denis Anfertev
 * 23.01.13 17:00
 */
@Entity
public class FourWheeler extends Vehicle {
    private String SteeringWheel;

    public String getSteeringWheel() {
        return SteeringWheel;
    }

    public void setSteeringWheel(String steeringWheel) {
        SteeringWheel = steeringWheel;
    }
}
