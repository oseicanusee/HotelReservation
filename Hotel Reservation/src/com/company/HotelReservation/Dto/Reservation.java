package com.company.HotelReservation.Dto;

import java.util.Objects;

public class Reservation {
    private String firstName, lastName;
    private int numOfNights;
    private double dailyRate;


    public Reservation(String lastName, String firstName, int numOfNights, double dailyRate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numOfNights = numOfNights;
        this.dailyRate = dailyRate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getNumOfNights() {
        return numOfNights;
    }

    public void setNumOfNights(int numOfNights) {
        this.numOfNights = numOfNights;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public double getTotalPrice(){
        return this.dailyRate * this.numOfNights;
    }

    public String toString(){
        return this.firstName + " " + this.lastName + ", Length of stay =  " + this.numOfNights + ", Daily Rate = "
                + this.dailyRate +  ", Total cost = " + getTotalPrice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservation)) return false;
        Reservation that = (Reservation) o;
        return numOfNights == that.numOfNights && Double.compare(that.dailyRate, dailyRate) == 0 && firstName.equals(that.firstName) && lastName.equals(that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, numOfNights, dailyRate);
    }
}
